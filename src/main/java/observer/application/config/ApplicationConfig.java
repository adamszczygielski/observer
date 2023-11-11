package observer.application.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;

import java.time.Duration;

@Configuration
@EnableAsync
@EnableJpaRepositories("observer.application.repository")
@Getter
public class ApplicationConfig {

    @Value("#{T(org.springframework.boot.convert.DurationStyle).detectAndParse('${observer.items.retention}')}")
    private Duration itemsRetention;

    @Value("#{T(org.springframework.boot.convert.DurationStyle).detectAndParse('${observer.items.notification-delay}')}")
    private Duration itemsNotificationDelay;

    @Value("#{T(org.springframework.boot.convert.DurationStyle).detectAndParse('${observer.searches.error.delay}')}")
    private Duration searchesErrorDelay;

    @Value("${observer.searches.error.threshold}")
    private Integer searchesErrorThreshold;

    @Value("${observer.allegro.token-private}")
    private String allegroTokenPrivate;

    @Value("#{T(org.springframework.boot.convert.DurationStyle).detectAndParse('${observer.allegro.delay}')}")
    private Duration allegroDelay;

    @Value("#{T(org.springframework.boot.convert.DurationStyle).detectAndParse('${observer.allegrolokalnie.delay}')}")
    private Duration allegroLokalnieDelay;

    @Value("#{T(org.springframework.boot.convert.DurationStyle).detectAndParse('${observer.olx.delay}')}")
    private Duration olxDelay;

    @Value("#{T(org.springframework.boot.convert.DurationStyle).detectAndParse('${observer.ebay.delay}')}")
    private Duration ebayDelay;

    @Value("${observer.ebay.security-appname}")
    private String ebaySecurityAppname;

    @Value("${observer.onesignal.app-id}")
    private String onesignalAppId;

    @Value("${observer.onesignal.api-key}")
    private String onesignalApiKey;

    @Value("${observer.chromedriver.logging}")
    private Boolean chromedriverLogging;

    @Value("#{'${observer.chromedriver.arguments}'.split(' ')}")
    private String[] chromedriverArguments;

    @Value("${observer.ftp.hostname}")
    private String ftpHostname;

    @Value("${observer.ftp.username}")
    private String ftpUsername;

    @Value("${observer.ftp.password}")
    private String ftpPassword;

    @Value("${observer.ftp.filepath}")
    private String ftpFilepath;

    @Value(("${observer.error-notification}"))
    private Boolean errorNotification;
}
