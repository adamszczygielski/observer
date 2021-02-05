package observer.application.service.source.allegro;

import lombok.RequiredArgsConstructor;
import observer.application.config.ConfigProperties;
import observer.application.rest.RestInvoker;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.time.LocalDateTime;
import java.util.Collections;

@Service
@RequiredArgsConstructor
class TokenService {

    private final RestInvoker restInvoker;
    private final ConfigProperties properties;

    private JwtToken jwtToken;

    protected String fetchAccessToken() {
        if (validateToken(jwtToken)) {
            return jwtToken.getBearer();
        }
        JwtToken newJwtToken = restInvoker.post(createRequestUrl(), createRequestHttpEntity(), JwtToken.class);
        newJwtToken.setDateCreated(LocalDateTime.now());
        jwtToken = newJwtToken;

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

    private HttpEntity<String> createRequestHttpEntity() {
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setContentType(MediaType.APPLICATION_JSON);
        requestHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        requestHeaders.add("Authorization", properties.getAllegroTokenPrivate());
        return new HttpEntity<>(requestHeaders);
    }

    private boolean validateToken(JwtToken jwtToken) {
        if (jwtToken != null) {
            return jwtToken.getDateCreated().plusHours(properties.getAllegroTokenJwtHours()).isAfter(LocalDateTime.now());
        }
        return false;
    }
}
