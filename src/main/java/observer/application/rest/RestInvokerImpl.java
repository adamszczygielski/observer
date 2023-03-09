package observer.application.rest;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RestInvokerImpl implements RestInvoker {

    private static final RestTemplate REST_TEMPLATE = new RestTemplate();

    @Override
    public <T, P> P get(String url, HttpEntity<T> httpEntity, Class<P> responseClass) {
        ResponseEntity<P> responseEntity = REST_TEMPLATE.exchange(url, HttpMethod.GET, httpEntity, responseClass);
        return responseEntity.getBody();
    }

    @Override
    public <T, P> P post(String url, HttpEntity<T> httpEntity, Class<P> responseClass) {
        ResponseEntity<P> responseEntity = REST_TEMPLATE.exchange(url, HttpMethod.POST, httpEntity, responseClass);
        return responseEntity.getBody();
    }

}