package observer.application.service.source.loombard;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import observer.application.service.source.loombard.model.LoombardItem;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;

public class LoombardMapperTest {

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
