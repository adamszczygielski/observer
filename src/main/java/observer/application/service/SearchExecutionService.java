package observer.application.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import observer.application.config.ApplicationProperties;
import observer.application.model.Item;
import observer.application.model.Search;
import observer.application.model.Source;
import observer.application.model.Status;
import observer.application.repository.SearchRepository;
import observer.application.service.source.SourceServiceFactory;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.MessageFormat;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.function.Predicate;

import static java.util.stream.Collectors.toList;

@Slf4j
@Service
@RequiredArgsConstructor
public class SearchExecutionService extends SearchExecutionTemplate<Search, List<Item>> {

    private static final PageRequest PAGE_REQUEST = PageRequest.of(0, 1);

    private final SearchRepository searchRepository;
    private final SourceServiceFactory sourceServiceFactory;
    private final ApplicationProperties applicationProperties;

    @Transactional
    public void execute(Source source) {
        searchRepository.findOverdue(source.getId(), PAGE_REQUEST).forEach(this::execute);
    }

    @Override
    List<Item> fetchItems(Search search) {
        return sourceServiceFactory.get(search.getSourceId()).fetchItems(search);
    }

    @Override
    void removeItems(Search search) {
        Predicate<Item> p1 = Item::getIsDeleted;
        Predicate<Item> p2 = i -> i.getCreatedDate()
                .plus(applicationProperties.getItemsRetentionDays(), ChronoUnit.DAYS)
                .isBefore(Instant.now());
        search.getItems().removeIf(p1.and(p2));
    }

    @Override
    void insertItems(Search search, List<Item> fetchedItems) {
        List<Item> newItems = fetchedItems.stream()
                .filter(fetchedItem -> !search.getItems().contains(fetchedItem))
                .collect(toList());
        search.getItems().addAll(newItems);
        log.info(MessageFormat.format("Items found: {0}/{1}", newItems.size(), fetchedItems.size()));
    }

    @Override
    void update(Search search, Status status) {
        search.setLastExecutionDate(Instant.now());
        search.setStatusId(status.getId());
    }

}
