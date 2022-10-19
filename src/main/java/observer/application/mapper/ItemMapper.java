package observer.application.mapper;

import observer.application.dto.ItemDto;
import observer.application.model.Item;
import observer.application.model.Source;

public class ItemMapper implements BaseMapper<Item, ItemDto> {

    @Override
    public ItemDto toDto(Item item) {
        return ItemDto.builder()
                .id(item.getId())
                .originId(item.getOriginId())
                .createdDate(item.getCreatedDate())
                .title(item.getTitle())
                .url(item.getUrl())
                .price(item.getPrice())
                .source(Source.getLabel(item.getSourceId()))
                .build();
    }

}
