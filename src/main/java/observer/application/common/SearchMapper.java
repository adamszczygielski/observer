package observer.application.common;

import com.google.common.base.Strings;
import observer.application.api.SearchDto;
import observer.application.api.Source;
import observer.application.domain.Search;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.ArrayList;

@Component
public class SearchMapper {

    public Search toSearch(SearchDto searchDto) {
        return Search.builder()
                .id(searchDto.getSearchId())
                .keyword(Utils.normalize(searchDto.getKeyword()))
                .categoryId(toNullable(searchDto.getCategoryId()))
                .categoryName(toNullable(searchDto.getCategoryName()))
                .dateUpdated(new Timestamp(0))
                .isActive(false)
                .sourceId(searchDto.getSource().getId())
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
                .build();
    }

    private String toNullable(String s) {
        if (Strings.isNullOrEmpty(s)) {
            return null;
        }
        return s;
    }

}