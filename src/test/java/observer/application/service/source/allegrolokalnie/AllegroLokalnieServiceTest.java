package observer.application.service.source.allegrolokalnie;

import observer.application.model.Item;
import observer.application.model.Search;
import observer.application.model.Source;
import observer.application.service.source.MockDocumentService;
import observer.application.service.source.SourceServiceTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class AllegroLokalnieServiceTest extends SourceServiceTest {

    private final MockDocumentService mockDocumentService = new MockDocumentService();
    private final AllegroLokalnieService allegroLokalnieService = new AllegroLokalnieService(mockConfig,
            mockDocumentService);

    @Test
    void shouldReturnItems() {
        //given
        mockDocumentService.setPageSource(createPageSource(allegroLokalnieService.getSource(), "content.html"));
        Search search = Search.builder()
                .id(1L)
                .sourceId(Source.ALLEGRO_LOKALNIE.getId())
                .keyword("ev3")
                .build();

        //when
        List<Item> items = allegroLokalnieService.fetchItems(search);

        //then
        Assertions.assertEquals(29, items.size());
        items.forEach(item -> {
            Assertions.assertNotNull(item.getOriginId());
            Assertions.assertEquals(Source.ALLEGRO_LOKALNIE.getId(), (int) item.getSourceId());
            Assertions.assertNotNull(item.getTitle());
            Assertions.assertNotNull(item.getPrice());
            Assertions.assertFalse(item.getIsDeleted());
        });
    }
}
