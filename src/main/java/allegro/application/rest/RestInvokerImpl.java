package allegro.application.rest;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@AllArgsConstructor
public class RestInvokerImpl implements RestInvoker {

    private final RestTemplate restTemplate;

    @Override
    public <T, P> P get(String url, HttpEntity<T> httpEntity, Class<P> responseClass) {
        ResponseEntity<P> responseEntity = restTemplate.exchange(url, HttpMethod.GET, httpEntity, responseClass);
        return responseEntity.getBody();
    }

    @Override
    public <T, P> P post(String url, HttpEntity<T> httpEntity, Class<P> responseClass) {
        ResponseEntity<P> responseEntity = restTemplate.exchange(url, HttpMethod.POST, httpEntity, responseClass);
        return responseEntity.getBody();
    }
}