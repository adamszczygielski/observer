package observer.application.api;

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
    private final Long timeInterval;
    private final String source;
    private final Long count;
    private final LocalTime dateUpdated;

}
