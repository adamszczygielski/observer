package allegro.application.service;

import allegro.application.api.ItemDto;
import allegro.application.domain.Item;
import allegro.application.domain.Search;

import java.util.List;

public interface ItemService {

    List<Item> getItems(Search search);
    List<ItemDto> getPreview(Search search);
}
