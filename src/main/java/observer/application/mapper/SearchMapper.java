package observer.application.mapper;

import com.google.common.base.Strings;
import observer.application.api.SearchDto;
import observer.application.api.Source;
import observer.application.domain.Search;
import org.springframework.stereotype.Component;

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