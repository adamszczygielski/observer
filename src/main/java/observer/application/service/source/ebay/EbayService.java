package observer.application.service.source.ebay;

import lombok.RequiredArgsConstructor;
import observer.application.config.ApplicationConfig;
import observer.application.model.Category;
import observer.application.model.Item;
import observer.application.model.Search;
import observer.application.model.Source;
import observer.application.rest.RestInvoker;
import observer.application.service.source.SourceService;
import observer.application.service.source.ebay.mapper.EbayMapper;
import observer.application.service.source.ebay.model.FindItemsByKeywordsResponse;
import observer.application.service.source.ebay.model.SearchResult;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EbayService implements SourceService {

    private final ApplicationConfig applicationConfig;
    private final RestInvoker restInvoker;
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
        String url = mapper.toUrl(search, applicationConfig.getEbaySecurityAppname());
        FindItemsByKeywordsResponse findItemsByKeywordsResponse = restInvoker.get(url, null,
                FindItemsByKeywordsResponse.class);

        return Optional.of(findItemsByKeywordsResponse)
                .map(FindItemsByKeywordsResponse::getSearchResult)
                .map(SearchResult::getEbayItems)
                .map(items -> mapper.toItems(items, search.getId()))
                .orElse(Collections.emptyList());
    }

    @Override
    public List<Category> fetchCategories(String parentId) {
        return Collections.emptyList();
    }
}