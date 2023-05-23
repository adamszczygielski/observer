package observer.application.service.source.olx.mapper;

import observer.application.model.Item;
import observer.application.model.Search;
import observer.application.model.Source;
import observer.application.service.source.olx.model.Ad;
import observer.application.service.source.olx.model.Price;
import org.springframework.web.util.UriComponentsBuilder;

import java.time.Instant;
import java.util.Optional;

public class OlxMapper {

    public String toUrl(Search search) {
        String category = Optional.ofNullable(search.getCategoryId()).orElse("oferty");
        String keyword = "q-" + search.getKeyword().replaceAll(" ", "-");
        return UriComponentsBuilder.newInstance()
                .scheme("https")
                .host("www.olx.pl")
                .pathSegment(category)
                .pathSegment(keyword)
                .build()
                .toUri()
                .toString();
    }

    public Item toItem(Ad ad, Long searchId) {
        return Item.builder()
                .originId(ad.getId())
                .searchId(searchId)
                .createdDate(Instant.now())
                .title(ad.getTitle())
                .price(toPrice(ad.getPrice()))
                .url(ad.getUrl())
                .isDeleted(false)
                .isNotificationSent(false)
                .sourceId(Source.OLX.getId())
                .build();
    }

    private String toPrice(Price price) {
        return Optional.ofNullable(price)
                .map(Price::getRegularPrice)
                .map(p -> p.getValue() + " " + p.getCurrencyCode())
                .orElse("0.00 PLN");
    }
}
