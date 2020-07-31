package observer.application.service;

import observer.application.domain.Item;
import observer.application.domain.Search;

import java.util.List;

public interface ItemService {

    List<Item> getItems(Search search);
}
