package allegro.application.common;

import allegro.application.api.SearchViewDto;
import allegro.application.api.Source;
import allegro.application.domain.SearchView;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

import static allegro.application.common.Utils.trim;

@Component
public class SearchViewAssembler implements BaseAssembler <SearchView, SearchViewDto> {

    private static final int MAX_LENGTH = 20;

    @Override
    public SearchViewDto toDto(SearchView searchView) {
        return SearchViewDto.builder()
                .id(searchView.getId())
                .keyword(trim(searchView.getKeyword(), MAX_LENGTH))
                .category(trim(searchView.getCategory(), MAX_LENGTH))
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
