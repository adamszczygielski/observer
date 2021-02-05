package observer.application.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
public class ConfigProperties {

    @Value("${observer.allegro.token.private}")
    private String allegroTokenPrivate;

    @Value("${observer.allegro.token.jwt.hours}")
    private Integer allegroTokenJwtHours;

    @Value("${observer.ebay.security.appname}")
    private String ebaySecurityAppname;

    @Value("${observer.onesignal.app.id}")
    private String onesignalAppId;

    @Value("${observer.onesignal.api.key}")
    private String onesignalApiKey;

    @Value("${observer.search.chunk.size}")
    private Integer searchChunkSize;

    @Value("${observer.search.unchecked.limit}")
    private Integer searchUncheckedLimit;

    @Value("${observer.item.removal.delay}")
    private Integer itemRemovalDelay;

}
