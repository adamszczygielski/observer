package allegro.application.service;

import allegro.application.domain.Search;
import allegro.application.domain.SearchView;
import allegro.application.repository.SearchRepository;
import allegro.application.repository.SearchViewRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class SearchService {

    private final SearchViewRepository searchViewRepository;
    private final SearchRepository searchRepository;

    public List<SearchView> fetchSearchViewList() {
        return searchViewRepository.findAll();
    }

    public void deleteSearch(Long searchId) {
        searchRepository.deleteBySearchId(searchId);
    }

    public void addSearch(Search search) {
        Optional.ofNullable(search).ifPresent(s -> searchRepository.save(search));
    }
}
