package allegro.application.service.ebay;

import allegro.application.api.ItemDto;
import allegro.application.domain.Item;
import allegro.application.domain.Search;
import allegro.application.rest.RestInvoker;
import allegro.application.service.ItemService;
import allegro.application.service.ebay.mapper.EbayMapper;
import allegro.application.service.ebay.model.BaseFindingServiceResponse;
import allegro.application.service.ebay.model.FindItemsByKeywordsResponse;
import allegro.application.service.ebay.model.SearchItem;
import allegro.application.service.ebay.model.SearchResult;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EbayService implements ItemService {

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
        List<SearchItem> searchItemList = fetchItems(search.getKeyword());
        return mapper.toItem(searchItemList, search);
    }

    @Override
    public List<ItemDto> getPreview(Search search) {
        List<SearchItem> searchItemList = fetchItems(search.getKeyword());
        return mapper.toItemDto(searchItemList);
    }

    public List<SearchItem> fetchItems(String keyword) {

        FindItemsByKeywordsResponse findItemsByKeywordsResponse = restInvoker.get(
                createRequestUrl(keyword), createRequestHttpEntity(), FindItemsByKeywordsResponse.class);

        return Optional.of(findItemsByKeywordsResponse)
                .map(BaseFindingServiceResponse::getSearchResult)
                .map(SearchResult::getItem)
                .orElse(new ArrayList<>());
    }

    private HttpEntity<String> createRequestHttpEntity() {
        return new HttpEntity<>(new HttpHeaders());
    }

    private String createRequestUrl(String keyword) {
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

        return uriComponentsBuilder.build().toUriString();
    }
}