package observer.application.common;

import observer.application.api.ParameterType;
import observer.application.api.SearchDto;
import observer.application.api.Source;
import observer.application.domain.Parameter;
import observer.application.domain.Search;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Component
public class SearchMapper {

    public Search toSearch(SearchDto searchDto) {
        return Search.builder()
                .id(searchDto.getSearchId())
                .keyword(Utils.normalize(searchDto.getKeyword()))
                .category(toCategory(searchDto))
                .dateUpdated(new Timestamp(0))
                .isActive(false)
                .sourceId(searchDto.getSource().getId())
                .timeInterval(searchDto.getInterval())
                .itemList(new ArrayList<>())
                .parameterList(toParameters(searchDto))
                .build();
    }

    public SearchDto toSearchDto(Search search) {
        SearchDto.SearchDtoBuilder searchDtoBuilder = SearchDto.builder()
                .searchId(search.getId())
                .keyword(search.getKeyword())
                .category(search.getCategory())
                .dateUpdated(search.getDateUpdated())
                .interval(search.getTimeInterval())
                .source(Source.getSource(search.getSourceId()));

        if (!search.getParameterList().isEmpty()) {
            Parameter priceFrom = getParameter(ParameterType.PRICE_FROM, search.getParameterList());
            if (priceFrom != null) {
                searchDtoBuilder.priceFrom(Integer.valueOf(priceFrom.getValue()));
            }

            Parameter priceTo = getParameter(ParameterType.PRICE_TO, search.getParameterList());
            if (priceTo != null) {
                searchDtoBuilder.priceTo(Integer.valueOf(priceTo.getValue()));
            }
        }

        return searchDtoBuilder.build();
    }

    private Parameter getParameter(ParameterType parameterType, List<Parameter> parameters) {
        return parameters.stream().filter(p -> p.getTypeId().equals(parameterType.getId())).findFirst()
                .orElse(null);
    }

    private List<Parameter> toParameters(SearchDto searchDto) {
        List<Parameter> parameters = new ArrayList<>();

        Integer priceFrom = searchDto.getPriceFrom();
        if (priceFrom != null) {
            parameters.add(createParameter(ParameterType.PRICE_FROM, String.valueOf(priceFrom)));
        }

        Integer priceTo = searchDto.getPriceTo();
        if (priceTo != null) {
            parameters.add(createParameter(ParameterType.PRICE_TO, String.valueOf(priceTo)));
        }

        return parameters;
    }

    private Parameter createParameter(ParameterType parameterType, String value) {
        return Parameter.builder()
                .typeId(parameterType.getId())
                .value(value)
                .build();
    }

    private String toCategory(SearchDto searchDto) {
        String category = searchDto.getCategory();
        if (StringUtils.isEmpty(category)) {
            return null;
        } else {
            return category;
        }
    }

}