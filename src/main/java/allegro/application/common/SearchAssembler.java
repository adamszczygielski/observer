package allegro.application.common;

import allegro.application.api.SearchDto;
import allegro.application.domain.Search;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Component
public class SearchAssembler {

    public Search toSearch(SearchDto searchDto) {
        return Search.builder()
                .keyword(searchDto.getKeyword())
                .category(searchDto.getCategory())
                .dateUpdated(new Timestamp(0))
                .isActive(false)
                .sourceId(searchDto.getSource().getId())
                .timeInterval(searchDto.getInterval())
                .build();
    }
}