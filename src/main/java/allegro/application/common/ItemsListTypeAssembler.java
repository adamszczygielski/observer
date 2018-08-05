package allegro.application.common;

import allegro.application.entity.Item;
import allegro.application.wsdl.ItemsListType;
import allegro.application.wsdl.PriceInfoType;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

import static allegro.application.common.PriceType.WITHDELIVERY;

@Component
public class ItemsListTypeAssembler implements BaseAssembler<ItemsListType, Item> {

    @Override
    public Item toDto(ItemsListType itemsListType) {

        ObjectMapper mapper = new ObjectMapper();

        Item item = new Item();
        item.setItemId(itemsListType.getItemId());

        try {
            item.setPrice(mapper.writeValueAsString(
                    filterPriceInfoType(
                            itemsListType.getPriceInfo().getItem())));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        item.setCreationDate(new Timestamp(System.currentTimeMillis()));
        item.setTitle(itemsListType.getItemTitle());
        item.setIsActive(true);

        return item;
    }

    private List<PriceInfoType> filterPriceInfoType(List<PriceInfoType> priceInfoTypeList) {
        return priceInfoTypeList.stream().filter(p -> ! p.getPriceType().toUpperCase().contains(WITHDELIVERY.toString())).collect(Collectors.toList());
    }
}
