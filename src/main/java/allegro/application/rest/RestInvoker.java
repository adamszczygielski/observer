package allegro.application.rest;

import org.springframework.http.HttpEntity;

public interface RestInvoker {

    <E, R> R get(String url, HttpEntity<E> httpEntity, Class<R> responseClass);
    <E, R> R post(String url, HttpEntity<E> httpEntity, Class<R> responseClass);
}