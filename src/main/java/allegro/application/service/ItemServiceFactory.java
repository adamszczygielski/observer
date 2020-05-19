package allegro.application.service;

import allegro.application.domain.Search;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
class ItemServiceFactory {

    private ItemService allegroService;
    private ItemService olxService;
    private ItemService ebayService;

    protected ItemService createItemService(Search search) {

        switch (search.getSource()) {
            case "allegro":
                return allegroService;
            case "olx":
                return olxService;
            case "ebay":
                return ebayService;
            default:
                throw new IllegalArgumentException("No service implementation for: " + search.getSource());
        }
    }
}