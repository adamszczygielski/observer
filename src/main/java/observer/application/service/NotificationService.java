package observer.application.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import observer.application.config.ApplicationConfig;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;

@Service
@Slf4j
@RequiredArgsConstructor
public class NotificationService {

    private final WebClient webClient;
    private final ApplicationConfig applicationConfig;

    public void sendNotification(String title, String message) {
        log.info("Sending notification");

        String uri = UriComponentsBuilder.newInstance()
                .scheme("https")
                .host("api.pushover.net")
                .pathSegment("1", "messages.json")
                .queryParam("token", applicationConfig.getNotificationToken())
                .queryParam("user", applicationConfig.getNotificationUser())
                .queryParam("title", title.replaceAll(" ", "+"))
                .queryParam("message", message.replaceAll(" ", "+"))
                .queryParam("url", applicationConfig.getNotificationAppUrl())
                .build()
                .toUriString();

        webClient.post()
                .uri(uri)
                .retrieve()
                .bodyToMono(String.class)
                .subscribe();
    }
}
