package observer.application.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;

import java.time.Instant;

@Builder
public record SearchDto(Long id, @Size(max = 255) @NotBlank String description,
                        @Size(max = 2047) @NotBlank String params, Instant lastExecutionDate,
                        @NotNull @Min(5) @Max(360) Short intervalMinutes, @NotNull Source source, Status status,
                        Integer count) {
}
