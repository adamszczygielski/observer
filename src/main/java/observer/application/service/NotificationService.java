package observer.application.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import observer.application.config.ApplicationProperties;
import observer.application.dto.NotificationRequestDto;
import observer.application.dto.NotificationResponseDto;
import observer.application.rest.JsonMapper;
import observer.application.rest.RestInvoker;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Collections;
import java.util.HashMap;

@Service
@Slf4j
@RequiredArgsConstructor
public class NotificationService {

    private final JsonMapper jsonMapper;
    private final RestInvoker restInvoker;
    private final ApplicationProperties applicationProperties;

    public void sendNotification(String message) {
        NotificationRequestDto notificationRequest = getNotificationRequest(message);
        String requestBody = jsonMapper.toJson(notificationRequest);
        try {
            restInvoker.post(getRequestUrl(), createHttpEntity(requestBody), NotificationResponseDto.class);
            log.info("Notification has been sent");
        } catch (Exception e) {
            log.error("Sending notification failed", e);
        }
    }

    private NotificationRequestDto getNotificationRequest(String message) {
        return NotificationRequestDto.builder()
                .appId(applicationProperties.getOnesignalAppId())
                .includedSegments(Collections.singletonList("All"))
                .contents(new HashMap<String, String>() {{
                    put("en", message);
                }}).build();
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

}
