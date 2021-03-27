package observer.application.service;

import lombok.RequiredArgsConstructor;
import observer.application.domain.Source;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;

@Service
@RequiredArgsConstructor
class SourceService {

    private final ItemService allegroService;
    private final ItemService olxService;
    private final ItemService ebayService;

    public ItemService get(Source source) {
        switch (source) {
            case ALLEGRO:
                return allegroService;
            case OLX:
                return olxService;
            case EBAY:
                return ebayService;
            default:
                throw new IllegalArgumentException(
                        MessageFormat.format("No service implementation for {0}", source.getLabel()));
        }
    }

}