package observer.application.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
public class ApplicationProperties {

    @Value("${observer.allegro.token-private}")
    private String allegroTokenPrivate;

    @Value("${observer.allegro.delay-seconds}")
    private Long allegroDelaySeconds;

    @Value("${observer.olx.delay-seconds}")
    private Long olxDelaySeconds;

    @Value("${observer.ebay.delay-seconds}")
    private Long ebayDelaySeconds;

    @Value("${observer.ebay.security-appname}")
    private String ebaySecurityAppname;

    @Value("${observer.onesignal.app-id}")
    private String onesignalAppId;

    @Value("${observer.onesignal.api-key}")
    private String onesignalApiKey;

    @Value("${observer.notification.delay-seconds}")
    private Integer notificationDelaySeconds;

    @Value("${observer.chromedriver.logging}")
    private Boolean chromedriverLogging;

    @Value("#{'${observer.chromedriver.arguments}'.split(' ')}")
    private String[] chromedriverArguments;

}
