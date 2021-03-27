package observer.application.api;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import observer.application.domain.Source;
import observer.application.domain.Status;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.Instant;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SearchDto {

    private Long searchId;

    @NotNull
    @Size(min = 3, max = 20)
    @Pattern(regexp = "(.*[a-zA-Z\\d]){3}", message = "Must contain at least 3 characters")
    private String keyword;
    private String categoryId;
    private String categoryName;
    private Instant dateUpdated;

    @NotNull
    @Min(1)
    @Max(1440)
    private Short interval;

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
