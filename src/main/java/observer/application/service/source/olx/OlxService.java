package observer.application.service.source.olx;

import lombok.RequiredArgsConstructor;
import observer.application.config.ApplicationConfig;
import observer.application.dto.Source;
import observer.application.mapper.JsonMapper;
import observer.application.model.Item;
import observer.application.model.Search;
import observer.application.service.source.SourceService;
import observer.application.service.source.olx.mapper.OlxMapper;
import observer.application.service.source.olx.model.ListingResponse;
import org.apache.commons.text.StringEscapeUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

@Service
@RequiredArgsConstructor
public class OlxService implements SourceService {

    private static final String JSON_BEGIN_PATTERN = "window.__PRERENDERED_STATE__= \"";
    private static final String JSON_END_PATTERN = "window.";
    private static final Pattern NON_ALPHANUMERIC_PATTERN = Pattern.compile("[^a-zA-Z0-9]");

    private final ApplicationConfig applicationConfig;
    private final JsonMapper jsonMapper;
    private final WebClient webClient;
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

        String pageSource = fetchPageSource(url);

        String listingResponseJson = extractListingResponseJson(pageSource);
        ListingResponse listingResponse = jsonMapper.toObject(listingResponseJson, ListingResponse.class);

        int totalElements = listingResponse.getListing()
                .getListingDetails()
                .getTotalElements();

        List<String> keywords = extractKeywords(url).stream()
                .map(this::normalize)
                .filter(s -> !s.isBlank())
                .toList();

        return listingResponse.getListing()
                .getListingDetails()
                .getAds()
                .stream()
                .limit(totalElements)
                .filter(ad -> containsAllKeywords(ad.getTitle(), keywords))
                .map(ad -> olxMapper.toItem(ad, search))
                .toList();
    }

    private String fetchPageSource(String url) {
        return webClient.get()
                .uri(url)
                .retrieve()
                .bodyToMono(String.class)
                .blockOptional()
                .orElseThrow(() -> new IllegalStateException("No response body!"));
    }

    private String extractListingResponseJson(String pageSource) {
        int jsonBeginIndex = getJsonBeginIndex(pageSource);
        int jsonEndIndex = getJsonEndIndex(pageSource, jsonBeginIndex);
        String escapedJson = pageSource.substring(jsonBeginIndex, jsonEndIndex);
        return StringEscapeUtils.unescapeJson(escapedJson);
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
        return endPatternIndex;
    }

    private boolean containsAllKeywords(String title, List<String> normalizedKeywords) {
        if (normalizedKeywords.isEmpty()) {
            return true;
        }
        String normalizedTitle = normalize(title);
        return normalizedKeywords.stream().allMatch(normalizedTitle::contains);
    }

    private String normalize(String value) {
        return NON_ALPHANUMERIC_PATTERN.matcher(Optional.ofNullable(value).orElse(""))
                .replaceAll("")
                .toLowerCase();
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
                .toList();
    }
}
