package observer.application.dto;

import lombok.Builder;

import java.time.Instant;

@Builder
public record ItemDto(
        Long id,
        String originId,
        String title,
        Instant createdDate,
        String price,
        String url,
        String source) {
}
