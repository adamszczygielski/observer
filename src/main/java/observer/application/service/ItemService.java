package observer.application.service;

import lombok.extern.slf4j.Slf4j;
import observer.application.domain.Category;
import observer.application.domain.Item;
import observer.application.domain.Search;

import java.util.List;

@Slf4j
public abstract class ItemService {

    protected abstract List<Item> getItems(Search search);

    protected abstract List<Category> getCategories(String parentId);

}
