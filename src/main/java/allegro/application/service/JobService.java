package allegro.application.service;

import allegro.application.api.Source;
import allegro.application.domain.Item;
import allegro.application.domain.Search;
import allegro.application.repository.SearchRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class JobService {

    private final SearchRepository searchRepository;
    private final ItemServiceFactory itemServiceFactory;

    private final Logger log = Logger.getLogger(getClass().getName());

    public void execute() {
        List<Search> searchList = searchRepository.findAllToUpdate(new Timestamp(System.currentTimeMillis()));
        log.log(Level.INFO, "---------- Found " + searchList.size() + " search queries to execute");
        searchList.forEach(this::updateSearch);
    }

    private void updateSearch(Search search) {
        List<Item> fetchedItems;

        log.log(Level.INFO, "---------- Executing search query with id: " + search.getId() + ", source: " + search.getSourceId());
        Source source = Source.getSource(search.getSourceId());
        ItemService itemService = itemServiceFactory.create(source);
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
        search.setDateUpdated(new Timestamp(System.currentTimeMillis()));
        searchRepository.save(search);
        log.log(Level.INFO, "---------- Result saved to Database");
    }
}