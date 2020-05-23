package allegro.application.service;

import allegro.application.api.SearchDto;
import allegro.application.api.SearchViewDto;
import allegro.application.common.SearchAssembler;
import allegro.application.common.SearchViewAssembler;
import allegro.application.repository.SearchRepository;
import allegro.application.repository.SearchViewRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class SearchViewService {

    private SearchViewRepository searchViewRepository;
    private SearchRepository searchRepository;
    private SearchAssembler searchAssembler;
    private SearchViewAssembler searchViewAssembler;

    public List<SearchViewDto> fetchSearchViewList() {
        return searchViewAssembler.toDtoList(searchViewRepository.findAll());
    }

    public void deleteSearch(Long searchId) {
        searchRepository.deleteBySearchId(searchId);
    }

    public void addSearch(SearchDto searchDto) {
        Optional.ofNullable(searchDto).ifPresent(s -> searchRepository.save(searchAssembler.toSearch(s)));
    }
}
