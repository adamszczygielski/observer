package observer.application.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import observer.application.config.ApplicationConfig;
import observer.application.dto.Source;
import observer.application.dto.Status;
import observer.application.model.Item;
import observer.application.model.Search;
import observer.application.service.source.SourceServiceSolver;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.MessageFormat;
import java.time.Instant;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;

@Service
@RequiredArgsConstructor
@Slf4j
public class SearchExecutionService extends SearchExecutionTemplate<Search, List<Item>> {

    private final Map<Integer, Integer> errorCounter = new HashMap<>();
    private final SearchService searchService;
    private final ItemService itemService;
    private final SourceServiceSolver sourceServiceSolver;
    private final ApplicationConfig applicationConfig;

    @Transactional
    public void execute(Source source) {
        searchService.getOverdue(source.getId()).ifPresent(this::execute);
    }

    public int getErrorCount(int sourceId) {
        return errorCounter.getOrDefault(sourceId, 0);
    }

    @Override
    void removeItems(Search search) {
        Predicate<Item> p1 = Item::getIsDeleted;
        Predicate<Item> p2 = i -> i.getCreatedDate()
                .plus(applicationConfig.getItemsRetention())
                .isBefore(Instant.now());
        search.getItems().removeIf(p1.and(p2));
    }

    @Override
    List<Item> fetchItems(Search search) {
        return sourceServiceSolver.get(search.getSourceId()).fetchItems(search);
    }

    @Override
    void insertItems(Search search, List<Item> fetchedItems) {
        if (fetchedItems.isEmpty()) {
            log.info(MessageFormat.format("Items found: {0}/{1}", 0, 0));
        } else {
            Set<String> originIds = itemService.getOriginIds(search.getSourceId());
            List<Item> newItems = fetchedItems.stream()
                    .filter(fetchedItem -> !originIds.contains(fetchedItem.getOriginId()))
                    .toList();
            search.getItems().addAll(newItems);
            log.info(MessageFormat.format("Items found: {0}/{1}", newItems.size(), fetchedItems.size()));
        }
    }

    @Override
    void update(Search search, Status status) {
        search.setLastExecutionDate(Instant.now());
        search.setStatusId(status.getId());
    }

    @Override
    void incrementErrorCounter(Search search) {
        errorCounter.merge(search.getSourceId(), 1, Integer::sum);
    }

    @Override
    void resetErrorCounter(Search search) {
        errorCounter.put(search.getSourceId(), 0);
    }
}
