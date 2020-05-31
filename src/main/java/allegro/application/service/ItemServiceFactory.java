package allegro.application.service;

import allegro.application.api.Source;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
class ItemServiceFactory {

    private ItemService allegroService;
    private ItemService olxService;
    private ItemService ebayService;

    protected ItemService createItemService(Source source) {

        switch (source) {
            case ALLEGRO:
                return allegroService;
            case OLX:
                return olxService;
            case EBAY:
                return ebayService;
            default:
                throw new IllegalArgumentException("No service implementation for : " + source.getLabel());
        }
    }
}