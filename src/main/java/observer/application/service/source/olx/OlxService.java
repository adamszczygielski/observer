package observer.application.service.source.olx;

import com.google.common.cache.LoadingCache;
import lombok.RequiredArgsConstructor;
import observer.application.model.Category;
import observer.application.model.Item;
import observer.application.model.Search;
import observer.application.model.Source;
import observer.application.rest.JsonMapper;
import observer.application.rest.RestInvoker;
import observer.application.service.source.SourceService;
import observer.application.service.source.olx.mapper.OlxMapper;
import observer.application.service.source.olx.model.Ad;
import observer.application.service.source.olx.model.ListingResponse;
import observer.application.service.source.olx.model.Price;
import observer.application.service.source.olx.model.RegularPrice;
import org.apache.commons.text.StringEscapeUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OlxService extends SourceService {

    private static final String JSON_BEGIN_PATTERN = "window.__PRERENDERED_STATE__= \"";
    private static final String JSON_END_PATTERN = "\\\"cookies\\\":{}}";
    private static final short STRICT_FILTER_THRESHOLD = 5;

    private final OlxMapper olxMapper = new OlxMapper();
    private final JsonMapper jsonMapper;
    private final LoadingCache<String, List<Category>> categoryCache;
    private final RestInvoker restInvoker;

    @Override
    public Source getSource() {
        return Source.OLX;
    }

    @Override
    public long getDelaySeconds() {
        return applicationConfig.getOlxDelaySeconds();
    }

    @Override
    public List<Category> fetchCategories(String parentId) {
        return categoryCache.getUnchecked(parentId);
    }

    @Override
    public List<Item> fetchItems(Search search) {
        String url = getRequestUrl(search);
        String pageSource = restInvoker.get(url, null, String.class);
        String listingResponseJson = getListingResponseJson(pageSource);
        List<Ad> ads = getAds(listingResponseJson);

        if (ads.size() > STRICT_FILTER_THRESHOLD) {
            return ads.stream()
                    .filter(ad -> containsAllKeywords(ad.getTitle(), search.getKeyword()))
                    .filter(ad -> isWithinPriceRange(search.getPriceFrom(), search.getPriceTo(), ad))
                    .map(ad -> olxMapper.toItem(ad, search.getId()))
                    .collect(Collectors.toList());
        } else {
            return ads.stream()
                    .filter(ad -> isWithinPriceRange(search.getPriceFrom(), search.getPriceTo(), ad))
                    .map(ad -> olxMapper.toItem(ad, search.getId()))
                    .collect(Collectors.toList());
        }
    }

    private List<Ad> getAds(String listingResponseJson) {
        return jsonMapper.toObject(listingResponseJson, ListingResponse.class)
                .getListing()
                .getListing()
                .getAds();
    }

    private boolean isWithinPriceRange(Integer min, Integer max, Ad ad) {
        return Optional.ofNullable(ad)
                .map(Ad::getPrice)
                .map(Price::getRegularPrice)
                .map(RegularPrice::getValue)
                .map(p -> (min == null || p >= min) && (max == null || p <= max))
                .orElse(true);
    }

    private String getListingResponseJson(String pageSource) {
        int jsonBeginIndex = getJsonBeginIndex(pageSource);
        int jsonEndIndex = getJsonEndIndex(pageSource, jsonBeginIndex);
        String unescapedJson = pageSource.substring(jsonBeginIndex, jsonEndIndex);
        return StringEscapeUtils.unescapeJson(unescapedJson);
    }

    private int getJsonBeginIndex(String pageSource) {
        int beginPatternIndex = pageSource.indexOf(JSON_BEGIN_PATTERN);
        if (beginPatternIndex == -1) {
            throw new IllegalArgumentException("Json begin index has not been found!");
        }
        return beginPatternIndex + JSON_BEGIN_PATTERN.length();
    }

    private int getJsonEndIndex(String pageSource, int jsonBeginIndex) {
        int endPatternIndex = pageSource.indexOf(JSON_END_PATTERN, jsonBeginIndex);
        if (endPatternIndex == -1) {
            throw new IllegalArgumentException("Json end index has not been found!");
        }
        return endPatternIndex + JSON_END_PATTERN.length();
    }

    private String getRequestUrl(Search search) {
        String category = Optional.ofNullable(search.getCategoryId()).orElse("oferty");
        String keyword = "q-" + search.getKeyword().replaceAll(" ", "-");
        return UriComponentsBuilder.newInstance()
                .scheme("https")
                .host("www.olx.pl")
                .pathSegment("d")
                .pathSegment(category)
                .pathSegment(keyword)
                .path("/")
                .toUriString();
    }

    private boolean containsAllKeywords(String title, String keyword) {
        List<String> keywords = Arrays.asList(keyword.split(" "));
        String normalizedText = title
                .replace(" ", "")
                .replace("-", "")
                .toLowerCase(Locale.ROOT);
        return keywords.stream().allMatch(normalizedText::contains);
    }

}
