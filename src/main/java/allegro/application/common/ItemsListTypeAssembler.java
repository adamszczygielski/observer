package allegro.application.common;

import allegro.application.entity.Item;
import allegro.application.wsdl.ItemsListType;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Component
public class ItemsListTypeAssembler implements BaseAssembler<ItemsListType, Item> {

    @Override
    public Item toDto(ItemsListType itemsListType) {

        ObjectMapper mapper = new ObjectMapper();

        Item item = new Item();
        item.setItemId(itemsListType.getItemId());

        try {
            item.setPrice(mapper.writeValueAsString(itemsListType.getPriceInfo().getItem()));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        item.setCreationDate(new Timestamp(System.currentTimeMillis()));
        item.setTitle(itemsListType.getItemTitle());
        item.setUrl(Utils.itemIdToUrl(itemsListType.getItemId()));
        item.setIsActive(true);

        return item;
    }
}
