package observer.application.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import observer.application.config.ApplicationConfig;
import observer.application.dto.NotificationRequestDto;
import observer.application.dto.NotificationResponseDto;
import observer.application.rest.JsonMapper;
import observer.application.rest.RestInvoker;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashMap;

@Service
@Slf4j
@RequiredArgsConstructor
public class NotificationService {

    private static final String REQUEST_URL = "https://onesignal.com/api/v1/notifications";

    private final JsonMapper jsonMapper;
    private final RestInvoker restInvoker;
    private final ApplicationConfig applicationConfig;

    @Async
    public void sendNotification(String message) {
        NotificationRequestDto notificationRequest = getNotificationRequest(message);
        String requestBody = jsonMapper.toJson(notificationRequest);
        try {
            NotificationResponseDto responseDto = restInvoker.post(REQUEST_URL, createHttpEntity(requestBody),
                    NotificationResponseDto.class);
            log.info("Notification has been sent with ID {}", responseDto.getId());
        } catch (Exception e) {
            log.error("Sending notification failed", e);
        }
    }

    private NotificationRequestDto getNotificationRequest(String message) {
        return NotificationRequestDto.builder()
                .appId(applicationConfig.getOnesignalAppId())
                .includedSegments(Collections.singletonList("All"))
                .contents(new HashMap<>() {{put("en", message);}})
                .build();
    }

    private HttpEntity<String> createHttpEntity(String requestBody) {
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setContentType(MediaType.APPLICATION_JSON);
        requestHeaders.add("Authorization", applicationConfig.getOnesignalApiKey());
        return new HttpEntity<>(requestBody, requestHeaders);
    }
}
