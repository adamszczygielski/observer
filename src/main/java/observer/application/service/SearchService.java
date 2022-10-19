package observer.application.service;

import lombok.RequiredArgsConstructor;
import observer.application.model.Search;
import observer.application.model.SearchView;
import observer.application.repository.SearchRepository;
import observer.application.repository.SearchViewRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.MessageFormat;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SearchService {

    private final SearchViewRepository searchViewRepository;
    private final SearchRepository searchRepository;

    public List<SearchView> getViewList() {
        return searchViewRepository.findAll();
    }

    public Search get(Long searchId) {
        return searchRepository.findById(searchId).orElseThrow(() -> new IllegalArgumentException(
                MessageFormat.format("SearchId {0} does not exist", searchId)));
    }

    @Transactional
    public void delete(List<Long> searchIds) {
        searchRepository.deleteByIds(searchIds);
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
        List<Search> searches = searchRepository.findAll();
        if (!searches.contains(search)) {
            searchRepository.save(search);
        }
    }

    private void update(Search search) {
        searchRepository.findById(search.getId()).ifPresent(s -> {
            s.setKeyword(search.getKeyword());
            s.setCategoryId(search.getCategoryId());
            s.setCategoryName(search.getCategoryName());
            s.setPriceFrom(search.getPriceFrom());
            s.setPriceTo(search.getPriceTo());
            s.setIntervalMinutes(search.getIntervalMinutes());
        });
    }

}
