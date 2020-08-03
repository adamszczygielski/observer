package observer.application.api;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@NoArgsConstructor
public class SearchDto {

    @Size(min = 3, max = 40)
    private String keyword;
    private String category;

    @Min(1)
    @Max(1440)
    private Short interval;

    @NotNull
    private Source source;

    @Min(1)
    @Max(100000)
    private Integer priceFrom;

    @Min(1)
    @Max(100000)
    private Integer priceTo;

}
