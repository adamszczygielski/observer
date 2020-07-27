package allegro.application.common;

import allegro.application.api.ItemDto;
import allegro.application.domain.Item;
import org.springframework.stereotype.Component;

import static allegro.application.common.Utils.trim;

@Component
public class ItemAssembler implements BaseAssembler<Item, ItemDto> {

    private static final int MAX_LENGTH = 40;

    @Override
    public ItemDto toDto(Item item) {
        return ItemDto.builder()
                .itemId(item.getId())
                .originId(item.getOriginId())
                .dateCreated(item.getDateCreated())
                .title(trim(item.getTitle(), MAX_LENGTH))
                .url(item.getUrl())
                .price(item.getPrice())
                .build();
    }
}
