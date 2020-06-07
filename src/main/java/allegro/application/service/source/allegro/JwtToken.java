package allegro.application.service.source.allegro;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class JwtToken implements Serializable {

    @JsonProperty("access_token")
    private String value;
    private LocalDateTime dateCreated;

}