package observer.application.service.source.loombard;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import observer.application.model.Search;
import observer.application.service.source.loombard.mapper.LoombardMapper;
import observer.application.service.source.loombard.model.LoombardItem;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;

public class LoombardMapperTest {

    @Test
    void shouldMapToUrl() {
        //given
        LoombardMapper loombardMapper = new LoombardMapper();
        Search search = Search.builder()
                .keyword("monitor samsung")
                .categoryId("elektronika-uVmNGb")
                .priceFrom(10)
                .priceTo(500)
                .build();

        //when
        String url = loombardMapper.toUrl(search);

        //then
        Assertions.assertEquals("https://www.loombard.pl" +
                "/api/categories" +
                "/elektronika-uVmNGb" +
                "?searchQuery=monitor+samsung" +
                "&sort=-created_at" +
                "&price%5Bfrom%5D=10" +
                "&price%5Bto%5D=500", url);
    }

    @Test
    @SneakyThrows
    void shouldMapToLoombardItem() {
        //given
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        File file = new File("src/test/resources/loombard-items.json");

        //when
        LoombardItem[] loombardItems = objectMapper.readValue(file, LoombardItem[].class);

        //then
        Assertions.assertEquals(6, loombardItems.length);
    }
}
