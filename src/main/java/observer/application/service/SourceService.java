package observer.application.service;

import lombok.RequiredArgsConstructor;
import observer.application.model.Source;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class SourceService {

    private final ItemService allegroService;
    private final ItemService olxService;
    private final ItemService ebayService;

    ItemService get(Integer sourceId) {
        switch (Source.getSource(sourceId)) {
            case ALLEGRO:
                return allegroService;
            case OLX:
                return olxService;
            case EBAY:
                return ebayService;
            default:
                throw new IllegalArgumentException("No service implementation found!");
        }
    }

}