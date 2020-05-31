package allegro.application.common;

import allegro.application.api.SearchViewDto;
import allegro.application.domain.SearchView;
import allegro.application.api.Source;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Component
public class SearchViewAssembler implements BaseAssembler <SearchView, SearchViewDto> {

    @Override
    public SearchViewDto toDto(SearchView searchView) {
        SearchViewDto searchViewDto = new SearchViewDto();
        searchViewDto.setId(searchView.getId());
        searchViewDto.setKeyword(searchView.getKeyword());
        searchViewDto.setCategory(searchView.getCategory());
        searchViewDto.setSource(Source.getSource(searchView.getSourceId()).getLabel());
        searchViewDto.setDateUpdated(toString(searchView.getDateUpdated()));
        searchViewDto.setTimeInterval(searchView.getTimeInterval());
        searchViewDto.setCount(searchView.getCount());
        return searchViewDto;
    }

    private String toString(Timestamp lastUpdate) {
        if(lastUpdate.getTime() == 0) {
            return "";
        }
        return Utils.toString(lastUpdate);
    }
}
