package observer.application.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;

import java.util.List;
import java.util.Map;

@Builder
@Getter
public class NotificationRequestDto {

    @JsonProperty("app_id")
    private final String appId;

    @JsonProperty("included_segments")
    private final List<String> includedSegments;
    private final Map<String, String> data;
    private final Map<String, String> contents;
}
