package allegro.application.common;

import allegro.application.api.SearchDto;
import allegro.application.domain.Search;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Component
public class SearchAssembler {

    public Search toSearch(SearchDto searchDto) {
        Search search = new Search();
        search.setKeyword(searchDto.getKeyword());
        search.setCategory(searchDto.getCategory());
        search.setDateUpdated(new Timestamp(0));
        search.setIsActive(false);
        search.setSourceId(searchDto.getSource().getId());
        search.setTimeInterval(searchDto.getInterval());
        return search;
    }
}