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
                .keyword(searchDto.getKeyword())
                .category(searchDto.getCategory())
                .dateUpdated(new Timestamp(0))
                .isActive(false)
                .sourceId(searchDto.getSource().getId())
                .timeInterval(searchDto.getInterval())
                .parameterList(toParameters(searchDto))
                .build();
    }

    private List<Parameter> toParameters(SearchDto searchDto) {
        List<Parameter> parameters = new ArrayList<>();

        if(!StringUtils.isEmpty(searchDto.getPriceFrom())) {
            Parameter parameter = Parameter.builder()
                    .typeId(ParameterType.PRICE_FROM.getId())
                    .value(searchDto.getPriceFrom())
                    .build();
            parameters.add(parameter);
        }

        if(!StringUtils.isEmpty(searchDto.getPriceTo())) {
            Parameter parameter = Parameter.builder()
                    .typeId(ParameterType.PRICE_TO.getId())
                    .value(searchDto.getPriceTo())
                    .build();
            parameters.add(parameter);
        }

        return parameters;
    }

}