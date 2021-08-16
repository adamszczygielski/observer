package observer.application.service;

import observer.application.model.Category;
import observer.application.model.Item;
import observer.application.model.Search;

import java.util.List;

public abstract class ItemService {

    protected abstract List<Item> getItems(Search search);

    protected abstract List<Category> getCategories(String parentId);

}
