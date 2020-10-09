package observer.application.service.source.ebay;

import observer.application.api.ParameterType;
import observer.application.domain.Item;
import observer.application.domain.Parameter;
import observer.application.domain.Search;
import observer.application.rest.RestInvoker;
import observer.application.service.ItemService;
import observer.application.service.source.ebay.mapper.EbayMapper;
import observer.application.service.source.ebay.model.BaseFindingServiceResponse;
import observer.application.service.source.ebay.model.FindItemsByKeywordsResponse;
import observer.application.service.source.ebay.model.SearchItem;
import observer.application.service.source.ebay.model.SearchResult;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EbayService extends ItemService {

    private final EbayMapper mapper;
    private final RestInvoker restInvoker;
    private final String securityAppName;

    public EbayService(EbayMapper mapper, RestInvoker restInvoker, @Value("${ebay.security.appname}") String securityAppName) {
        this.mapper = mapper;
        this.restInvoker = restInvoker;
        this.securityAppName = securityAppName;
    }

    @Override
    public List<Item> getItems(Search search) {
        List<SearchItem> searchItemList = fetchSearchItems(search.getKeyword(), search.getParameterList());
        return mapper.toItems(searchItemList, search.getId());
    }

    private List<SearchItem> fetchSearchItems(String keyword, List<Parameter> parameters) {

        FindItemsByKeywordsResponse findItemsByKeywordsResponse = restInvoker.get(
                createListingRequestUrl(keyword, parameters), createHttpEntity(), FindItemsByKeywordsResponse.class);

        return Optional.of(findItemsByKeywordsResponse)
                .map(BaseFindingServiceResponse::getSearchResult)
                .map(SearchResult::getItem)
                .orElse(new ArrayList<>());
    }

    private HttpEntity<String> createHttpEntity() {
        return new HttpEntity<>(new HttpHeaders());
    }

    private String createListingRequestUrl(String keyword, List<Parameter> parameters) {
        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.newInstance()
                .scheme("https")
                .host("svcs.ebay.com")
                .pathSegment("services")
                .pathSegment("search")
                .pathSegment("FindingService")
                .pathSegment("v1")
                .queryParam("OPERATION-NAME", "findItemsByKeywords")
                .queryParam("SERVICE-VERSION", "1.13.0")
                .queryParam("SECURITY-APPNAME", securityAppName)
                .queryParam("RESPONSE-DATA-FORMAT", "XML")
                .queryParam("keywords", keyword.replaceAll(" ", "+"))
                .queryParam("sortOrder", "StartTimeNewest")
                .queryParam("paginationInput.entriesPerPage", "30");

        if (!CollectionUtils.isEmpty(parameters)) {
            String priceFrom = getParameterValue(parameters, ParameterType.PRICE_FROM);
            if (priceFrom != null) {
                uriComponentsBuilder.queryParam("itemFilter(0).name", "MinPrice");
                uriComponentsBuilder.queryParam("itemFilter(0).value", priceFrom);
                uriComponentsBuilder.queryParam("itemFilter(0).paramName", "Currency");
                uriComponentsBuilder.queryParam("itemFilter(0).paramValue", "PLN");
            }

            String priceTo = getParameterValue(parameters, ParameterType.PRICE_TO);
            if (priceTo != null) {
                uriComponentsBuilder.queryParam("itemFilter(1).name", "MaxPrice");
                uriComponentsBuilder.queryParam("itemFilter(1).value", priceTo);
                uriComponentsBuilder.queryParam("itemFilter(1).paramName", "Currency");
                uriComponentsBuilder.queryParam("itemFilter(1).paramValue", "PLN");
            }
        }

        return uriComponentsBuilder.build().toUriString();
    }
}