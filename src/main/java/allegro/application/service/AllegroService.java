package allegro.application.service;

import allegro.application.api.ItemDto;
import allegro.application.entity.Item;
import allegro.application.entity.Search;
import allegro.application.mapper.AllegroMapper;
import allegro.application.model.ListingResponse;
import allegro.application.model.ListingResponseOffers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Service
public class AllegroService implements ItemService {

    @Value("${allegro.token.private}")
    private String privateToken;
    private static String accessToken;
    private static LocalDateTime accessTokenTime = LocalDateTime.MIN;

    @Autowired
    private AllegroMapper mapper;

    @Override
    public List<Item> getItems(Search search) {
        ListingResponseOffers listingResponseOffers = fetchItems(search.getKeyword(), search.getCategory());
        return mapper.toItem(listingResponseOffers, search);
    }

    public List<ItemDto> getPreview(Search search) {
        ListingResponseOffers listingResponseOffers = fetchItems(search.getKeyword(), search.getCategory());
        return mapper.toItemDto(listingResponseOffers, search);
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

        return response.getBody().getItems();
    }

    private String fetchAccessToken() {
        if(accessTokenTime.plusHours(5).isAfter(LocalDateTime.now())) {
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

        accessTokenTime = LocalDateTime.now();
        accessToken = response.getBody().get("access_token").toString();
        return accessToken;
    }
}
