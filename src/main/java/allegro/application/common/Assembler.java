package allegro.application.common;

import allegro.application.api.ItemDto;
import allegro.application.wsdl.ItemsListType;
import org.springframework.stereotype.Component;

@Component
public class Assembler implements BaseAssembler<ItemsListType, ItemDto> {

    @Override
    public ItemDto toDto(ItemsListType itemsListType) {
        ItemDto itemDto = new ItemDto();
        itemDto.setItemId(itemsListType.getItemId());
        itemDto.setCreationDate(null);
        itemDto.setTitle(itemsListType.getItemTitle());
        itemDto.setUrl(Utils.itemIdToUrl(itemsListType.getItemId()));
        itemDto.setPrice(Utils.priceInfoTypeToString(itemsListType.getPriceInfo().getItem()));

        return itemDto;
    }
}
