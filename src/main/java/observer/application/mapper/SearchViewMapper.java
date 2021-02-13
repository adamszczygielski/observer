package observer.application.mapper;

import observer.application.api.SearchViewDto;
import observer.application.api.Source;
import observer.application.domain.SearchView;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.Optional;

import static observer.application.mapper.MapperUtils.trim;

@Component
public class SearchViewMapper implements BaseMapper<SearchView, SearchViewDto> {

    private static final int MAX_LENGTH = 20;

    @Override
    public SearchViewDto toDto(SearchView searchView) {
        return SearchViewDto.builder()
                .id(searchView.getId())
                .keyword(trim(searchView.getKeyword(), MAX_LENGTH))
                .categoryId(trim(searchView.getCategoryId(), MAX_LENGTH))
                .categoryName(trim(searchView.getCategoryName(), MAX_LENGTH))
                .priceFrom(searchView.getPriceFrom())
                .priceTo(searchView.getPriceTo())
                .source(Source.getSource(searchView.getSourceId()).getLabel())
                .dateUpdated(toString(searchView.getDateUpdated()))
                .timeInterval(searchView.getTimeInterval())
                .count(searchView.getCount())
                .build();
    }

    private String toString(Timestamp lastUpdate) {
        return Optional.ofNullable(lastUpdate)
                .map(MapperUtils::toString)
                .orElse("");
    }

}
