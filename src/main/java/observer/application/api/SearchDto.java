package observer.application.api;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@NoArgsConstructor
public class SearchDto {

    @NotNull
    @Size(max = 40)
    @Pattern(regexp = "(.*[a-zA-Z\\d]){3}", message = "Must contain at least 3 characters")
    private String keyword;
    private String category;

    @NotNull
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
