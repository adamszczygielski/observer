package allegro.application.service;

import allegro.application.api.ItemDto;
import allegro.application.api.Source;
import allegro.application.common.ItemAssembler;
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

    private final ItemAssembler itemAssembler;
    private final ItemRepository itemRepository;
    private final SearchRepository searchRepository;
    private final ItemServiceFactory itemServiceFactory;

    public List<ItemDto> fetchItems(Long searchId) {
        Optional<List<Item>> itemList = itemRepository.findActiveItemsBySeachId(searchId);
        if (itemList.isPresent()) {
            return itemAssembler.toDtoList(itemList.get());
        }
        return new ArrayList<>();
    }

    public List<ItemDto> fetchActiveItems() {
        Optional<List<Item>> itemList = itemRepository.findActiveItems();
        if (itemList.isPresent()) {
            return itemAssembler.toDtoList(itemList.get());
        }
        return new ArrayList<>();
    }

    public List<ItemDto> fetchItemsPreview(Long searchId) {
        Optional<Search> searchOptional = searchRepository.findById(searchId);
        if(!searchOptional.isPresent()) {
            return new ArrayList<>();
        }
        Search search = searchOptional.get();
        Source source = Source.getSource(search.getSourceId());
        ItemService itemService = itemServiceFactory.create(source);
        return itemService.getPreview(search);
    }

    public void deleteItem(Long itemId) {
        itemRepository.setItemInactive(itemId);
    }
}
