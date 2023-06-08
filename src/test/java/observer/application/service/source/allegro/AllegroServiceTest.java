package observer.application.service.source.allegro;

import observer.application.model.Item;
import observer.application.model.Search;
import observer.application.rest.JsonMapperImpl;
import observer.application.service.source.SourceServiceTest;
import observer.application.webdriver.MockDriverFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class AllegroServiceTest extends SourceServiceTest {

    private final MockDriverFactory mockDriverFactory = new MockDriverFactory();
    private final AllegroService allegroService = new AllegroService(mockConfig, new JsonMapperImpl(),
            null, mockDriverFactory);

    @Test
    void shouldReturnItems() {
        //given
        mockDriverFactory.setPageSource(createPageSource(allegroService.getSource(), "content.html"));
        Search search = Search.builder()
                .keyword("ev3")
                .build();

        //when
        List<Item> items = allegroService.fetchItems(search);

        //then
        Assertions.assertEquals(13, items.size());
    }
}
