package allegro.application.api.controller;

import allegro.application.api.SearchDto;
import allegro.application.common.SearchAssembler;
import allegro.application.common.SearchViewAssembler;
import allegro.application.service.SearchService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(SearchController.API_PATH)
@AllArgsConstructor
public class SearchController {

    public static final String API_PATH = "/searches";

    private final SearchService searchService;
    private final SearchAssembler searchAssembler;
    private final SearchViewAssembler searchViewAssembler;

    @RequestMapping(method = RequestMethod.GET)
    public String fetchSearchViewList(Model model) {
        model.addAttribute("searchViewDto", searchViewAssembler.toDtoList(searchService.fetchSearchViewList()));
        model.addAttribute("searchDto", new SearchDto());
        return "searches";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String addSearch(@ModelAttribute("searchDto") SearchDto searchDto, BindingResult bindingResult, Model model,
                            HttpServletRequest request) {
        searchService.addSearch(searchAssembler.toSearch(searchDto));
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
