package observer.application.service;

import observer.application.api.Source;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
class ItemServiceFactory implements AbstractFactory<ItemService> {

    private final ItemService allegroService;
    private final ItemService olxService;
    private final ItemService ebayService;

    @Override
    public ItemService create(Source source) {

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