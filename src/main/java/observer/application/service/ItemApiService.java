package observer.application.service;

import lombok.RequiredArgsConstructor;
import observer.application.domain.Category;
import observer.application.domain.Item;
import observer.application.domain.Search;
import observer.application.domain.Source;
import observer.application.repository.ItemRepository;
import observer.application.repository.SearchRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemApiService {

    private final ItemRepository itemRepository;
    private final SearchRepository searchRepository;
    private final SourceService sourceService;

    public List<Item> getActiveItems(Long searchId) {
        return itemRepository.findActive(searchId).orElseGet(ArrayList::new);
    }

    public List<Item> getActiveItems() {
        return itemRepository.findActive().orElseGet(ArrayList::new);
    }

    public List<Item> fetchItems(Long searchId) {
        return searchRepository.findById(searchId).map(this::fetchItems).orElseGet(ArrayList::new);
    }

    public void deleteItems(List<Long> itemIds) {
        itemRepository.setInactive(itemIds);
    }

    public List<Category> getCategories(int sourceId, String parentId) {
        ItemService itemService = getItemService(sourceId);
        return itemService.getCategories(parentId);
    }

    private List<Item> fetchItems(Search search) {
        ItemService itemService = getItemService(search.getSourceId());
        return itemService.getItems(search);
    }

    private ItemService getItemService(int sourceId) {
        Source source = Source.getSource(sourceId);
        return sourceService.get(source);
    }

}
