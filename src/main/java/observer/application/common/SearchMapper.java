package observer.application.common;

import observer.application.api.ParameterType;
import observer.application.api.SearchDto;
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
                .keyword(Utils.normalize(searchDto.getKeyword()))
                .category(toCategory(searchDto))
                .dateUpdated(new Timestamp(0))
                .isActive(false)
                .sourceId(searchDto.getSource().getId())
                .timeInterval(searchDto.getInterval())
                .parameterList(toParameters(searchDto))
                .build();
    }

    private List<Parameter> toParameters(SearchDto searchDto) {
        List<Parameter> parameters = new ArrayList<>();

        Integer priceFrom = searchDto.getPriceFrom();
        if (priceFrom != null) {
            parameters.add(toParameter(ParameterType.PRICE_FROM, String.valueOf(priceFrom)));
        }

        Integer priceTo = searchDto.getPriceTo();
        if (priceTo != null) {
            parameters.add(toParameter(ParameterType.PRICE_TO, String.valueOf(priceTo)));
        }

        return parameters;
    }

    private Parameter toParameter(ParameterType parameterType, String value) {
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