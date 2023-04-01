package observer.application.service.source.allegro;

import lombok.RequiredArgsConstructor;
import observer.application.config.ApplicationConfig;
import observer.application.rest.RestInvoker;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Collections;

@RequiredArgsConstructor
class AuthorizationService {

    private final RestInvoker restInvoker;
    private final ApplicationConfig applicationConfig;

    private AccessToken accessToken;

    protected String fetchBearerToken() {
        if (accessToken != null && accessToken.isValid()) {
            return accessToken.getBearer();
        }
        accessToken = restInvoker.post(createRequestUrl(), createHttpEntity(), AccessToken.class);
        return accessToken.getBearer();
    }

    private String createRequestUrl() {
        return UriComponentsBuilder.newInstance()
                .scheme("https")
                .host("allegro.pl")
                .pathSegment("auth", "oauth", "token")
                .queryParam("grant_type", "client_credentials")
                .build().toUriString();
    }

    private HttpEntity<String> createHttpEntity() {
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setContentType(MediaType.APPLICATION_JSON);
        requestHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        requestHeaders.add("Authorization", applicationConfig.getAllegroTokenPrivate());
        return new HttpEntity<>(requestHeaders);
    }

}
