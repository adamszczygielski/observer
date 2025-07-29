package observer.application.service.source.ebay;

import lombok.RequiredArgsConstructor;
import observer.application.config.ApplicationConfig;
import observer.application.dto.Source;
import observer.application.model.Item;
import observer.application.model.Search;
import observer.application.service.source.SourceService;
import observer.application.service.source.ebay.mapper.EbayMapper;
import observer.application.service.source.ebay.model.FindItemsByKeywordsResponse;
import observer.application.service.source.ebay.model.SearchResult;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EbayService implements SourceService {

    private final ApplicationConfig applicationConfig;
    private final RestTemplate restTemplate = new RestTemplate();
    private final EbayMapper mapper = new EbayMapper();

    @Override
    public Source getSource() {
        return Source.EBAY;
    }

    @Override
    public Duration getDelay() {
        return applicationConfig.getEbayDelay();
    }

    @Override
    public List<Item> fetchItems(Search search) {
        String url = search.getParams();

        ResponseEntity<FindItemsByKeywordsResponse> responseEntity = restTemplate.exchange(url, HttpMethod.GET,
                null, FindItemsByKeywordsResponse.class);

        return Optional.of(responseEntity)
                .map(ResponseEntity::getBody)
                .map(FindItemsByKeywordsResponse::getSearchResult)
                .map(SearchResult::getEbayItems)
                .map(items -> mapper.toItems(items, search))
                .orElse(Collections.emptyList());
    }
}