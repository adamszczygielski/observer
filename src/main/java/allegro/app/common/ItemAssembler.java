package allegro.app.common;

import allegro.app.api.ItemDto;
import allegro.app.entity.Item;
import org.springframework.stereotype.Component;

@Component
public class ItemAssembler implements BaseAssembler<Item, ItemDto>  {

    @Override
    public ItemDto toDto(Item item) {
        ItemDto itemDto = new ItemDto();
        itemDto.setItemId(item.getItemId());
        itemDto.setCreationDate(null);
        itemDto.setTitle(item.getTitle());
        itemDto.setUrl(Utils.itemIdToUrl(item.getItemId()));
        itemDto.setPrice(item.getPrice());

        return itemDto;
    }
}
