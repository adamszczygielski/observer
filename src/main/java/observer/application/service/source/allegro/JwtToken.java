package observer.application.service.source.allegro;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.time.Instant;
import java.time.temporal.ChronoUnit;

class JwtToken implements Serializable {

    private final Instant dateCreated;
    @JsonProperty("access_token")
    private String value;

    JwtToken() {
        this.dateCreated = Instant.now();
    }

    String getBearer() {
        return "Bearer " + value;
    }

    boolean isValid(long expirationTimeHours) {
        return dateCreated.plus(expirationTimeHours, ChronoUnit.HOURS)
                .isAfter(Instant.now());
    }

}