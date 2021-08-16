package observer.application.service.source.allegro.mapper;

import observer.application.model.Category;
import observer.application.model.Item;
import observer.application.model.Source;
import observer.application.service.source.allegro.model.category.CategoryDto;
import observer.application.service.source.allegro.model.listing.Element;
import observer.application.service.source.allegro.model.listing.Normal;
import observer.application.service.source.allegro.model.listing.Price;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class AllegroMapper {

    public List<Category> toCategories(List<CategoryDto> dtoList) {
        return dtoList.stream().map(categoryDto -> Category.builder()
                .id(categoryDto.getId())
                .name(categoryDto.getName())
                .leaf(categoryDto.getLeaf())
                .build()).collect(Collectors.toList());
    }

    public List<Item> toItems(List<Element> elements, Long searchId) {
        return elements.stream().map(element -> Item.builder()
                .originId(element.getId())
                .searchId(searchId)
                .dateCreated(Instant.now())
                .title(element.getTitle().getText())
                .price(toPrice(element.getPrice()))
                .url(toUrl(element))
                .isActive(true)
                .isNotified(false)
                .sourceId(Source.ALLEGRO.getId())
                .build()).collect(Collectors.toList());
    }

    private String toPrice(Price price) {
        Normal normal = price.getNormal();
        return String.join(" ", normal.getAmount(), normal.getCurrency());
    }

    private String toUrl(Element element) {
        String url = element.getUrl();
        if (url.length() > 255) {
            return UriComponentsBuilder.newInstance()
                    .scheme("https")
                    .host("allegro.pl")
                    .path("i{id}.html")
                    .buildAndExpand(element.getId())
                    .toUriString();
        }
        return url;
    }

}
