package observer.application.service.source.allegro;

import lombok.RequiredArgsConstructor;
import observer.application.config.ApplicationProperties;
import observer.application.rest.RestInvoker;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Collections;
import java.util.Optional;

@Service
@RequiredArgsConstructor
class TokenService {

    private final RestInvoker restInvoker;
    private final ApplicationProperties properties;

    private JwtToken jwtToken;

    protected String fetchAccessToken() {
        if (isValid(jwtToken)) {
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
        requestHeaders.add("Authorization", properties.getAllegroTokenPrivate());
        return new HttpEntity<>(requestHeaders);
    }

    private boolean isValid(JwtToken jwtToken) {
        return Optional.ofNullable(jwtToken)
                .map(JwtToken::getDateCreated)
                .map(date -> date.plus(properties.getAllegroTokenJwtHours(), ChronoUnit.HOURS).isAfter(Instant.now()))
                .orElse(false);
    }

}
