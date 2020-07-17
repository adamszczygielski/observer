package allegro.application.service;

import allegro.application.api.Source;
import allegro.application.domain.Item;
import allegro.application.domain.Search;
import allegro.application.repository.SearchRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import static allegro.application.common.Utils.now;

@Service
public class SearchUpdateService {

    private final SearchRepository searchRepository;
    private final ItemServiceFactory itemServiceFactory;
    private final Integer chunk;
    private final Long delay;

    private final Logger log = Logger.getLogger(getClass().getName());

    public SearchUpdateService(SearchRepository searchRepository, ItemServiceFactory itemServiceFactory,
                               @Value("${search.chunk}") Integer chunk, @Value("${item.delay}") Long delay) {
        this.searchRepository = searchRepository;
        this.itemServiceFactory = itemServiceFactory;
        this.chunk = chunk;
        this.delay = delay;
    }

    @Transactional
    public void execute() {
        List<Search> searchList = searchRepository.findAllToUpdate(now(), PageRequest.of(0, chunk));
        log.log(Level.INFO, "Found " + searchList.size() + " search queries to execute");
        searchList.forEach(this::updateSearch);
    }

    private void updateSearch(Search search) {
        //fetch items
        List<Item> fetchedItems = fetchItems(search);

        List<String> fetchedItemsIds = fetchedItems.stream().map(Item::getOriginId).collect(Collectors.toList());
        List<String> searchItemsIds = search.getItemList().stream().map(Item::getOriginId).collect(Collectors.toList());

        //remove checked, non-existing items, older than specific amount of time
        search.getItemList().removeIf(item -> !item.getIsActive()
                && !fetchedItemsIds.contains(item.getOriginId())
                && item.getDateCreated().toLocalDateTime().plusDays(delay).isBefore(LocalDateTime.now()));

        //filter new items, add all
        fetchedItems.removeIf(item -> searchItemsIds.contains(item.getOriginId()));
        log.log(Level.INFO, "There's " + fetchedItems.size() + " new items");
        search.getItemList().addAll(fetchedItems);

        //save to db
        save(search);
    }

    private List<Item> fetchItems(Search search) {
        log.log(Level.INFO, "Executing search query with id: " + search.getId() + ", source: " + search.getSourceId());
        Source source = Source.getSource(search.getSourceId());
        ItemService itemService = itemServiceFactory.create(source);
        List<Item> fetchedItems = itemService.getItems(search);
        log.log(Level.INFO, "Fetched " + fetchedItems.size() + " items");
        return fetchedItems;
    }

    private void save(Search search) {
        search.setDateUpdated(now());
        searchRepository.save(search);
        log.log(Level.INFO, "Result saved to Database");
    }
}