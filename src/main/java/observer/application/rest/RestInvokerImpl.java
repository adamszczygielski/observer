package observer.application.rest;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.ssl.SSLContexts;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.xml.MappingJackson2XmlHttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.net.ssl.SSLContext;
import java.security.cert.X509Certificate;
import java.util.List;
import java.util.Optional;

@Component
@Slf4j
public class RestInvokerImpl implements RestInvoker {

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

        HttpClientBuilder httpClientBuilder = HttpClientBuilder.create()
                .setDefaultRequestConfig(requestConfig)
                .setConnectionManager(connectionManager);
        createSSLConnectionSocketFactory().ifPresent(httpClientBuilder::setSSLSocketFactory);
        CloseableHttpClient httpClient = httpClientBuilder.build();

        return new RestTemplateBuilder()
                .requestFactory(() -> new HttpComponentsClientHttpRequestFactory(httpClient))
                .messageConverters(
                        new StringHttpMessageConverter(),
                        createMappingJackson2HttpMessageConverter(),
                        createMappingJackson2XmlHttpMessageConverter())
                .build();
    }

    private MappingJackson2HttpMessageConverter createMappingJackson2HttpMessageConverter() {
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setSupportedMediaTypes(List.of(MediaType.TEXT_HTML));
        return converter;
    }

    private MappingJackson2XmlHttpMessageConverter createMappingJackson2XmlHttpMessageConverter() {
        MappingJackson2XmlHttpMessageConverter converter = new MappingJackson2XmlHttpMessageConverter();
        converter.setSupportedMediaTypes(List.of(MediaType.APPLICATION_RSS_XML));
        converter.setObjectMapper(createXmlMapper());
        return converter;
    }

    private XmlMapper createXmlMapper() {
        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, false);
        xmlMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return xmlMapper;
    }

    private Optional<SSLConnectionSocketFactory> createSSLConnectionSocketFactory() {
        try {
            SSLContext sslContext = SSLContexts.custom()
                    .loadTrustMaterial(null, (X509Certificate[] chain, String authType) -> true)
                    .build();
            return Optional.of(new SSLConnectionSocketFactory(sslContext));
        } catch (Exception e) {
            log.error("Error creating SSL", e);
            return Optional.empty();
        }
    }
}