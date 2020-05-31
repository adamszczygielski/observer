package allegro.application.service.source.allegro;

import allegro.application.api.ItemDto;
import allegro.application.domain.Item;
import allegro.application.domain.Search;
import allegro.application.rest.RestInvoker;
import allegro.application.service.ItemService;
import allegro.application.service.source.allegro.mapper.AllegroMapper;
import allegro.application.service.source.allegro.model.ListingResponse;
import allegro.application.service.source.allegro.model.ListingResponseOffers;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AllegroService implements ItemService {

    private AllegroMapper mapper;
    private AllegroTokenService tokenService;
    private RestInvoker restInvoker;

    @Override
    public List<Item> getItems(Search search) {
        ListingResponseOffers listingResponseOffers = fetchItems(search.getKeyword(), search.getCategory());
        return mapper.toItem(listingResponseOffers, search);
    }

    @Override
    public List<ItemDto> getPreview(Search search) {
        ListingResponseOffers listingResponseOffers = fetchItems(search.getKeyword(), search.getCategory());
        return mapper.toItemDto(listingResponseOffers);
    }

    private ListingResponseOffers fetchItems(String keyword, String categoryId) {

        ListingResponse listingResponse = restInvoker.get(
                createRequestUrl(keyword, categoryId), createRequestHttpEntity(), ListingResponse.class);

        return Optional.of(listingResponse)
                .map(ListingResponse::getItems)
                .orElse(new ListingResponseOffers());
    }

    private HttpEntity<String> createRequestHttpEntity() {
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setContentType(MediaType.APPLICATION_JSON);
        requestHeaders.set("Accept", "application/vnd.allegro.public.v1+json");
        requestHeaders.add("Authorization", tokenService.fetchAccessToken());

        return new HttpEntity<>(requestHeaders);
    }

    private String createRequestUrl(String keyword, String categoryId) {
        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.newInstance()
                .scheme("https")
                .host("api.allegro.pl")
                .pathSegment("offers", "listing")
                .queryParam("phrase", keyword.replaceAll(" ", "+"))
                .queryParam("fallback", "false")
                .queryParam("sort", "-startTime")
                .queryParam("limit", "20");

        if (!StringUtils.isEmpty(categoryId)) {
            uriComponentsBuilder.queryParam("category.id", categoryId);
        }

        return uriComponentsBuilder.build().toUriString();
    }
}