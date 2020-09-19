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
    public void execute() {
        List<Search> searchList = searchRepository.findAllToUpdate(now(), PageRequest.of(0, chunk));
        searchList.forEach(this::updateSearch);
    }

    @Transactional
    public void executeImmediately() {
        List<Search> searchList = searchRepository.findAll();
        searchList.forEach(this::updateSearch);
    }

    private void updateSearch(Search search) {
        if (isAboveLimit(search)) {
            return;
        }
        addNewItems(search);
        removeOldItems(search);
        save(search);
    }

    private void addNewItems(Search search) {
        List<Item> fetchedItems = fetchItems(search);
        List<String> searchItemsIds = search.getItemList().stream().map(Item::getOriginId).collect(Collectors.toList());
        fetchedItems.removeIf(item -> searchItemsIds.contains(item.getOriginId()));
        search.getItemList().addAll(fetchedItems);
    }

    private void removeOldItems(Search search) {
        search.getItemList().removeIf(item -> !item.getIsActive()
                && item.getDateCreated().toLocalDateTime().plusDays(delay).isBefore(LocalDateTime.now()));
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