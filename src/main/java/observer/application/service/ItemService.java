package observer.application.service;

import lombok.RequiredArgsConstructor;
import observer.application.model.Item;
import observer.application.repository.ItemRepository;
import observer.application.repository.SearchRepository;
import observer.application.service.source.SourceServiceSolver;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class ItemService {

    private static final PageRequest PAGE_REQUEST = PageRequest.of(0, 2000);

    private final ItemRepository itemRepository;
    private final SearchRepository searchRepository;
    private final SourceServiceSolver sourceServiceSolver;

    public List<Item> getItems(Long searchId) {
        return itemRepository.findByIsDeletedFalseAndSearchIdOrderByCreatedDateDesc(searchId);
    }

    public List<Item> getItems() {
        return itemRepository.findByIsDeletedFalseOrderByCreatedDateDesc(PAGE_REQUEST);
    }

    public Set<String> getOriginIds(Integer sourceId) {
        return itemRepository.findOriginIds(sourceId);
    }

    public List<Item> fetchItems(Long searchId) {
        return searchRepository.findById(searchId)
                .map(s -> sourceServiceSolver.get(s.getSourceId()).fetchItems(s))
                .orElse(Collections.emptyList());
    }

    public void deleteItems(List<Long> itemIds) {
        itemRepository.setIsDeletedTrue(itemIds);
    }
}
