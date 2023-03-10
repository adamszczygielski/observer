package observer.application.rest;

import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RestInvokerImpl implements RestInvoker {

    private static final short TIME_OUT_MILLIS = 5000;
    private final RestTemplate restTemplate = createRestTemplate();

    @Override
    public <T, P> P get(String url, HttpEntity<T> httpEntity, Class<P> responseClass) {
        return restTemplate.exchange(url, HttpMethod.GET, httpEntity, responseClass).getBody();
    }

    @Override
    public <T, P> P post(String url, HttpEntity<T> httpEntity, Class<P> responseClass) {
        return restTemplate.exchange(url, HttpMethod.POST, httpEntity, responseClass).getBody();
    }

    private RestTemplate createRestTemplate() {
        return new RestTemplateBuilder()
                .requestFactory(this::createRequestFactory)
                .build();
    }

    private HttpComponentsClientHttpRequestFactory createRequestFactory() {
        RequestConfig requestConfig = RequestConfig.custom()
                .setConnectionRequestTimeout(TIME_OUT_MILLIS)
                .setSocketTimeout(TIME_OUT_MILLIS)
                .setConnectTimeout(TIME_OUT_MILLIS)
                .setCookieSpec(CookieSpecs.STANDARD)
                .build();

        PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager();
        connectionManager.setMaxTotal(5);
        connectionManager.setDefaultMaxPerRoute(5);

        CloseableHttpClient httpClient = HttpClientBuilder.create()
                .setDefaultRequestConfig(requestConfig)
                .setConnectionManager(connectionManager)
                .build();

        return new HttpComponentsClientHttpRequestFactory(httpClient);
    }
}