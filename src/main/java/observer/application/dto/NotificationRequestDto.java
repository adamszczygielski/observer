package observer.application.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

import java.util.List;
import java.util.Map;

@Builder
public record NotificationRequestDto(@JsonProperty("app_id") String appId,
                                     @JsonProperty("included_segments") List<String> includedSegments,
                                     Map<String, String> data, Map<String, String> contents) {
}
