package observer.application.mapper;

import observer.application.api.ItemDto;
import observer.application.domain.Source;
import observer.application.domain.Item;
import org.springframework.stereotype.Component;

import static observer.application.mapper.MapperUtils.*;

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
