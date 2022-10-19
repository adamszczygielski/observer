package observer.application.service;

import lombok.RequiredArgsConstructor;
import observer.application.model.Category;
import observer.application.model.Item;
import observer.application.repository.ItemRepository;
import observer.application.repository.SearchRepository;
import observer.application.service.source.SourceServiceFactory;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;
    private final SearchRepository searchRepository;
    private final SourceServiceFactory sourceServiceFactory;

    public List<Item> getItems(Long searchId) {
        return itemRepository.findByIsDeletedFalseAndSearchIdOrderByCreatedDateDesc(searchId);
    }

    public List<Item> getItems() {
        return itemRepository.findByIsDeletedFalseOrderByCreatedDateDesc();
    }

    public List<Item> fetchItems(Long searchId) {
        return searchRepository.findById(searchId)
                .map(s -> sourceServiceFactory.get(s.getSourceId()).fetchItems(s))
                .orElse(Collections.emptyList());
    }

    public void deleteItems(List<Long> itemIds) {
        itemRepository.setIsDeletedTrue(itemIds);
    }

    public List<Category> getCategories(int sourceId, String parentId) {
        return sourceServiceFactory.get(sourceId).fetchCategories(parentId);
    }

}
