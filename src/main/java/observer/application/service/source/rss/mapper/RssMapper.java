package observer.application.service.source.rss.mapper;

import observer.application.dto.Source;
import observer.application.model.Item;
import observer.application.model.Search;
import observer.application.service.source.rss.model.Rss;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;


public class RssMapper {

    public List<Item> toItems(Search search, Rss rss) {
        return rss.getChannel().getItem().stream()
                .map(i -> Item.builder()
                        .originId(String.valueOf(i.getLink().hashCode()))
                        .search(search)
                        .createdDate(Instant.now())
                        .title(i.getTitle())
                        .price(toPrice(i.getDescription()))
                        .url(i.getLink())
                        .isDeleted(false)
                        .isNotificationSent(false)
                        .sourceId(Source.RSS.getId())
                        .build()).collect(Collectors.toList());
    }

    private String toPrice(String description) {
        return description.replace("Cena: ", "");
    }
}
