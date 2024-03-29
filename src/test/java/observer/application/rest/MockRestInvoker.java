package observer.application.rest;

import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpEntity;

@Setter
public class MockRestInvoker implements RestInvoker {

    private final JsonMapper jsonMapper = new JsonMapperImpl();
    private String body = "";

    @Override
    public <E, R> R get(String url, HttpEntity<E> httpEntity, Class<R> responseClass) {
        return jsonMapper.toObject(body, responseClass);
    }

    @Override
    public <E, R> R post(String url, HttpEntity<E> httpEntity, Class<R> responseClass) {
        return null;
    }

    @RequiredArgsConstructor
    public static class PageContent {
        private String body;
        private ContentType contentType;
    }

    public enum ContentType {
        JSON,
        XML
    }
}
