package observer.application.service.source.olx;

import lombok.RequiredArgsConstructor;
import observer.application.config.ApplicationConfig;
import observer.application.dto.Source;
import observer.application.model.Item;
import observer.application.model.Search;
import observer.application.rest.JsonMapper;
import observer.application.rest.RestInvoker;
import observer.application.service.source.SourceService;
import observer.application.service.source.olx.mapper.OlxMapper;
import observer.application.service.source.olx.model.ListingResponse;
import org.apache.commons.text.StringEscapeUtils;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OlxService implements SourceService {

    private static final String JSON_BEGIN_PATTERN = "window.__PRERENDERED_STATE__= \"";
    private static final String JSON_END_PATTERN = "window.";

    private final ApplicationConfig applicationConfig;
    private final JsonMapper jsonMapper;
    private final RestInvoker restInvoker;
    private final OlxMapper olxMapper = new OlxMapper();

    @Override
    public Source getSource() {
        return Source.OLX;
    }

    @Override
    public Duration getDelay() {
        return applicationConfig.getOlxDelay();
    }

    @Override
    public List<Item> fetchItems(Search search) {
        String url = search.getParams();
        String pageSource = restInvoker.get(url, null, String.class);
        String listingResponseJson = getListingResponseJson(pageSource);
        ListingResponse listingResponse = jsonMapper.toObject(listingResponseJson, ListingResponse.class);

        int totalElements = listingResponse.getListing()
                .getListingDetails()
                .getTotalElements();

        List<String> keywords = extractKeywords(url);

        return listingResponse.getListing()
                .getListingDetails()
                .getAds()
                .stream()
                .limit(totalElements)
                .filter(ad -> keywords.stream().allMatch(k -> ad.getTitle().toLowerCase()
                        .replaceAll(" ", "").replaceAll("-", "").contains(k)))
                .map(ad -> olxMapper.toItem(ad, search.getId()))
                .collect(Collectors.toList());
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

    private List<String> extractKeywords(String url) {
        int beginIndex = url.indexOf("/q-");
        if (beginIndex == -1) {
            return List.of();
        } else {
            beginIndex += 3;
        }

        int endIndex = url.length();
        for (int i = beginIndex; i < url.length(); i++) {
            char c = url.charAt(i);
            if (c == '/' || c == '?') {
                endIndex = i;
                break;
            }
        }

        return Arrays.stream(url.substring(beginIndex, endIndex).split("-"))
                .map(String::toLowerCase)
                .collect(Collectors.toList());
    }
}
