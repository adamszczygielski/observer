package observer.application.mapper;

import observer.application.dto.ItemDto;
import observer.application.model.Item;
import observer.application.model.Source;

public class ItemMapper implements BaseMapper<Item, ItemDto> {

    @Override
    public ItemDto toDto(Item item) {
        return ItemDto.builder()
                .itemId(item.getId())
                .originId(item.getOriginId())
                .dateCreated(item.getDateCreated())
                .title(item.getTitle())
                .url(item.getUrl())
                .price(item.getPrice())
                .source(Source.getSource(item.getSourceId()).getLabel())
                .build();
    }

}
