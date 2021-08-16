package observer.application.service;

import lombok.RequiredArgsConstructor;
import observer.application.config.ApplicationProperties;
import observer.application.model.Item;
import observer.application.model.Search;
import observer.application.model.Source;
import observer.application.model.Status;
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
public class SearchUpdateService extends SearchUpdateTemplate<Search, List<Item>> {

    private final SearchRepository searchRepository;
    private final SourceService sourceService;
    private final ApplicationProperties properties;

    @Transactional
    public void invoke(Source source) {
        searchRepository.findOverdue(source.getId(), PageRequest.of(0, 1))
                .forEach(this::updateSearch);
    }

    @Override
    boolean isAboveLimit(Search search) {
        return search.getItemList().stream()
                .filter(Item::getIsActive)
                .count() > properties.getSearchUncheckedLimit();
    }

    @Override
    List<Item> fetchItems(Search search) {
        ItemService itemService = sourceService.get(search.getSourceId());
        return itemService.getItems(search);
    }

    @Override
    void addNewItems(Search search, List<Item> fetchedItems) {
        search.getItemList().addAll(fetchedItems.stream()
                .filter(fetchedItem -> !search.getItemList().contains(fetchedItem))
                .collect(toList()));
    }

    @Override
    void removeOldItems(Search search, List<Item> fetchedItems) {
        search.getItemList().removeIf(item -> !item.getIsActive() && !fetchedItems.contains(item)
                && item.getDateCreated().plus(properties.getItemRemoveDelay(), ChronoUnit.DAYS).isBefore(Instant.now()));
    }

    @Override
    void updateStatusAndDate(Search search, Status status) {
        search.setDateUpdated(Instant.now());
        search.setStatusId(status.getId());
    }

}
