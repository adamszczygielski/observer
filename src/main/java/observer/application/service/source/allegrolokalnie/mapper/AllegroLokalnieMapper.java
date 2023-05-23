package observer.application.service.source.allegrolokalnie.mapper;

import observer.application.model.Search;
import org.springframework.web.util.UriComponentsBuilder;

public class AllegroLokalnieMapper {

    public String toUrl(Search search) {
        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.newInstance()
                .scheme("https")
                .host("allegrolokalnie.pl")
                .pathSegment("oferty");

        if (search.getCategoryId() != null) {
            uriComponentsBuilder.path(search.getCategoryId());
        }

        uriComponentsBuilder.pathSegment("q")
                .path(search.getKeyword());

        if (search.getPriceFrom() != null) {
            uriComponentsBuilder.queryParam("price_from", search.getPriceFrom());
        }

        if (search.getPriceTo() != null) {
            uriComponentsBuilder.queryParam("price_to", search.getPriceTo());
        }

        return uriComponentsBuilder.queryParam("dont_suggest_phrase", "true")
                .build()
                .toUri()
                .toString();
    }
}
