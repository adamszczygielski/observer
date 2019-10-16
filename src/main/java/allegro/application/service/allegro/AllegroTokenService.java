package allegro.application.service.allegro;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Map;
import java.util.Optional;

@Service
public class AllegroTokenService {

    @Value("${allegro.token.private}")
    private String privateToken;
    private static String accessToken;
    private static LocalDateTime accessTokenCreateTime = LocalDateTime.MIN;
    private static long accessTokenLifeTime = 5;

    public String fetchAccessToken() {
        if(accessTokenCreateTime.plusHours(accessTokenLifeTime).isAfter(LocalDateTime.now())) {
            return "Bearer " + accessToken;
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

        return "Bearer " + accessToken;
    }
}
