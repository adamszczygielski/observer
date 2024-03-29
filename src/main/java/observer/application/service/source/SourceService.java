package observer.application.service.source;

import observer.application.model.Item;
import observer.application.model.Search;
import observer.application.dto.Source;

import java.time.Duration;
import java.util.List;

public interface SourceService {
    Source getSource();

    Duration getDelay();

    List<Item> fetchItems(Search search);
}
