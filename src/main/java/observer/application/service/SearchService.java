package observer.application.service;

import lombok.AllArgsConstructor;
import observer.application.domain.Search;
import observer.application.domain.SearchView;
import observer.application.repository.SearchRepository;
import observer.application.repository.SearchViewRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SearchService {

    private final SearchViewRepository searchViewRepository;
    private final SearchRepository searchRepository;

    public List<SearchView> fetchSearchViewList() {
        return searchViewRepository.findAll();
    }

    public void deleteSearch(Long searchId) {
        searchRepository.deleteById(searchId);
    }

    public void addSearch(Search search) {
        searchRepository.save(search);
    }
}
