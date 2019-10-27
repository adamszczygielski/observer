package allegro.application.common;

import allegro.application.api.ItemDto;
import allegro.application.domain.Item;
import org.springframework.stereotype.Component;

@Component
public class ItemAssembler implements BaseAssembler<Item, ItemDto>  {

    @Override
    public ItemDto toDto(Item item) {
        ItemDto itemDto = new ItemDto();
        itemDto.setItemId(item.getItemId());
        itemDto.setOriginId(item.getOriginId());
        itemDto.setCreationDate(null);
        itemDto.setTitle(item.getTitle());
        itemDto.setUrl(item.getUrl());
        itemDto.setPrice(item.getPrice());
        return itemDto;
    }
}
