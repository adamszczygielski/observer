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
    private ItemService allegroService;
    private ItemService olxSerivce;
    private final Logger log = Logger.getLogger(getClass().getName());

    public List<ItemDto> fetchItems(Long searchId) {
        Optional<List<Item>> itemList = itemRepository.findActiveItems(searchId);
        if (itemList.isPresent()) {
            return itemAssembler.toDtoList(itemList.get());
        }
        return new ArrayList<>();
    }

    public List<ItemDto> fetchItemsPreview(Long searchId) {
        Optional<Search> search = searchRepository.findById(searchId);
        if (search.isPresent()) {
            if (search.get().getSource().equals("allegro")) {
                return allegroService.getPreview(search.get());
            }
            if(search.get().getSource().equals("olx")) {
                return olxSerivce.getPreview(search.get());
            }
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
        List<Item> fetchedItems;

        if (search.getSource().equals("allegro")) {
            log.log(Level.INFO, "---------- Updating search query with id: " + search.getId() + ", source: " + search.getSource());
            fetchedItems = allegroService.getItems(search);
        } else if (search.getSource().equals("olx")) {
            log.log(Level.INFO, "---------- Updating search query with id: " + search.getId() + ", source: " + search.getSource());
            fetchedItems = olxSerivce.getItems(search);
        } else {
            log.log(Level.WARNING, "---------- No service implementation for source: " + search.getSource() + " unable to fetch items!");
            return;
        }

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
        log.log(Level.INFO, "---------- Saved to database");
        searchRepository.save(search);
    }
}
