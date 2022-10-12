package observer.application.service;

import lombok.SneakyThrows;
import observer.application.Application;
import observer.application.model.Source;
import observer.application.model.Item;
import observer.application.model.Search;
import observer.application.repository.SearchRepository;
import observer.application.service.source.SourceServiceResolver;
import observer.application.service.source.allegro.AllegroService;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;

@RunWith(SpringRunner.class)
@WebAppConfiguration
@SpringBootTest(classes = {Application.class})
@ActiveProfiles("junit")
@Sql({
        "/scripts/insert_search.sql",
        "/scripts/insert_item.sql"
})
@Transactional
public class SearchServiceTest {

    private SearchExecutionService searchExecutionService;

    @Autowired
    private SearchRepository searchRepository;

    @Mock
    private AllegroService allegroService;

    @Mock
    private SourceServiceResolver sourceServiceResolver;

    @Before
    public void init() {
        //searchService = new SearchService(searchRepository, sourceService, 5, 2L, 10L);
    }

    @Test
    @SneakyThrows
    public void shouldUpdateSearch() {
        Mockito.when(sourceServiceResolver.get(Source.ALLEGRO.getId())).thenReturn(allegroService);
        Mockito.when(allegroService.fetchItems(any(Search.class))).thenReturn(getItems());

        Assertions.assertEquals(2,
                searchRepository.findById(1L).orElseThrow(Exception::new).getItems().size());
    }

    private List<Item> getItems() {
        Item item = Item.builder()
                .originId("2000")
                .searchId(1L)
                .dateCreated(null)
                .title("Title test 2")
                .price("100.00 PLN")
                .url("https://test.pl/i2000.html")
                .isActive(true)
                .isNotified(false)
                .build();

        return Collections.singletonList(item);
    }

}
