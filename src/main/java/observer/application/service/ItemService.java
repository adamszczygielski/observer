package observer.application.service;

import observer.application.api.ParameterType;
import observer.application.domain.Category;
import observer.application.domain.Item;
import observer.application.domain.Parameter;
import observer.application.domain.Search;

import java.util.List;

public abstract class ItemService {

    public abstract List<Item> getItems(Search search);
    public abstract List<Category> getCategories(String parentId);

    protected String getParameterValue(List<Parameter> parameters, ParameterType parameterType) {
        return parameters.stream().filter(p -> p.getTypeId().equals(parameterType.getId())).findFirst()
                .map(Parameter::getValue).orElse(null);
    }
}
