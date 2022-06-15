package observer.application.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import observer.application.config.ApplicationProperties;
import observer.application.dto.NotificationRequestDto;
import observer.application.dto.NotificationResponseDto;
import observer.application.repository.ItemRepository;
import observer.application.rest.RestInvoker;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class NotificationService {

    private static final PageRequest PAGE_REQUEST = PageRequest.of(0, 100);
    private static final String MESSAGE = "Found %s new item%s!";

    private final ObjectMapper objectMapper;
    private final ItemRepository itemRepository;
    private final RestInvoker restInvoker;
    private final ApplicationProperties applicationProperties;

    @Scheduled(fixedDelayString = "#{@applicationProperties.getNotificationDelaySeconds()}")
    public void execute() {
        itemRepository.findActiveAndNotNotified(PAGE_REQUEST)
                .ifPresent((itemIds -> sendNotification(itemIds.size())
                        .ifPresent(response -> itemRepository.setNotified(itemIds))));
    }

    private Optional<NotificationResponseDto> sendNotification(int itemsCount) {
        try {
            String requestBody = objectMapper.writeValueAsString(getNotificationRequest(itemsCount));
            log.info("Notification has been sent");
            return Optional.of(
                    restInvoker.post(getRequestUrl(), createHttpEntity(requestBody), NotificationResponseDto.class));
        } catch (JsonProcessingException | RestClientException e) {
            log.error("Sending notification failed", e);
        }
        return Optional.empty();
    }

    private HttpEntity<String> createHttpEntity(String requestBody) {
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setContentType(MediaType.APPLICATION_JSON);
        requestHeaders.add("Authorization", applicationProperties.getOnesignalApiKey());
        return new HttpEntity<>(requestBody, requestHeaders);
    }

    private String getRequestUrl() {
        return UriComponentsBuilder.newInstance()
                .scheme("https")
                .host("onesignal.com")
                .pathSegment("api", "v1", "notifications")
                .build().toUriString();
    }

    private NotificationRequestDto getNotificationRequest(int itemsCount) {
        return NotificationRequestDto.builder()
                .appId(applicationProperties.getOnesignalAppId())
                .includedSegments(Collections.singletonList("All"))
                .contents(getNotificationContents(itemsCount))
                .build();
    }

    private Map<String, String> getNotificationContents(int itemsCount) {
        return Collections.singletonMap("en", String.format(MESSAGE, itemsCount, itemsCount == 1 ? "" : "s"));
    }

}
