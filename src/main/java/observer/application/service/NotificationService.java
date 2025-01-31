package observer.application.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import observer.application.config.ApplicationConfig;
import observer.application.dto.NotificationRequestDto;
import observer.application.dto.NotificationResponseDto;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Collections;
import java.util.HashMap;

@Service
@Slf4j
@RequiredArgsConstructor
public class NotificationService {

    private static final String REQUEST_URL = "https://onesignal.com/api/v1/notifications";

    private final WebClient webClient;
    private final ApplicationConfig applicationConfig;

    public void sendNotification(String message) {
        NotificationRequestDto notificationRequestDto = createNotificationRequestDto(message);
        webClient.post()
                .uri(REQUEST_URL)
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(notificationRequestDto)
                .header("Authorization", applicationConfig.getOnesignalApiKey())
                .retrieve()
                .bodyToMono(NotificationResponseDto.class)
                .subscribe(
                        notificationResponseDto -> {
                            log.info("Notification has been sent with ID: {}", notificationResponseDto.id());
                        },
                        error -> {
                            log.error("Sending notification failed!", error);
                        }
                );
    }

    private NotificationRequestDto createNotificationRequestDto(String message) {
        return NotificationRequestDto.builder()
                .appId(applicationConfig.getOnesignalAppId())
                .includedSegments(Collections.singletonList("All"))
                .contents(new HashMap<>() {{
                    put("en", message);
                }}).build();
    }
}
