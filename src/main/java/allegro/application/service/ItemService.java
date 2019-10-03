package allegro.application.service;

import allegro.application.entity.Item;
import allegro.application.entity.Search;

import java.util.List;

public interface ItemService {

    List<Item> getItems(Search search);
}
