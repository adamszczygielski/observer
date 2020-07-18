package allegro.application.common;

import allegro.application.api.ItemDto;
import allegro.application.domain.Item;
import org.springframework.stereotype.Component;

@Component
public class ItemAssembler implements BaseAssembler<Item, ItemDto> {

    @Override
    public ItemDto toDto(Item item) {
        return ItemDto.builder()
                .itemId(item.getId())
                .originId(item.getOriginId())
                .dateCreated(item.getDateCreated())
                .title(item.getTitle())
                .url(item.getUrl())
                .price(item.getPrice())
                .build();
    }
}
