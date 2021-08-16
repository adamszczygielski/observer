package observer.application.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalTime;

@Getter
@Builder
public class SearchViewDto {

    private final Long id;
    private final String keyword;
    private final String categoryId;
    private final String categoryName;
    private final Integer priceFrom;
    private final Integer priceTo;
    private final Short timeInterval;
    private final String source;
    private final Integer count;
    private final LocalTime dateUpdated;
    private final String status;

}
