package observer.application.common;

import observer.application.api.SearchViewDto;
import observer.application.api.Source;
import observer.application.domain.SearchView;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

import static observer.application.common.Utils.trim;

@Component
public class SearchViewMapper implements BaseMapper<SearchView, SearchViewDto> {

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
