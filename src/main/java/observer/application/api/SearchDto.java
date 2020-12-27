package observer.application.api;

import lombok.*;

import javax.validation.constraints.*;
import java.sql.Timestamp;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SearchDto {

    private Long searchId;

    @NotNull
    @Size(max = 40)
    @Pattern(regexp = "(.*[a-zA-Z\\d]){3}", message = "Must contain at least 3 characters")
    private String keyword;
    private String categoryId;
    private String categoryName;
    private Timestamp dateUpdated;

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
