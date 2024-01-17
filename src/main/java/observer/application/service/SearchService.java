package observer.application.service;

import lombok.RequiredArgsConstructor;
import observer.application.model.Search;
import observer.application.model.SearchView;
import observer.application.repository.SearchRepository;
import observer.application.repository.SearchViewRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.MessageFormat;
import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SearchService {

    private static final PageRequest PAGE_REQUEST = PageRequest.of(0, 1);

    private final SearchViewRepository searchViewRepository;
    private final SearchRepository searchRepository;

    public List<SearchView> getViewList() {
        return searchViewRepository.findAll();
    }

    public Search getOrThrow(long searchId) {
        return searchRepository.findById(searchId).orElseThrow(() -> new IllegalArgumentException(
                MessageFormat.format("SearchId {0} does not exist", searchId)));
    }

    public Optional<Search> getOverdue(int sourceId) {
        return searchRepository.findOverdue(sourceId, Instant.now(), PAGE_REQUEST)
                .stream()
                .findFirst();
    }

    @Transactional
    public void delete(List<Long> searchIds) {
        searchRepository.deleteByIdIn(searchIds);
    }

    @Transactional
    public void createOrUpdate(Search search) {
        if (search.getId() != null) {
            update(search);
        } else {
            create(search);
        }
    }

    private void create(Search search) {
        List<Search> searches = searchRepository.findBySourceId(search.getSourceId());
        if (!searches.contains(search)) {
            searchRepository.save(search);
        }
    }

    private void update(Search search) {
        searchRepository.findById(search.getId()).ifPresent(s -> {
            s.setDescription(search.getDescription());
            s.setParams(search.getParams());
            s.setIntervalMinutes(search.getIntervalMinutes());
        });
    }
}
