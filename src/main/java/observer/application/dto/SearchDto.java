package observer.application.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SearchDto {

    private Long id;

    @Size(max = 255)
    @NotBlank
    private String description;

    @Size(max = 2047)
    @NotBlank
    private String params;
    private Instant lastExecutionDate;

    @NotNull
    @Min(5)
    @Max(360)
    private Short intervalMinutes;

    @NotNull
    private Source source;
    private Status status;
    private Integer count;
}
