package observer.application.service;

import observer.application.domain.Category;
import observer.application.domain.Item;
import observer.application.domain.Search;

import java.util.List;

public abstract class ItemService {

    public abstract List<Item> getItems(Search search);
    public abstract List<Category> getCategories(String parentId);

}
