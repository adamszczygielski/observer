package observer.application.service.source.allegro.mapper;

import observer.application.model.Category;
import observer.application.model.Item;
import observer.application.model.Source;
import observer.application.service.source.allegro.model.category.CategoryDto;
import observer.application.service.source.allegro.model.listing.Element;
import observer.application.service.source.allegro.model.listing.Normal;
import observer.application.service.source.allegro.model.listing.Price;
import org.springframework.web.util.UriComponentsBuilder;

import java.time.Instant;

public class AllegroMapper {

    public Category toCategory(CategoryDto categoryDto) {
        return Category.builder()
                .id(categoryDto.getId())
                .name(categoryDto.getName())
                .leaf(categoryDto.getLeaf())
                .build();
    }

    public Item toItem(Element element, Long searchId) {
        return Item.builder()
                .originId(element.getId())
                .searchId(searchId)
                .dateCreated(Instant.now())
                .title(element.getTitle().getText())
                .price(toPrice(element.getPrice()))
                .url(toUrl(element))
                .isActive(true)
                .isNotified(false)
                .sourceId(Source.ALLEGRO.getId())
                .build();
    }

    private String toPrice(Price price) {
        Normal normal = price.getNormal();
        return String.join(" ", normal.getAmount(), normal.getCurrency());
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
