package observer.application.api.controller;

import observer.application.api.SearchDto;
import observer.application.common.SearchMapper;
import observer.application.common.SearchViewMapper;
import observer.application.service.SearchService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
@RequestMapping(SearchController.API_PATH)
@AllArgsConstructor
@Validated
public class SearchController {

    public static final String API_PATH = "/searches";

    private final SearchService searchService;
    private final SearchMapper searchMapper;
    private final SearchViewMapper searchViewMapper;

    @RequestMapping(method = RequestMethod.GET)
    public String fetchSearchViewList(Model model) {
        model.addAttribute("searchViewDto", searchViewMapper.toDtoList(searchService.fetchSearchViewList()));
        model.addAttribute("searchDto", new SearchDto());
        return "searches";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String addSearch(@ModelAttribute("searchDto") @Valid SearchDto searchDto, BindingResult bindingResult, Model model,
                            HttpServletRequest request) {
        searchService.addSearch(searchMapper.toSearch(searchDto));
        return goBack(request);
    }

    @RequestMapping(value = "/{searchId}", method = RequestMethod.DELETE)
    public String deleteSearch(@PathVariable Long searchId, HttpServletRequest request) {
        searchService.deleteSearch(searchId);
        return goBack(request);
    }

    private String goBack(HttpServletRequest request) {
        return "redirect:" + request.getHeader("Referer");
    }
}
