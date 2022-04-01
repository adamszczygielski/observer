package observer.application.service;

import lombok.RequiredArgsConstructor;
import observer.application.model.Category;
import observer.application.model.Item;
import observer.application.repository.ItemRepository;
import observer.application.repository.SearchRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;
    private final SearchRepository searchRepository;
    private final SourceServiceResolver sourceServiceResolver;

    public List<Item> getActiveItems(Long searchId) {
        return itemRepository.findActive(searchId).orElse(Collections.emptyList());
    }

    public List<Item> getActiveItems() {
        return itemRepository.findActive().orElse(Collections.emptyList());
    }

    public List<Item> fetchItems(Long searchId) {
        return searchRepository.findById(searchId)
                .map(s -> sourceServiceResolver.get(s.getSourceId()).fetchItems(s))
                .orElse(Collections.emptyList());
    }

    public void deleteItems(List<Long> itemIds) {
        itemRepository.setInactive(itemIds);
    }

    public List<Category> getCategories(int sourceId, String parentId) {
        return sourceServiceResolver.get(sourceId).fetchCategories(parentId);
    }

}
