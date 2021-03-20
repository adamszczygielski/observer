package observer.application.notification;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import observer.application.config.ConfigProperties;
import observer.application.domain.Item;
import observer.application.repository.ItemRepository;
import observer.application.rest.RestInvoker;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Collections;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class NotificationService {

    private static final String MESSAGE = "Found %s new item%s!";

    private final ObjectMapper objectMapper;
    private final ItemRepository itemRepository;
    private final RestInvoker restInvoker;
    private final ConfigProperties properties;

    public void execute() {
        itemRepository.findUnnotified(PageRequest.of(0, 100))
                .ifPresent(items -> sendNotification(items.size())
                        .ifPresent(response -> itemRepository.setNotified(items.stream().map(Item::getId)
                                .collect(Collectors.toList()))));
    }

    private Optional<NotificationResponse> sendNotification(int itemsCount) {
        try {
            String requestBody = objectMapper.writeValueAsString(getNotificationRequest(itemsCount));
            return Optional.of(
                    restInvoker.post(getRequestUrl(), createHttpEntity(requestBody), NotificationResponse.class));
        } catch (JsonProcessingException | RestClientException e) {
            log.error("Sending notification failed", e);
        }
        return Optional.empty();
    }

    private HttpEntity<String> createHttpEntity(String requestBody) {
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setContentType(MediaType.APPLICATION_JSON);
        requestHeaders.add("Authorization", properties.getOnesignalApiKey());
        return new HttpEntity<>(requestBody, requestHeaders);
    }

    private String getRequestUrl() {
        return UriComponentsBuilder.newInstance()
                .scheme("https")
                .host("onesignal.com")
                .pathSegment("api", "v1", "notifications")
                .build().toUriString();
    }

    private NotificationRequest getNotificationRequest(int itemsCount) {
        return NotificationRequest.builder()
                .appId(properties.getOnesignalAppId())
                .includedSegments(Collections.singletonList("All"))
                .contents(Collections.singletonMap("en", getMessageContent(itemsCount)))
                .build();
    }

    private String getMessageContent(int itemsCount) {
        if (itemsCount == 1) {
            return String.format(MESSAGE, itemsCount, "");
        }
        return String.format(MESSAGE, itemsCount, "s");
    }

}
