package observer.application.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import observer.application.config.ApplicationProperties;
import observer.application.domain.Item;
import observer.application.domain.Search;
import observer.application.domain.Source;
import observer.application.domain.Status;
import observer.application.repository.SearchRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Slf4j
@Service
@RequiredArgsConstructor
public class SearchService extends UpdateTemplate<Search, List<Item>> {

    private final SearchRepository searchRepository;
    private final SourceService sourceService;
    private final ApplicationProperties properties;

   @Transactional
    public void invoke(Source source) {
        searchRepository.findOverdue(source.getId(), PageRequest.of(0, 1))
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
        List<Item> newItems = fetchedItems.stream()
                .filter(item -> !search.getItemList().contains(item))
                .collect(toList());

        search.getItemList().addAll(newItems);
    }

    void removeOldItems(Search search, List<Item> fetchedItems) {
        search.getItemList().removeIf(item -> !item.getIsActive() && !fetchedItems.contains(item)
                && item.getDateCreated().plus(properties.getItemRemoveDelay(), ChronoUnit.DAYS).isBefore(Instant.now()));
    }

    void updateStatusAndDate(Search search, Status status) {
        search.setDateUpdated(Instant.now());
        search.setStatusId(status.getId());
    }

}
