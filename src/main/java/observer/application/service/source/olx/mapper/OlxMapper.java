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
        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.newInstance()
                .scheme("https")
                .host("www.olx.pl");

        if (search.getCategoryId() != null) {
            uriComponentsBuilder.pathSegment(search.getCategoryId());
        } else {
            uriComponentsBuilder.pathSegment("oferty");
        }

        uriComponentsBuilder.pathSegment("q-" + search.getKeyword().replaceAll(" ", "-"));

        if (search.getPriceFrom() != null) {
            uriComponentsBuilder.queryParam("search[filter_float_price:from]", search.getPriceFrom());
        }

        if (search.getPriceTo() != null) {
            uriComponentsBuilder.queryParam("search[filter_float_price:to]", search.getPriceTo());
        }

        return uriComponentsBuilder
                .queryParam("search[order]", "created_at:desc")
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
