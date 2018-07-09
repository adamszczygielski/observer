package allegro.app.common;

import allegro.app.api.ItemDto;
import allegro.app.entity.Item;
import allegro.app.wsdl.ArrayOfPriceinfotype;
import allegro.app.wsdl.ItemsListType;
import allegro.app.wsdl.PriceInfoType;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class Assembler implements BaseAssembler<ItemsListType, ItemDto> {

    @Override
    public ItemDto toDto(ItemsListType itemsListType) {
        ItemDto itemDto = new ItemDto();
        itemDto.setItemId(itemsListType.getItemId());
        itemDto.setCreationDate(null);
        itemDto.setTitle(itemsListType.getItemTitle());
        itemDto.setUrl(Utils.itemIdToUrl(itemsListType.getItemId()));
        itemDto.setPrice(Utils.priceToString(itemsListType.getPriceInfo()));

        return itemDto;
    }
}
