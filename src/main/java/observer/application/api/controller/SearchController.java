package observer.application.api.controller;

import lombok.AllArgsConstructor;
import observer.application.api.SearchDto;
import observer.application.common.SearchMapper;
import observer.application.common.SearchViewMapper;
import observer.application.service.SearchService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping(SearchController.API_PATH)
@AllArgsConstructor
public class SearchController {

    public static final String API_PATH = "/searches";

    private final SearchService searchService;
    private final SearchMapper searchMapper;
    private final SearchViewMapper searchViewMapper;

    @GetMapping
    public String fetchSearchViewList(Model model) {
        model.addAttribute("searchViewDto", searchViewMapper.toDtoList(searchService.fetchSearchViewList()));
        return "searches";
    }

    @PostMapping
    public String addSearch(@ModelAttribute("searchDto") @Valid SearchDto searchDto, BindingResult bindingResult, HttpServletRequest request) {
        if (bindingResult.hasErrors()) {
            return "form";
        }
        searchService.addSearch(searchMapper.toSearch(searchDto));
        return goBack(request);
    }

    @DeleteMapping
    public String deleteSearches(@RequestParam("id") List<Long> searchIds, HttpServletRequest request) {
        searchService.deleteSearches(searchIds);
        return goBack(request);
    }

    private String goBack(HttpServletRequest request) {
        return "redirect:" + request.getHeader("Referer");
    }
}
