package observer.application.service.source.allegro;

import observer.application.config.ApplicationProperties;
import observer.application.rest.RestInvoker;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Collections;

class AuthorizationService {

    private final RestInvoker restInvoker;
    private final ApplicationProperties applicationProperties;

    private AccessToken accessToken;

    public AuthorizationService(RestInvoker restInvoker, ApplicationProperties applicationProperties) {
        this.restInvoker = restInvoker;
        this.applicationProperties = applicationProperties;
    }

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
        requestHeaders.add("Authorization", applicationProperties.getAllegroTokenPrivate());
        return new HttpEntity<>(requestHeaders);
    }

}
