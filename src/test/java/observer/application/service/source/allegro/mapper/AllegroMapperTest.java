package observer.application.service.source.allegro.mapper;

import observer.application.model.Search;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AllegroMapperTest {

    AllegroMapper allegroMapper = new AllegroMapper();

    @Test
    void shouldCreateUrl() {
        //given
        Search search = createSearch();

        //when
        String url = allegroMapper.toUrl(search);

        //then
        String regex = "https://allegro.pl/kategoria/categoryId\\?order=n&price_from.*";
        Assertions.assertTrue(url.matches(regex));
    }

    Search createSearch() {
        return Search.builder()
                .categoryId("categoryId")
                .categoryName("categoryName")
                .priceFrom(1)
                .priceTo(9999)
                .keyword("keyword")
                .build();
    }
}
