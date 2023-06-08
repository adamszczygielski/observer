package observer.application.service.source.olx;

import observer.application.model.Item;
import observer.application.model.Search;
import observer.application.rest.JsonMapperImpl;
import observer.application.rest.MockRestInvoker;
import observer.application.service.source.SourceServiceTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class OlxServiceTest extends SourceServiceTest {

    private final MockRestInvoker mockRestInvoker = new MockRestInvoker();
    private final OlxService olxService = new OlxService(mockConfig, new JsonMapperImpl(), mockRestInvoker,
            null);

    @Test
    void shouldReturnItems() {
        //given
        mockRestInvoker.setBody(createPageSource(olxService.getSource(), "content.html"));
        Search search = Search.builder()
                .keyword("ev3")
                .priceFrom(1)
                .priceTo(9999)
                .build();

        //when
        List<Item> items = olxService.fetchItems(search);

        //then
        Assertions.assertEquals(39, items.size());
    }
}
