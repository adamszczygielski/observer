package observer.application.service.source.allegro;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.time.Instant;

class JwtToken implements Serializable {

    @JsonProperty("access_token")
    private String value;
    private final Instant dateCreated;

    JwtToken() {
        this.dateCreated = Instant.now();
    }

    String getBearer() {
        return "Bearer " + value;
    }

    Instant getDateCreated() {
        return dateCreated;
    }

}