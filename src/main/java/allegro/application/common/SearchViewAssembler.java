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
        return SearchViewDto.builder()
                .id(searchView.getId())
                .keyword(searchView.getKeyword())
                .category(searchView.getCategory())
                .source(Source.getSource(searchView.getSourceId()).getLabel())
                .dateUpdated(toString(searchView.getDateUpdated()))
                .timeInterval(searchView.getTimeInterval())
                .count(searchView.getCount())
                .build();
    }

    private String toString(Timestamp lastUpdate) {
        if(lastUpdate.getTime() == 0) {
            return "";
        }
        return Utils.toString(lastUpdate);
    }
}
