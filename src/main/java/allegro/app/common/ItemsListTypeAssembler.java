package allegro.app.common;

import allegro.app.entity.Item;
import allegro.app.wsdl.ArrayOfPriceinfotype;
import allegro.app.wsdl.ItemsListType;
import allegro.app.wsdl.PriceInfoType;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;

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
