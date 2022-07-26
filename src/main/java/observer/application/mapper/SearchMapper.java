package observer.application.mapper;

import observer.application.dto.SearchDto;
import observer.application.model.Search;
import observer.application.model.Source;
import observer.application.model.Status;

import java.text.Normalizer;
import java.util.Collections;

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
                .itemList(Collections.emptyList())
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

    private static String normalize(String string) {
        return Normalizer
                .normalize(string, Normalizer.Form.NFD)
                .replaceAll("[^\\p{ASCII}]", "")
                .replaceAll(" +", " ")
                .toLowerCase();
    }

}