package allegro.app.service;

import allegro.app.common.SearchAssembler;
import allegro.app.controller.SearchDto;
import allegro.app.entity.Search;
import allegro.app.entity.SearchView;
import allegro.app.repository.SearchRepository;
import allegro.app.repository.SearchViewRepository;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

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
        searchRepository.switchIsActive(id);
    }

    public void deleteSearch(Long id) {
        Optional.ofNullable(searchRepository.findBySearchId(id)).ifPresent(searchRepository::delete);
    }

    public void addSearch(SearchDto searchDto) {
        Search search = searchAssembler.toSearch(searchDto);
        searchRepository.save(search);
    }
}
