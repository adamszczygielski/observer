package observer.application.mapper;

import observer.application.api.SearchDto;
import observer.application.domain.Search;
import observer.application.domain.Source;
import observer.application.domain.Status;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

import static observer.application.mapper.MapperUtils.normalize;

@Component
public class SearchMapper {

    public Search toSearch(SearchDto searchDto) {
        return Search.builder()
                .id(searchDto.getSearchId())
                .keyword(normalize(searchDto.getKeyword()))
                .categoryId(searchDto.getCategoryId())
                .categoryName(searchDto.getCategoryName())
                .sourceId(searchDto.getSource().getId())
                .statusId(Status.PENDING.getId())
                .timeInterval(searchDto.getInterval())
                .itemList(new ArrayList<>())
                .priceFrom(searchDto.getPriceFrom())
                .priceTo(searchDto.getPriceTo())
                .build();
    }

    public SearchDto toSearchDto(Search search) {
        return SearchDto.builder()
                .searchId(search.getId())
                .keyword(search.getKeyword())
                .categoryId(search.getCategoryId())
                .categoryName(search.getCategoryName())
                .dateUpdated(search.getDateUpdated())
                .interval(search.getTimeInterval())
                .priceFrom(search.getPriceFrom())
                .priceTo(search.getPriceTo())
                .source(Source.getSource(search.getSourceId()))
                .status(Status.getStatus(search.getStatusId()))
                .build();
    }

}