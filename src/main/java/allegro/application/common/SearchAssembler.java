package allegro.application.common;

import allegro.application.api.SearchDto;
import allegro.application.entity.Search;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Component
public class SearchAssembler {

    public Search toSearch(SearchDto searchDto) {
        Search search = new Search();
        search.setKeyword(searchDto.getKeyword());
        search.setCategory(searchDto.getCategory());
        search.setLastUpdate(new Timestamp(System.currentTimeMillis()));
        search.setIsActive(false);
        search.setTimeInterval(searchDto.getInterval());
        return search;
    }
}
