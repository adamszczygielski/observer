package allegro.application.service.allegro;

import allegro.application.api.ItemDto;
import allegro.application.domain.Item;
import allegro.application.domain.Search;
import allegro.application.service.allegro.mapper.AllegroMapper;
import allegro.application.service.allegro.model.ListingResponse;
import allegro.application.service.allegro.model.ListingResponseOffers;
import allegro.application.service.ItemService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AllegroService implements ItemService {

    private AllegroMapper mapper;
    private AllegroTokenService tokenService;

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

        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.newInstance()
                .scheme("https")
                .host("api.allegro.pl")
                .pathSegment("offers", "listing")
                .queryParam("phrase", keyword.replaceAll(" ", "+"));

        if (!StringUtils.isEmpty(categoryId)) {
            uriComponentsBuilder.queryParam("category.id", categoryId);
        }
        UriComponents uriComponents = uriComponentsBuilder.build();

        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setContentType(MediaType.APPLICATION_JSON);
        requestHeaders.set("Accept", "application/vnd.allegro.public.v1+json");
        requestHeaders.add("Authorization", tokenService.fetchAccessToken());

        final HttpEntity<String> entity = new HttpEntity<>(requestHeaders);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<ListingResponse> response = restTemplate.exchange(uriComponents.toUriString(), HttpMethod.GET, entity, ListingResponse.class);

        return Optional.of(response)
                .map(HttpEntity::getBody)
                .map(ListingResponse::getItems)
                .orElse(new ListingResponseOffers());
    }
}