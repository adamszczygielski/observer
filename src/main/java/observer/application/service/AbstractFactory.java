package observer.application.service;

import observer.application.api.Source;

public interface AbstractFactory<T> {
    T create(Source source);
}
