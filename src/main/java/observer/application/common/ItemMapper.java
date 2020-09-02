package observer.application.common;

import observer.application.api.ItemDto;
import observer.application.domain.Item;
import org.springframework.stereotype.Component;

import static observer.application.common.Utils.trim;

@Component
public class ItemMapper implements BaseMapper<Item, ItemDto> {

    private static final int MAX_LENGTH = 40;

    @Override
    public ItemDto toDto(Item item) {
        return ItemDto.builder()
                .itemId(item.getId())
                .originId(item.getOriginId())
                .dateCreated(Utils.toString(item.getDateCreated()))
                .title(trim(item.getTitle(), MAX_LENGTH))
                .url(item.getUrl())
                .price(item.getPrice())
                .build();
    }
}
