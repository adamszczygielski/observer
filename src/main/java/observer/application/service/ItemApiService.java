package observer.application.service;

import lombok.RequiredArgsConstructor;
import observer.application.api.Source;
import observer.application.domain.Category;
import observer.application.domain.Item;
import observer.application.domain.Search;
import observer.application.repository.ItemRepository;
import observer.application.repository.SearchRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ItemApiService {

    private final ItemRepository itemRepository;
    private final SearchRepository searchRepository;
    private final SourceService sourceService;

    public List<Item> fetchActiveItems(Long searchId) {
        return itemRepository.findActive(searchId).orElseGet(ArrayList::new);
    }

    public List<Item> fetchActiveItems() {
        return itemRepository.findActive().orElseGet(ArrayList::new);
    }

    public List<Item> fetchItemsPreview(Long searchId) {
        Optional<Search> searchOptional = searchRepository.findById(searchId);
        if(!searchOptional.isPresent()) {
            return new ArrayList<>();
        }
        Search search = searchOptional.get();
        Source source = Source.getSource(search.getSourceId());
        ItemService itemService = sourceService.get(source);
        return itemService.getItems(search);
    }

    public void deleteItems(List<Long> itemIds) {
        itemRepository.setInactive(itemIds);
    }

    public List<Category> getCategories(Long sourceId, String parentId) {
        Source source = Source.getSource(sourceId);
        ItemService itemService = sourceService.get(source);
        return itemService.getCategories(parentId);
    }
}
