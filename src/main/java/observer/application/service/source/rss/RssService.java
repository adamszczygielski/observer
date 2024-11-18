package observer.application.service.source.rss;

import lombok.RequiredArgsConstructor;
import observer.application.config.ApplicationConfig;
import observer.application.dto.Source;
import observer.application.model.Item;
import observer.application.model.Search;
import observer.application.rest.RestInvoker;
import observer.application.service.source.SourceService;
import observer.application.service.source.rss.mapper.RssMapper;
import observer.application.service.source.rss.model.Rss;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RssService implements SourceService {

    private final RestInvoker restInvoker;
    private final ApplicationConfig applicationConfig;
    private final RssMapper rssMapper = new RssMapper();

    @Override
    public Source getSource() {
        return Source.RSS;
    }

    @Override
    public Duration getDelay() {
        return applicationConfig.getRssDelay();
    }

    @Override
    public List<Item> fetchItems(Search search) {
        Rss rss = restInvoker.get(search.getParams(), null, Rss.class);
        return rssMapper.toItems(search.getId(), rss);
    }
}
