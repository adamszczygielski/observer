package observer.application.service;

import lombok.RequiredArgsConstructor;
import observer.application.api.Source;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
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
                throw new IllegalArgumentException("No service implementation for: " + source.getLabel());
        }
    }
}