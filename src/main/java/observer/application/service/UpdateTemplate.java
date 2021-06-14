package observer.application.service;

import lombok.extern.slf4j.Slf4j;
import observer.application.domain.Status;

@Slf4j
abstract class UpdateTemplate<S, I> {

    void updateSearch(S search) {
        if (isAboveLimit(search)) {
            return;
        }

        try {
            I items = fetchItems(search);
            addNewItems(search, items);
            removeOldItems(search, items);
            updateStatusAndDate(search, Status.SUCCESS);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            updateStatusAndDate(search, Status.FAILED);
        }
    }

    abstract boolean isAboveLimit(S search);

    abstract I fetchItems(S search);

    abstract void addNewItems(S search, I items);

    abstract void removeOldItems(S search, I items);

    abstract void updateStatusAndDate(S search, Status status);
}
