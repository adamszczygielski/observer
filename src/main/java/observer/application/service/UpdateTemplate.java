package observer.application.service;

abstract class UpdateTemplate<S, I> {

    void updateSearch(S s) {
        if (isAboveLimit(s)) {
            return;
        }
        I i = fetchItems(s);
        addNewItems(s, i);
        removeOldItems(s, i);
        updateDate(s);
    }

    abstract boolean isAboveLimit(S s);

    abstract I fetchItems(S s);

    abstract void addNewItems(S s, I i);

    abstract void removeOldItems(S s, I i);

    abstract void updateDate(S s);
}
