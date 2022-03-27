package observer.application.service.source;

import observer.application.config.ApplicationProperties;
import observer.application.model.Category;
import observer.application.model.Item;
import observer.application.model.Search;
import observer.application.model.Source;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public abstract class SourceService {

    @Autowired
    protected ApplicationProperties applicationProperties;

    public abstract Source getSource();

    public abstract long getDelay();

    public abstract List<Item> getItems(Search search);

    public abstract List<Category> getCategories(String parentId);

}