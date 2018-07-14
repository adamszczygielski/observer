package allegro.app.service;

import allegro.app.common.SearchAssembler;
import allegro.app.api.SearchDto;
import allegro.app.entity.Search;
import allegro.app.entity.SearchView;
import allegro.app.repository.SearchRepository;
import allegro.app.repository.SearchViewRepository;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
@ComponentScan(basePackageClasses = SearchViewRepository.class)
@ComponentScan(basePackageClasses = SearchRepository.class)
@ComponentScan(basePackageClasses = SearchAssembler.class)
public class SearchViewService {

    private SearchViewRepository searchViewRepository;
    private SearchRepository searchRepository;
    private SearchAssembler searchAssembler;

    public SearchViewService(SearchViewRepository searchViewRepository, SearchRepository searchRepository, SearchAssembler searchAssembler) {
        this.searchViewRepository = searchViewRepository;
        this.searchRepository = searchRepository;
        this.searchAssembler = searchAssembler;
    }

    public List<SearchView> fetchSearchViewList() {
        return searchViewRepository.findAll();
    }

    public void switchIsActive(Long id) {
        Optional<Search> search = searchRepository.findById(id);
        if(search.isPresent()) {
            Search newSearch = search.get();
            newSearch.setIsActive(!newSearch.getIsActive());
            searchRepository.save(newSearch);
        }
    }

    public void deleteSearch(Long id) {
        searchRepository.findById(id).ifPresent(s -> searchRepository.delete(s));
    }

    public void addSearch(SearchDto searchDto) {
        Optional.ofNullable(searchDto).ifPresent(s -> searchRepository.save(searchAssembler.toSearch(s)));
    }
}
