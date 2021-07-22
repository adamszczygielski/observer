package observer.application.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
public class ApplicationProperties {

    @Value("${observer.allegro.token.private}")
    private String allegroTokenPrivate;

    @Value("${observer.allegro.token.jwt.hours}")
    private Integer allegroTokenJwtHours;

    @Value("${observer.allegro.delay.millis}")
    private Long allegroDelayMillis;

    @Value("${observer.olx.delay.millis}")
    private Long olxDelayMillis;

    @Value("${observer.ebay.delay.millis}")
    private Long ebayDelayMillis;

    @Value("${observer.ebay.security.appname}")
    private String ebaySecurityAppname;

    @Value("${observer.onesignal.app.id}")
    private String onesignalAppId;

    @Value("${observer.onesignal.api.key}")
    private String onesignalApiKey;

    @Value("${observer.search.unchecked-limit}")
    private Integer searchUncheckedLimit;

    @Value("${observer.item.remove-delay}")
    private Integer itemRemoveDelay;

    @Value("${observer.scheduled.notification.delay}")
    private Integer scheduledNotificationDelay;

    @Value("${observer.proxies}")
    private String[] proxies;

    @Value("${observer.chromedriver.headless}")
    private Boolean chromedriverHeadless;

    @Value("${observer.chromedriver.images}")
    private Boolean chromedriverImages;

}
