package observer.application.service.source;

import observer.application.model.Category;
import observer.application.model.Item;
import observer.application.model.Search;
import observer.application.model.Source;

import java.util.List;

public interface SourceService {

    Source getSource();

    List<Item> getItems(Search search);

    List<Category> getCategories(String parentId);

}
