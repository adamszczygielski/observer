package observer.application.service.source.rss;

import lombok.RequiredArgsConstructor;
import observer.application.config.ApplicationConfig;
import observer.application.dto.Source;
import observer.application.model.Item;
import observer.application.model.Search;
import observer.application.service.source.SourceService;
import observer.application.service.source.rss.mapper.RssMapper;
import observer.application.service.source.rss.model.Rss;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.Duration;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RssService implements SourceService {

    private final WebClient webClient;
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
        String url = search.getParams();

        ResponseEntity<Rss> responseEntity = webClient.get()
                .uri(url)
                .retrieve()
                .toEntity(Rss.class)
                .block();

        Rss rss = Optional.ofNullable(responseEntity)
                .map(HttpEntity::getBody)
                .orElseThrow(() -> new IllegalStateException("No response body!"));

        return rssMapper.toItems(search, rss);
    }
}
