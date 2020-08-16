package observer.application.service;

import observer.application.api.Source;
import observer.application.domain.Item;
import observer.application.domain.Search;
import observer.application.repository.SearchRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import static observer.application.common.Utils.now;

@Service
public class SearchExecutor {

    private final SearchRepository searchRepository;
    private final ItemServiceFactory itemServiceFactory;
    private final Integer chunk;
    private final Long delay;
    private final Long uncheckedLimit;

    public SearchExecutor(SearchRepository searchRepository, ItemServiceFactory itemServiceFactory,
                          @Value("${search.chunk}") Integer chunk, @Value("${item.delay}") Long delay,
                          @Value("${search.unchecked-limit}") Long uncheckedLimit) {
        this.searchRepository = searchRepository;
        this.itemServiceFactory = itemServiceFactory;
        this.chunk = chunk;
        this.delay = delay;
        this.uncheckedLimit = uncheckedLimit;
    }

    @Transactional
    public void executeAll() {
        List<Search> searchList = searchRepository.findAllToUpdate(now(), PageRequest.of(0, chunk));
        searchList.forEach(this::updateSearch);
    }

    @Transactional
    public void executeAllImmediately() {
        List<Search> searchList = searchRepository.findAll();
        searchList.forEach(this::updateSearch);
    }

    private void updateSearch(Search search) {
        //check limit
        if (isAboveLimit(search)) {
            return;
        }

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
        search.getItemList().addAll(fetchedItems);

        //save to db
        save(search);
    }

    private boolean isAboveLimit(Search search) {
        return search.getItemList().stream().filter(Item::getIsActive).count() > uncheckedLimit;
    }

    private List<Item> fetchItems(Search search) {
        Source source = Source.getSource(search.getSourceId());
        ItemService itemService = itemServiceFactory.create(source);
        return itemService.getItems(search);
    }

    private void save(Search search) {
        search.setDateUpdated(now());
        searchRepository.save(search);
    }
}