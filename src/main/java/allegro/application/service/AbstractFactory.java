package allegro.application.service;

import allegro.application.api.Source;

public interface AbstractFactory<T> {
    T create(Source source);
}
