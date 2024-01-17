package observer.application.service.source.ebay;

import observer.application.model.Item;
import observer.application.model.Search;
import observer.application.rest.MockRestInvoker;
import observer.application.service.source.SourceServiceTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class EbayServiceTest extends SourceServiceTest {

    private final MockRestInvoker mockRestInvoker = new MockRestInvoker();
    private final EbayService ebayService = new EbayService(mockConfig, mockRestInvoker);

    @Test
    void shouldReturnItems() {
        //given
        mockRestInvoker.setBody(createPageSource(ebayService.getSource(), "content.xml"));
        Search search = Search.builder()
                .build();

        //when
        List<Item> items = ebayService.fetchItems(search);

        //then
        Assertions.assertEquals(30, items.size());
    }
}
