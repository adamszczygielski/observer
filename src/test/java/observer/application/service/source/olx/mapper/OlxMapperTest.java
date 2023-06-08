package observer.application.service.source.olx.mapper;

import observer.application.model.Search;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class OlxMapperTest {

    OlxMapper olxMapper = new OlxMapper();

    @Test
    void shouldMapToMinAttributesUrl() {
        //given
        Search search = Search.builder()
                .keyword("keyword")
                .build();

        //when
        String url = olxMapper.toUrl(search);

        //then
        Assertions.assertEquals("https://www.olx.pl" +
                "/oferty" +
                "/q-keyword" +
                "?search[order]=created_at:desc", url);
    }

    @Test
    void shouldMapToAllAttributesUrl() {
        //given
        Search search = Search.builder()
                .keyword("keyword")
                .categoryId("category-id")
                .priceFrom(1)
                .priceTo(9999)
                .build();

        //when
        String url = olxMapper.toUrl(search);

        //then
        Assertions.assertEquals("https://www.olx.pl" +
                "/category-id" +
                "/q-keyword" +
                "?search[filter_float_price:from]=1" +
                "&search[filter_float_price:to]=9999" +
                "&search[order]=created_at:desc", url);
    }
}
