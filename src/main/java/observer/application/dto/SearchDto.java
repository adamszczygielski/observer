package observer.application.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.Instant;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SearchDto {

    private Long id;

    @Size(min = 1, max = 255)
    @NotBlank
    private String description;

    @Size(min = 1, max = 2047)
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
