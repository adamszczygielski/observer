package observer.application.service;

import lombok.extern.slf4j.Slf4j;
import observer.application.model.Status;

import java.text.MessageFormat;

@Slf4j
abstract class SearchExecutionTemplate<S, I> {

    void execute(S search) {
        long startTimeMillis = System.currentTimeMillis();
        try {
            I items = fetchItems(search);
            removeItems(search);
            insertItems(search, items);
            update(search, Status.SUCCESS);
            resetErrorCounter(search);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            incrementErrorCounter(search);
            update(search, Status.FAILED);
        }
        log.info(MessageFormat.format("Execution time: {0}ms",
                System.currentTimeMillis() - startTimeMillis));
    }

    abstract I fetchItems(S search);

    abstract void insertItems(S search, I items);

    abstract void removeItems(S search);

    abstract void update(S search, Status status);

    abstract void incrementErrorCounter(S search);

    abstract void resetErrorCounter(S search);
}
