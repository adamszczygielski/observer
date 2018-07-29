package allegro.application.common;

import allegro.application.entity.Item;
import allegro.application.wsdl.ItemsListType;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Component
public class ItemsListTypeAssembler implements BaseAssembler<ItemsListType, Item> {

    @Override
    public Item toDto(ItemsListType itemsListType) {
        Item item = new Item();
        item.setItemId(itemsListType.getItemId());
        item.setPrice(Utils.priceToString(itemsListType.getPriceInfo()));
        item.setCreationDate(new Timestamp(System.currentTimeMillis()));
        item.setTitle(itemsListType.getItemTitle());
        item.setUrl(Utils.itemIdToUrl(itemsListType.getItemId()));
        item.setIsActive(true);

        return item;
    }
}
