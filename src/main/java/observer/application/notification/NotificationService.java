package observer.application.notification;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import observer.application.domain.Item;
import observer.application.repository.ItemRepository;
import observer.application.rest.RestInvoker;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class NotificationService {

    private final ObjectMapper objectMapper = new ObjectMapper();
    private final String apiKey;
    private final String appId;
    private final ItemRepository itemRepository;
    private final RestInvoker restInvoker;

    public NotificationService(@Value("${onesignal.api.key}") String apiKey, @Value("${onesignal.app.id}") String appId,
                               ItemRepository itemRepository, RestInvoker restInvoker) {
        this.apiKey = apiKey;
        this.appId = appId;
        this.itemRepository = itemRepository;
        this.restInvoker = restInvoker;
    }

    public void execute() {
        Optional<List<Item>> optionalItems = itemRepository.findUnnotified(PageRequest.of(0, 100));

        if (!optionalItems.isPresent()) {
            return;
        }
        List<Item> items = optionalItems.get();
        String requestBody = createRequestBody(items.size());
        NotificationResponse notificationResponse =
                restInvoker.post(createRequestUrl(), createHttpEntity(requestBody), NotificationResponse.class);

        if (notificationResponse != null) {
            itemRepository.setNotified(items.stream().map(Item::getId).collect(Collectors.toList()));
        }
    }

    private HttpEntity<String> createHttpEntity(String requestBody) {
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setContentType(MediaType.APPLICATION_JSON);
        requestHeaders.add("Authorization", apiKey);

        return new HttpEntity<>(requestBody, requestHeaders);
    }

    private String createRequestUrl() {
        return UriComponentsBuilder.newInstance()
                .scheme("https")
                .host("onesignal.com")
                .pathSegment("api", "v1", "notifications")
                .build().toUriString();
    }

    private String createRequestBody(int itemsCount) {
        NotificationRequest notificationRequest = NotificationRequest.builder()
                .appId(appId)
                .includedSegments(Collections.singletonList("All"))
                .contents(Collections.singletonMap("en", "Found " + itemsCount + " new items!"))
                .build();

        try {
            return objectMapper.writeValueAsString(notificationRequest);
        } catch (JsonProcessingException e) {
            log.error("Object serialization error", e);
            return "{}";
        }
    }

}
