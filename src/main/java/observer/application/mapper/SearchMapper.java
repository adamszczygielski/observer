package observer.application.mapper;

import com.google.common.base.Strings;
import observer.application.api.SearchDto;
import observer.application.domain.Source;
import observer.application.domain.Search;
import observer.application.domain.Status;
import org.springframework.stereotype.Component;

import javax.annotation.Nullable;
import java.util.ArrayList;

@Component
public class SearchMapper {

    public Search toSearch(SearchDto searchDto) {
        return Search.builder()
                .id(searchDto.getSearchId())
                .keyword(MapperUtils.normalize(searchDto.getKeyword()))
                .categoryId(toNullable(searchDto.getCategoryId()))
                .categoryName(toNullable(searchDto.getCategoryName()))
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

    private String toNullable(@Nullable String value) {
        if (Strings.isNullOrEmpty(value)) {
            return null;
        }
        return value;
    }

}