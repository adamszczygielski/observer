package allegro.application.service;

import allegro.application.api.ItemDto;
import allegro.application.common.ItemAssembler;
import allegro.application.domain.Item;
import allegro.application.domain.Search;
import allegro.application.repository.ItemRepository;
import allegro.application.repository.SearchRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ApplicationService {

    private ItemAssembler itemAssembler;
    private ItemRepository itemRepository;
    private SearchRepository searchRepository;
    private ItemServiceFactory itemServiceFactory;
    private final Logger log = Logger.getLogger(getClass().getName());

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
        if (searchOptional.isPresent()) {
            Search search = searchOptional.get();
            ItemService itemService = itemServiceFactory.createItemService(search);
            return itemService.getPreview(search);
        }
        return new ArrayList<>();
    }

    public void deleteItem(Long itemId) {
        itemRepository.findById(itemId).ifPresent(item -> {
            item.setIsActive(false);
            itemRepository.save(item);
        });
    }

    public void updateDatabase() {
        List<Search> searchList = searchRepository.findAll().stream()
                .filter(s -> s.getLastUpdate().before(new Timestamp(System.currentTimeMillis() - TimeUnit.MINUTES.toMillis(s.getTimeInterval()))))
                .collect(Collectors.toList());
        log.log(Level.INFO, "---------- Found " + searchList.size() + " search queries to execute");
        searchList.forEach(this::updateSearch);
    }

    private void updateSearch(Search search) {
        List<Item> fetchedItems;

        log.log(Level.INFO, "---------- Executing search query with id: " + search.getId() + ", source: " + search.getSource());
        ItemService itemService = itemServiceFactory.createItemService(search);
        fetchedItems = itemService.getItems(search);
        log.log(Level.INFO, "---------- Fetched " + fetchedItems.size() + " items");

        List<String> fetchedItemIds = fetchedItems.stream().map(Item::getOriginId).collect(Collectors.toList());

        //remove checked, non-existing items
        search.getItemList().removeIf(item -> !item.getIsActive() && !fetchedItemIds.contains(item.getOriginId()));
        List<String> searchItemIds = search.getItemList().stream().map(Item::getOriginId).collect(Collectors.toList());

        //filter new items, add all
        fetchedItems.removeIf(item -> searchItemIds.contains(item.getOriginId()));
        log.log(Level.INFO, "---------- There's " + fetchedItems.size() + " new items");
        search.getItemList().addAll(fetchedItems);

        //save to db
        search.setLastUpdate(new Timestamp(System.currentTimeMillis()));
        searchRepository.save(search);
        log.log(Level.INFO, "---------- Result saved to Database");
    }
}
