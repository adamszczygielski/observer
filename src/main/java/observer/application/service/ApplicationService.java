package observer.application.service;

import observer.application.api.Source;
import observer.application.domain.Item;
import observer.application.domain.Search;
import observer.application.repository.ItemRepository;
import observer.application.repository.SearchRepository;
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
        ItemService itemService = itemServiceFactory.create(source);
        return itemService.getItems(search);
    }

    public void deleteItems(List<Long> itemIds) {
        itemRepository.setInactive(itemIds);
    }
}
