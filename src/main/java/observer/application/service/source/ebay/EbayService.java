package observer.application.service.source.ebay;

import lombok.RequiredArgsConstructor;
import observer.application.model.Category;
import observer.application.model.Item;
import observer.application.model.Search;
import observer.application.model.Source;
import observer.application.rest.RestInvoker;
import observer.application.service.source.SourceService;
import observer.application.service.source.ebay.mapper.EbayMapper;
import observer.application.service.source.ebay.model.BaseFindingServiceResponse;
import observer.application.service.source.ebay.model.FindItemsByKeywordsResponse;
import observer.application.service.source.ebay.model.SearchItem;
import observer.application.service.source.ebay.model.SearchResult;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EbayService extends SourceService {

    private final EbayMapper mapper;
    private final RestInvoker restInvoker;

    @Override
    public Source getSource() {
        return Source.EBAY;
    }

    @Override
    public long getDelay() {
        return applicationProperties.getEbayDelayMillis();
    }

    @Override
    public List<Item> getItems(Search search) {
        return mapper.toItems(fetchSearchItems(search), search.getId());
    }

    @Override
    public List<Category> getCategories(String parentId) {
        return Collections.emptyList();
    }

    private List<SearchItem> fetchSearchItems(Search search) {
        FindItemsByKeywordsResponse findItemsByKeywordsResponse = restInvoker.get(
                createListingRequestUrl(search), null, FindItemsByKeywordsResponse.class);

        return Optional.of(findItemsByKeywordsResponse)
                .map(BaseFindingServiceResponse::getSearchResult)
                .map(SearchResult::getItem)
                .orElse(Collections.emptyList());
    }

    private String createListingRequestUrl(Search search) {
        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.newInstance()
                .scheme("https")
                .host("svcs.ebay.com")
                .pathSegment("services")
                .pathSegment("search")
                .pathSegment("FindingService")
                .pathSegment("v1")
                .queryParam("OPERATION-NAME", "findItemsByKeywords")
                .queryParam("SERVICE-VERSION", "1.13.0")
                .queryParam("SECURITY-APPNAME", applicationProperties.getEbaySecurityAppname())
                .queryParam("RESPONSE-DATA-FORMAT", "XML")
                .queryParam("keywords", search.getKeyword().replaceAll(" ", "+"))
                .queryParam("sortOrder", "StartTimeNewest")
                .queryParam("paginationInput.entriesPerPage", "30");

        Integer priceFrom = search.getPriceFrom();
        if (priceFrom != null) {
            uriComponentsBuilder.queryParam("itemFilter(0).name", "MinPrice");
            uriComponentsBuilder.queryParam("itemFilter(0).value", priceFrom);
            uriComponentsBuilder.queryParam("itemFilter(0).paramName", "Currency");
            uriComponentsBuilder.queryParam("itemFilter(0).paramValue", "PLN");
        }

        Integer priceTo = search.getPriceTo();
        if (priceTo != null) {
            uriComponentsBuilder.queryParam("itemFilter(1).name", "MaxPrice");
            uriComponentsBuilder.queryParam("itemFilter(1).value", priceTo);
            uriComponentsBuilder.queryParam("itemFilter(1).paramName", "Currency");
            uriComponentsBuilder.queryParam("itemFilter(1).paramValue", "PLN");
        }

        return uriComponentsBuilder.build().toUriString();
    }
}