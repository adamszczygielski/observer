package observer.application.service;

import lombok.RequiredArgsConstructor;
import observer.application.domain.Search;
import observer.application.domain.SearchView;
import observer.application.repository.SearchRepository;
import observer.application.repository.SearchViewRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.MessageFormat;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SearchApiService {

    private final SearchViewRepository searchViewRepository;
    private final SearchRepository searchRepository;

    public List<SearchView> getSearchViewList() {
        return searchViewRepository.findAll();
    }

    @Transactional
    public void deleteSearches(List<Long> searchIds) {
        searchRepository.deleteByIds(searchIds);
    }

    @Transactional
    public void addSearch(Search search) {
        List<Search> searches = searchRepository.findAll();
        if (!searches.contains(search)) {
            searchRepository.save(search);
        }
    }

    public Search getSearch(Long searchId) {
        return searchRepository.findById(searchId).orElseThrow(() -> new IllegalArgumentException(
                MessageFormat.format("SearchId {0} does not exist", searchId)));
    }

}
