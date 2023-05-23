package observer.application.service.source.allegrolokalnie;

import observer.application.model.Item;
import observer.application.model.Search;
import observer.application.service.source.MockDocumentService;
import observer.application.service.source.SourceServiceTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class AllegroLokalnieServiceTest extends SourceServiceTest {

    private final String CONTENT_DIRECTORY = "F:/observer/allegrolokalnie/";
    private final MockDocumentService mockDocumentService = new MockDocumentService();
    private final AllegroLokalnieService allegroLokalnieService = new AllegroLokalnieService(mockConfig,
            mockDocumentService);

    @Test
    void shouldReturnItems() {
        //given
        mockDocumentService.setPageSource(createPageSource(CONTENT_DIRECTORY + "content.html"));
        Search search = Search.builder().build();

        //when
        List<Item> items = allegroLokalnieService.fetchItems(search);

        //then
        Assertions.assertEquals(29, items.size());
    }
}
