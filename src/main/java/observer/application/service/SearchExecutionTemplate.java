package observer.application.service;

import lombok.extern.slf4j.Slf4j;
import observer.application.model.Status;

import java.text.MessageFormat;

@Slf4j
abstract class SearchExecutionTemplate<S, I> {

    final void execute(S search) {
        long startTimeMillis = System.currentTimeMillis();
        try {
            I items = fetchItems(search);
            removeItems(search, items);
            insertItems(search, items);
            update(search, Status.SUCCESS);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            update(search, Status.FAILED);
        }
        log.info(MessageFormat.format("Execution time: {0}ms",
                System.currentTimeMillis() - startTimeMillis));
    }

    abstract I fetchItems(S search);

    abstract void insertItems(S search, I items);

    abstract void removeItems(S search, I items);

    abstract void update(S search, Status status);
}
