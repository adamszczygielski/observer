package observer.application.service.source;

import observer.application.config.ApplicationConfig;
import observer.application.model.Category;
import observer.application.model.Item;
import observer.application.model.Search;
import observer.application.model.Source;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public abstract class SourceService {

    @Autowired
    protected ApplicationConfig applicationConfig;

    public abstract Source getSource();

    public abstract long getDelaySeconds();

    public abstract List<Item> fetchItems(Search search);

    public abstract List<Category> fetchCategories(String parentId);

}
