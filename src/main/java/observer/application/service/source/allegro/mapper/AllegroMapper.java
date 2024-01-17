package observer.application.service.source.allegro.mapper;

import observer.application.model.Item;
import observer.application.dto.Source;
import observer.application.service.source.allegro.model.listing.Element;
import observer.application.service.source.allegro.model.listing.Price;
import org.springframework.web.util.UriComponentsBuilder;

import java.time.Instant;

public class AllegroMapper {

    public Item toItem(Element element, Long searchId) {
        return Item.builder()
                .originId(element.getId())
                .searchId(searchId)
                .createdDate(Instant.now())
                .title(element.getTitle().getText())
                .price(toPrice(element.getPrice()))
                .url(toUrl(element))
                .isDeleted(false)
                .isNotificationSent(false)
                .sourceId(Source.ALLEGRO.getId())
                .build();
    }

    private String toPrice(Price price) {
        return String.join(" ", price.getMain().getAmount(), price.getMain().getCurrency());
    }

    private String toUrl(Element element) {
        String url = element.getUrl();
        if (url.length() > 255) {
            return toUrl(element.getId());
        }
        return url;
    }

    private String toUrl(String elementId) {
        return UriComponentsBuilder.newInstance()
                .scheme("https")
                .host("allegro.pl")
                .path("i{id}.html")
                .buildAndExpand(elementId)
                .toUriString();
    }
}
