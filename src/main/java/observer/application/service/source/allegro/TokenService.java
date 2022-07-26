package observer.application.service.source.allegro;

import observer.application.config.ApplicationProperties;
import observer.application.rest.RestInvoker;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Collections;

class TokenService {

    private final RestInvoker restInvoker;
    private final ApplicationProperties applicationProperties;

    private JwtToken jwtToken;

    public TokenService(RestInvoker restInvoker, ApplicationProperties applicationProperties) {
        this.restInvoker = restInvoker;
        this.applicationProperties = applicationProperties;
    }

    protected String fetchAccessToken() {
        if (jwtToken != null && jwtToken.isValid(applicationProperties.getAllegroTokenJwtExpirationHours())) {
            return jwtToken.getBearer();
        }
        jwtToken = restInvoker.post(createRequestUrl(), createHttpEntity(), JwtToken.class);
        return jwtToken.getBearer();
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
