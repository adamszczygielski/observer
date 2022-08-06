package observer.application.service.source.allegro;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.time.Instant;
import java.time.temporal.ChronoUnit;

class AccessToken implements Serializable {

    private final String bearerToken;
    private final Instant expirationDate;

    AccessToken(@JsonProperty("access_token") String accessToken, @JsonProperty("expires_in") Integer expiresIn) {
        this.bearerToken = "Bearer " + accessToken;
        this.expirationDate = Instant.now().plus(expiresIn, ChronoUnit.SECONDS);
    }

    String getBearer() {
        return bearerToken;
    }

    boolean isValid() {
        return Instant.now().isBefore(expirationDate);
    }

}