package allegro.application.service;

import allegro.application.api.ItemDto;
import allegro.application.common.ItemAssembler;
import allegro.application.entity.Item;
import allegro.application.entity.Search;
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
    private AllegroService allegroService;
    private final Logger log = Logger.getLogger(getClass().getName());

    public List<ItemDto> fetchItems(Long searchId) {
        Optional<List<Item>> itemList = itemRepository.findActiveItems(searchId);
        if(itemList.isPresent()) {
            return itemAssembler.toDtoList(itemList.get());
        }
        return new ArrayList<>();
    }

    public List<ItemDto> fetchItemsPreview(Long searchId) {
        Optional<Search> search = searchRepository.findById(searchId);
        if(search.isPresent()) {
            return allegroService.getPreview(search.get());
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
        log.log(Level.INFO, "---------- Found " + searchList.size() + " search queries to update");
        searchList.forEach(this::updateSearch);
    }

    private void updateSearch(Search search) {
        log.log(Level.INFO, "---------- Updating search query with id: " + search.getId());
        List<Item> fetchedItems = allegroService.getItems(search);
        log.log(Level.INFO, "---------- Fetched " + fetchedItems.size() + " items" );
        List<Long> fetchedItemIds = fetchedItems.stream().map(Item::getItemId).collect(Collectors.toList());
        //remove checked, non-existing items
        search.getItemList().removeIf(item -> !item.getIsActive() && !fetchedItemIds.contains(item.getItemId()));
        List<Long> searchItemIds = search.getItemList().stream().map(Item::getItemId).collect(Collectors.toList());
        //filter new items, add all
        fetchedItems.removeIf(item -> searchItemIds.contains(item.getItemId()));
        log.log(Level.INFO, "---------- There's " + fetchedItems.size() + " new items");
        search.getItemList().addAll(fetchedItems);
        //save to db
        search.setLastUpdate(new Timestamp(System.currentTimeMillis()));
        log.log(Level.INFO, "---------- Saved to database");
        searchRepository.save(search);
    }
}
