package allegro.app.controller;

import allegro.app.service.SearchViewService;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
@ComponentScan(basePackageClasses = SearchViewService.class)
@ComponentScan(basePackageClasses = SearchDto.class)
public class SearchController {

    private SearchViewService searchViewService;

    public SearchController(SearchViewService searchViewService) {
        this.searchViewService = searchViewService;
    }

    @RequestMapping("/search/list")
    public String listSearchItems(Model model) {
        model.addAttribute("search", searchViewService.fetchSearchViewList());
        model.addAttribute("searchDto", new SearchDto());
        return "search";
    }

    @RequestMapping("/search/switch/{id}")
    public String switchIsActive(@PathVariable Long id, HttpServletRequest request) {
        searchViewService.switchIsActive(id);
        return goBack(request);
    }

    @RequestMapping("/search/delete/{id}")
    public String deleteSearch(@PathVariable Long id, HttpServletRequest request) {
        searchViewService.deleteSearch(id);
        return goBack(request);
    }

    @RequestMapping(value = "/search/add", method = RequestMethod.POST)
    public String addSearch(@ModelAttribute("searchDto") SearchDto searchDto, BindingResult bindingResult, Model model, HttpServletRequest request) {
        searchViewService.addSearch(searchDto);
        return goBack(request);
    }

    private String goBack(HttpServletRequest request) {
        return "redirect:" + request.getHeader("Referer");
    }
}
