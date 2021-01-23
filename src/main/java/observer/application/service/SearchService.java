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

import static java.util.stream.Collectors.toList;
import static observer.application.common.Utils.now;

@Service
public class SearchService extends UpdateTemplate<Search, List<Item>> {

    private final SearchRepository searchRepository;
    private final ItemServiceFactory itemServiceFactory;
    private final Integer chunk;
    private final Long delay;
    private final Long uncheckedLimit;

    public SearchService(SearchRepository searchRepository, ItemServiceFactory itemServiceFactory,
                         @Value("${search.chunk}") Integer chunk, @Value("${item.removal.delay}") Long delay,
                         @Value("${search.unchecked-limit}") Long uncheckedLimit) {
        this.searchRepository = searchRepository;
        this.itemServiceFactory = itemServiceFactory;
        this.chunk = chunk;
        this.delay = delay;
        this.uncheckedLimit = uncheckedLimit;
    }

    @Transactional
    public void execute() {
        searchRepository.findAllToUpdate(now(), PageRequest.of(0, chunk)).forEach(this::updateSearch);
    }

    @Transactional
    public void executeImmediately(List<Long> searchIds) {
        searchRepository.findAllById(searchIds).forEach(this::updateSearch);
    }

    boolean isAboveLimit(Search search) {
        return search.getItemList().stream().filter(Item::getIsActive).count() > uncheckedLimit;
    }

    List<Item> fetchItems(Search search) {
        Source source = Source.getSource(search.getSourceId());
        ItemService itemService = itemServiceFactory.create(source);
        return itemService.getItems(search);
    }

    void addNewItems(Search search, List<Item> fetchedItems) {
        List<String> searchItemsIds = search.getItemList().stream().map(Item::getOriginId).collect(toList());
        List<Item> newItemsList = fetchedItems.stream()
                .filter(fetchedItem -> !searchItemsIds.contains(fetchedItem.getOriginId())).collect(toList());
        search.getItemList().addAll(newItemsList);
    }

    void removeOldItems(Search search, List<Item> fetchedItems) {
        List<String> fetchedItemsIds = fetchedItems.stream().map(Item::getOriginId).collect(toList());
        search.getItemList().removeIf(item -> !item.getIsActive()
                && !fetchedItemsIds.contains(item.getOriginId())
                && item.getDateCreated().toLocalDateTime().plusDays(delay).isBefore(LocalDateTime.now()));
    }

    void updateDate(Search search) {
        search.setDateUpdated(now());
    }

}
