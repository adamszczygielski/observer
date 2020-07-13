package allegro.application.service.source.allegro;

import allegro.application.rest.RestInvoker;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
class AllegroTokenService {

    private final int jwtTokenHours;
    private final String privateToken;
    private final RestInvoker restInvoker;

    private final Logger log = Logger.getLogger(getClass().getName());

    private JwtToken jwtToken;

    public AllegroTokenService(@Value("${allegro.token.private}") String privateToken, RestInvoker restInvoker,
                               @Value("${allegro.token.jwt.hours}") String jwtTokenHours) {
        this.privateToken = privateToken;
        this.jwtTokenHours = Integer.parseInt(jwtTokenHours);
        this.restInvoker = restInvoker;
    }

    protected String fetchAccessToken() {
        if (validateToken(jwtToken)) {
            return "Bearer " + jwtToken.getValue();
        }

        log.log(Level.INFO, "Private token expired. Fetching new one.");

        JwtToken newJwtToken = restInvoker.post(createRequestUrl(), createRequestHttpEntity(), JwtToken.class);
        newJwtToken.setDateCreated(LocalDateTime.now());
        jwtToken = newJwtToken;

        return "Bearer " + jwtToken.getValue();
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
        requestHeaders.add("Authorization", privateToken);
        return new HttpEntity<>(requestHeaders);
    }

    private boolean validateToken(JwtToken jwtToken) {
        if (jwtToken != null) {
            return jwtToken.getDateCreated().plusHours(jwtTokenHours).isAfter(LocalDateTime.now());
        }
        return false;
    }
}
