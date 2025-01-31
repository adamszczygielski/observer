package observer.application.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record NotificationResponseDto(String id, Integer recipients, @JsonProperty("external_id") String externalId) {
}
