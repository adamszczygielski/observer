package observer.application.common;

import observer.application.api.SearchDto;
import observer.application.api.Source;
import observer.application.domain.Search;
import org.junit.jupiter.api.Test;

import java.sql.Timestamp;

public class SearchMapperTest {

    private final SearchMapper searchMapper = new SearchMapper();

    @Test
    public void toSearchTest() {
        // given
        SearchDto searchDto = createSearchDto();

        // when
        Search search = searchMapper.toSearch(searchDto);

        // then
//        Assertions.assertAll(
//                () -> Assertions.assertEquals(search.getId(), 1L),
//                () -> Assertions.assertEquals(search.getSourceId(), Source.ALLEGRO.getId()),
//                () -> Assertions.assertEquals(search.getParameterList().stream()
//                        .filter(p -> p.getTypeId().equals(ParameterType.PRICE_FROM.getId())).findFirst().get()
//                        .getValue(), "100"),
//                () -> Assertions.assertEquals(search.getParameterList().stream()
//                        .filter(p -> p.getTypeId().equals(ParameterType.PRICE_TO.getId())).findFirst().get()
//                        .getValue(), "500")
//        );
    }

    private SearchDto createSearchDto() {
        return SearchDto.builder()
                .searchId(1L)
                .keyword("keyword")
                //.category("category")
                .dateUpdated(new Timestamp(0))
                .interval(new Short("5"))
                .source(Source.ALLEGRO)
                .priceFrom(100)
                .priceTo(500)
                .build();
    }

}
