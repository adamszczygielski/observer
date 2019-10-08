package allegro.application.service;

import allegro.application.api.ItemDto;
import allegro.application.domain.Item;
import allegro.application.domain.Search;
import allegro.application.mapper.AllegroMapper;
import allegro.application.model.ListingResponse;
import allegro.application.model.ListingResponseOffers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class AllegroService implements ItemService {

    @Value("${allegro.token.private}")
    private String privateToken;
    private static String accessToken;
    private static LocalDateTime accessTokenCreateTime = LocalDateTime.MIN;
    private static long accessTokenLifeTime = 5;

    @Autowired
    private AllegroMapper mapper;

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

    private ListingResponseOffers fetchItems(String phrase, String categoryId) {
        String token = "Bearer " + fetchAccessToken();

        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.newInstance()
                .scheme("https")
                .host("api.allegro.pl")
                .pathSegment("offers", "listing")
                .queryParam("phrase",phrase.replaceAll(" ","+"));

        if(!StringUtils.isEmpty(categoryId)) {
            uriComponentsBuilder.queryParam("category.id", categoryId);
        }
        UriComponents uriComponents = uriComponentsBuilder.build();

        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setContentType(MediaType.APPLICATION_JSON);
        requestHeaders.set("Accept","application/vnd.allegro.public.v1+json");
        requestHeaders.add("Authorization", token);

        final HttpEntity<String> entity = new HttpEntity<>(requestHeaders);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<ListingResponse> response = restTemplate.exchange(uriComponents.toUriString(), HttpMethod.GET, entity, ListingResponse.class);

        return Optional.of(response)
                .map(HttpEntity::getBody)
                .map(ListingResponse::getItems)
                .orElse(new ListingResponseOffers());
    }

    private String fetchAccessToken() {
        if(accessTokenCreateTime.plusHours(accessTokenLifeTime).isAfter(LocalDateTime.now())) {
            return accessToken;
        }

        UriComponents uriComponents = UriComponentsBuilder.newInstance()
                .scheme("https")
                .host("allegro.pl")
                .pathSegment("auth", "oauth", "token")
                .queryParam("grant_type", "client_credentials")
                .build();

        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setContentType(MediaType.APPLICATION_JSON);
        requestHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        requestHeaders.add("Authorization", privateToken);

        final HttpEntity<String> entity = new HttpEntity<>(requestHeaders);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Map> response = restTemplate.exchange(uriComponents.toUriString(), HttpMethod.POST, entity, Map.class);

        accessTokenCreateTime = LocalDateTime.now();
        accessToken = Optional.of(response)
                .map(HttpEntity::getBody)
                .map(m -> m.get("access_token"))
                .map(Object::toString)
                .orElse("");

        return accessToken;
    }
}