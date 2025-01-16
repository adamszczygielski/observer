package observer.application.rest;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;

import java.util.List;

@Component
@Slf4j
public class DefaultRestInvoker implements RestInvoker {

    private static final short TIMEOUT_MILLIS = 5000;
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
        RequestConfig requestConfig = RequestConfig.custom()
                .setConnectionRequestTimeout(TIMEOUT_MILLIS)
                .setSocketTimeout(TIMEOUT_MILLIS)
                .setConnectTimeout(TIMEOUT_MILLIS)
                .setCookieSpec(CookieSpecs.IGNORE_COOKIES)
                .build();

        PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager();
        connectionManager.setMaxTotal(5);
        connectionManager.setDefaultMaxPerRoute(5);

        CloseableHttpClient httpClient = HttpClientBuilder.create()
                .setDefaultRequestConfig(requestConfig)
                .setConnectionManager(connectionManager)
                .build();

        DefaultUriBuilderFactory defaultUriBuilderFactory = new DefaultUriBuilderFactory();
        defaultUriBuilderFactory.setEncodingMode(DefaultUriBuilderFactory.EncodingMode.NONE);

        RestTemplate rt = new RestTemplateBuilder()
                .requestFactory(() -> new HttpComponentsClientHttpRequestFactory(httpClient))
                .uriTemplateHandler(defaultUriBuilderFactory)
                .build();

        MappingJackson2HttpMessageConverter httpMessageConverter = new MappingJackson2HttpMessageConverter();
        httpMessageConverter.setSupportedMediaTypes(List.of(MediaType.TEXT_HTML));

        rt.getMessageConverters().add(httpMessageConverter);
        return rt;
    }
}
