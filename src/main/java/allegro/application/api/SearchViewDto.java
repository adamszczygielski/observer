package allegro.application.api;

import lombok.Builder;
import lombok.Getter;

import java.io.Serializable;


@Getter
@Builder
public class SearchViewDto implements Serializable {

    private final Long id;
    private final String keyword;
    private final String category;
    private final Long timeInterval;
    private final String source;
    private final Long count;
    private final String dateUpdated;
}
