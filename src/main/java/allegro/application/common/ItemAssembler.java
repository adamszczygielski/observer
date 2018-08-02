package allegro.application.common;

import allegro.application.api.ItemDto;
import allegro.application.entity.Item;
import allegro.application.wsdl.ArrayOfPriceinfotype;
import allegro.application.wsdl.PriceInfoType;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class ItemAssembler implements BaseAssembler<Item, ItemDto>  {

    @Override
    public ItemDto toDto(Item item) {

        ObjectMapper mapper = new ObjectMapper();
        ItemDto itemDto = new ItemDto();

        itemDto.setItemId(item.getItemId());
        itemDto.setCreationDate(null);
        itemDto.setTitle(item.getTitle());
        itemDto.setUrl(Utils.itemIdToUrl(item.getItemId()));
        itemDto.setPrice(item.getPrice());

        List<PriceInfoType> priceInfoType = new ArrayList<>();

        try {
            priceInfoType = Arrays.asList(mapper.readValue(item.getPrice(), PriceInfoType[].class));
        } catch (IOException e) {
            e.printStackTrace();
        }

        itemDto.setPrice(Utils.priceInfoTypeToString(priceInfoType));

        return itemDto;
    }
}
