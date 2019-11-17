package allegro.application.service;

import allegro.application.domain.Search;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
class ItemServiceFactory {

    private ItemService allegroService;
    private ItemService olxSerivce;
    private ItemService ebayService;

    protected ItemService createItemService(Search search) {
        if (search.getSource().equals("allegro")) {
            return allegroService;
        } else if (search.getSource().equals("olx")) {
            return olxSerivce;
        } else if (search.getSource().equals("ebay")) {
            return ebayService;
        }
        throw new IllegalArgumentException("No service implementation for: " + search.getSource());
    }
}