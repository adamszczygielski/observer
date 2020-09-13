package observer.application.notification;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class NotificationResponse implements Serializable {

    private String id;
    private Integer recipients;

    @JsonProperty("external_id")
    private String externalId;
}
