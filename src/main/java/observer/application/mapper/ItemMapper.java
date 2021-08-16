package observer.application.mapper;

import observer.application.dto.ItemDto;
import observer.application.model.Item;
import observer.application.model.Source;
import org.springframework.stereotype.Component;

import static observer.application.mapper.MapperUtils.toLocalTime;
import static observer.application.mapper.MapperUtils.trim;

@Component
public class ItemMapper implements BaseMapper<Item, ItemDto> {

    private static final int MAX_LENGTH = 40;

    @Override
    public ItemDto toDto(Item item) {
        return ItemDto.builder()
                .itemId(item.getId())
                .originId(item.getOriginId())
                .dateCreated(toLocalTime(item.getDateCreated()))
                .title(trim(item.getTitle(), MAX_LENGTH))
                .url(item.getUrl())
                .price(item.getPrice())
                .source(Source.getSource(item.getSourceId()).getLabel())
                .build();
    }

}
