package observer.application.notification;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Builder
@Getter
class NotificationRequest implements Serializable {

    @JsonProperty("app_id")
    private final String appId;

    @JsonProperty("included_segments")
    private final List<String> includedSegments;
    private final Map<String, String> data;
    private final Map<String, String> contents;
}
