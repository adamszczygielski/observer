package allegro.application.service;

import allegro.application.api.Source;
import allegro.application.domain.Item;
import allegro.application.domain.Search;
import allegro.application.repository.ItemRepository;
import allegro.application.repository.SearchRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ApplicationService {

    private final ItemRepository itemRepository;
    private final SearchRepository searchRepository;
    private final ItemServiceFactory itemServiceFactory;

    public List<Item> fetchItems(Long searchId) {
        return itemRepository.findActiveItemsBySeachId(searchId).orElseGet(ArrayList::new);
    }

    public List<Item> fetchActiveItems() {
        return itemRepository.findActiveItems().orElseGet(ArrayList::new);
    }

    public List<Item> fetchItemsPreview(Long searchId) {
        Optional<Search> searchOptional = searchRepository.findById(searchId);
        if(!searchOptional.isPresent()) {
            return new ArrayList<>();
        }
        Search search = searchOptional.get();
        Source source = Source.getSource(search.getSourceId());
        ItemService itemService = itemServiceFactory.create(source);
        return itemService.getItems(search);
    }

    public void deleteItem(Long itemId) {
        itemRepository.setItemInactive(itemId);
    }
}
