package observer.application.mapper;

import observer.application.api.SearchViewDto;
import observer.application.api.Source;
import observer.application.domain.SearchView;
import org.springframework.stereotype.Component;

import static observer.application.mapper.MapperUtils.toLocalTime;
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
                .dateUpdated(toLocalTime(searchView.getDateUpdated()))
                .timeInterval(searchView.getTimeInterval())
                .count(searchView.getCount())
                .build();
    }

}
