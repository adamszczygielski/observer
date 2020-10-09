package observer.application.service;

import lombok.SneakyThrows;
import observer.application.Application;
import observer.application.api.Source;
import observer.application.domain.Item;
import observer.application.domain.Search;
import observer.application.repository.SearchRepository;
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

import java.sql.Timestamp;
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

    private SearchService searchService;

    @Autowired
    private SearchRepository searchRepository;

    @Mock
    private AllegroService allegroService;

    @Mock
    private ItemServiceFactory itemServiceFactory;

    @Before
    public void init() {
        searchService = new SearchService(searchRepository, itemServiceFactory, 5, 2L, 10L);
    }

    @Test
    @SneakyThrows
    public void shouldUpdateSearch() {
        Mockito.when(itemServiceFactory.create(Source.ALLEGRO)).thenReturn(allegroService);
        Mockito.when(allegroService.getItems(any(Search.class))).thenReturn(getItems());
        searchService.execute();

        Assertions.assertEquals(2,
                searchRepository.findById(1L).orElseThrow(Exception::new).getItemList().size());
    }

    private List<Item> getItems() {
        Item item = Item.builder()
                .originId("2000")
                .searchId(1L)
                .dateCreated(new Timestamp(0))
                .title("Title test 2")
                .price("100.00 PLN")
                .url("https://test.pl/i2000.html")
                .isActive(true)
                .isNotified(false)
                .build();

        return Collections.singletonList(item);
    }

}
