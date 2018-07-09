package allegro.app.service;

import allegro.app.common.SearchAssembler;
import allegro.app.controller.SearchDto;
import allegro.app.entity.Search;
import allegro.app.entity.SearchView;
import allegro.app.repository.ItemRepository;
import allegro.app.repository.SearchRepository;
import allegro.app.repository.SearchViewRepository;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@ComponentScan(basePackageClasses = SearchViewRepository.class)
@ComponentScan(basePackageClasses = SearchRepository.class)
@ComponentScan(basePackageClasses = SearchAssembler.class)
public class SearchViewService {

    private SearchViewRepository searchViewRepository;
    private SearchRepository searchRepository;
    private ItemRepository itemRepository;
    private SearchAssembler searchAssembler;

    public SearchViewService(SearchViewRepository searchViewRepository, SearchRepository searchRepository, ItemRepository itemRepository, SearchAssembler searchAssembler) {
        this.searchViewRepository = searchViewRepository;
        this.searchRepository = searchRepository;
        this.itemRepository = itemRepository;
        this.searchAssembler = searchAssembler;
    }

    public List<SearchView> fetchSearchViewList() {
        return searchViewRepository.findSearch();
    }

    public void switchIsActive(Long id) {
        searchRepository.switchIsActive(id);
    }

    public void deleteSearch(Long id) {
        itemRepository.deleteBySearchId(id);
        searchRepository.deleteById(id);
    }

    public void addSearch(SearchDto searchDto) {
        Search search = searchAssembler.toSearch(searchDto);
        searchRepository.save(search);
    }
}
