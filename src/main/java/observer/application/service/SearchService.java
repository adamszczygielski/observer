package observer.application.service;

import lombok.RequiredArgsConstructor;
import observer.application.domain.Source;
import observer.application.config.ConfigProperties;
import observer.application.domain.Item;
import observer.application.domain.Search;
import observer.application.domain.Status;
import observer.application.repository.SearchRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@RequiredArgsConstructor
public class SearchService extends UpdateTemplate<Search, List<Item>> {

    private final SearchRepository searchRepository;
    private final SourceService sourceService;
    private final ConfigProperties properties;

    @Transactional
    public void execute() {
        searchRepository.findOverdue(PageRequest.of(0, properties.getSearchFetchChunkSize()))
                .forEach(this::updateSearch);
    }

    @Transactional
    public void executeImmediately(List<Long> searchIds) {
        searchRepository.findAllById(searchIds)
                .forEach(this::updateSearch);
    }

    boolean isAboveLimit(Search search) {
        return search.getItemList().stream()
                .filter(Item::getIsActive)
                .count() > properties.getSearchUncheckedLimit();
    }

    List<Item> fetchItems(Search search) {
        Source source = Source.getSource(search.getSourceId());
        ItemService itemService = sourceService.get(source);
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
                && item.getDateCreated().plus(properties.getItemRemoveDelay(), ChronoUnit.DAYS).isBefore(Instant.now()));
    }

    void updateStatus(Search search, Status status) {
        search.setDateUpdated(Instant.now());
        search.setStatusId(status.getId());
    }

}
