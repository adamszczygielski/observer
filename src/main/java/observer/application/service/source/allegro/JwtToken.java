package observer.application.service.source.allegro;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.time.LocalDateTime;

public class JwtToken implements Serializable {

    @JsonProperty("access_token")
    private String value;
    private final LocalDateTime dateCreated;

    JwtToken() {
        this.dateCreated = LocalDateTime.now();
    }

    String getBearer() {
        return "Bearer " + value;
    }

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    void setValue(String value) {
        this.value = value;
    }

}