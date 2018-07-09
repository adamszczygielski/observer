package allegro.app.common;

import allegro.app.controller.SearchDto;
import allegro.app.entity.Search;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.sql.Timestamp;

@Component
public class SearchAssembler {

    public Search toSearch(SearchDto searchDto) {
        Search search = new Search();
        search.setKeywords(searchDto.getKeywords());
        search.setLastUpdate(new Timestamp(System.currentTimeMillis()));
        search.setIsActive(true);
        search.setTimeInterval(searchDto.getInterval());

        return search;
    }
}
