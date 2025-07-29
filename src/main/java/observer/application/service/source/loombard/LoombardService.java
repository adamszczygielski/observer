package observer.application.service.source.loombard;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import observer.application.dto.Source;
import observer.application.model.Item;
import observer.application.model.Search;
import observer.application.service.source.SourceService;
import observer.application.service.source.loombard.mapper.LoombardMapper;
import observer.application.service.source.loombard.model.LoombardItem;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.Duration;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class LoombardService implements SourceService {

    private final WebClient webClient;
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
        String url = search.getParams();

        ResponseEntity<LoombardItem[]> responseEntity = webClient.get()
                .uri(url)
                .retrieve()
                .toEntity(LoombardItem[].class)
                .block();

        LoombardItem[] loombardItems = Optional.ofNullable(responseEntity)
                .map(HttpEntity::getBody)
                .orElseThrow(() -> new IllegalStateException("No response body!"));

        return loombardMapper.toItems(
                List.of(Optional.ofNullable(loombardItems).orElse(new LoombardItem[0])), search);
    }
}
