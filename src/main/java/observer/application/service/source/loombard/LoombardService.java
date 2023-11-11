package observer.application.service.source.loombard;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import observer.application.model.Category;
import observer.application.model.Item;
import observer.application.model.Search;
import observer.application.model.Source;
import observer.application.rest.RestInvoker;
import observer.application.service.source.SourceService;
import observer.application.service.source.loombard.mapper.LoombardMapper;
import observer.application.service.source.loombard.model.LoombardItem;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class LoombardService implements SourceService {

    private final RestInvoker restInvoker;
    private final LoombardMapper loombardMapper;

    @Override
    public Source getSource() {
        return Source.LOOMBARD;
    }

    @Override
    public Duration getDelay() {
        return Duration.ofSeconds(15);
    }

    @Override
    public List<Item> fetchItems(Search search) {
        String url = loombardMapper.toUrl(search);
        LoombardItem[] loombardItems = restInvoker.get(url, null, LoombardItem[].class);
        return loombardMapper.toItems(
                List.of(Optional.ofNullable(loombardItems).orElse(new LoombardItem[0])), search.getId());
    }

    @Override
    public List<Category> fetchCategories(String parentId) {
        return List.of();
    }
}
