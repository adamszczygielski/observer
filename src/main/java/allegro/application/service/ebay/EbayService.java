package allegro.application.service.ebay;

import allegro.application.api.ItemDto;
import allegro.application.domain.Item;
import allegro.application.domain.Search;
import allegro.application.service.ItemService;
import allegro.application.service.ebay.mapper.EbayMapper;
import allegro.application.service.ebay.model.*;
import lombok.AllArgsConstructor;
import org.springframework.http.*;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EbayService implements ItemService {

    private EbayMapper mapper;

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

        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.newInstance()
                .scheme("https")
                .host("svcs.ebay.com")
                .pathSegment("services")
                .pathSegment("search")
                .pathSegment("FindingService")
                .pathSegment("v1")
                .queryParam("OPERATION-NAME", "findItemsByKeywords")
                .queryParam("SERVICE-VERSION", "1.13.0")
                .queryParam("SECURITY-APPNAME", "AdamSzcz-observer-PRD-3388a6d5f-832b4307")
                .queryParam("RESPONSE-DATA-FORMAT", "XML")
                .queryParam("keywords", keyword.replaceAll(" ", "+"))
                .queryParam("sortOrder", "StartTimeNewest")
                .queryParam("paginationInput.entriesPerPage", "30");

        UriComponents uriComponents = uriComponentsBuilder.build();

        HttpHeaders requestHeaders = new HttpHeaders();
        final HttpEntity<String> entity = new HttpEntity<>(requestHeaders);

        RestTemplate restTemplate = new RestTemplate();
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setSupportedMediaTypes(Arrays.asList(MediaType.TEXT_PLAIN, MediaType.APPLICATION_XML));
        restTemplate.getMessageConverters().add(0, converter);

        ResponseEntity<FindItemsByKeywordsResponse> response = restTemplate.exchange(uriComponents.toString(), HttpMethod.GET, entity, FindItemsByKeywordsResponse.class);

        return Optional.of(response)
                .map(HttpEntity::getBody)
                .map(BaseFindingServiceResponse::getSearchResult)
                .map(SearchResult::getItem)
                .orElse(new ArrayList<>());
    }
}