package observer.application.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import observer.application.model.Source;
import observer.application.model.Status;

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

    @Size(min = 3, max = 20)
    @NotBlank
    private String keyword;

    @Size(min = 1, max = 255)
    private String categoryId;

    @Size(min = 1, max = 255)
    private String categoryName;
    private Instant lastExecutionDate;

    @NotNull
    @Min(5)
    @Max(360)
    private Short intervalMinutes;

    @NotNull
    private Source source;
    private Status status;

    @Min(1)
    @Max(100000)
    private Integer priceFrom;

    @Min(1)
    @Max(100000)
    private Integer priceTo;

}
