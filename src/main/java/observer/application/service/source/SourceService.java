package observer.application.service.source;

import lombok.RequiredArgsConstructor;
import observer.application.config.ApplicationConfig;
import observer.application.model.Category;
import observer.application.model.Item;
import observer.application.model.Search;
import observer.application.model.Source;

import java.time.Duration;
import java.util.List;

@RequiredArgsConstructor
public abstract class SourceService {

    protected final ApplicationConfig applicationConfig;

    public abstract Source getSource();

    public abstract Duration getDelay();

    public abstract List<Item> fetchItems(Search search);

    public abstract List<Category> fetchCategories(String parentId);
}
