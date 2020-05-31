package allegro.application.api.controller;

import allegro.application.api.SearchDto;
import allegro.application.service.SearchService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
@AllArgsConstructor
public class SearchController {

    private final SearchService searchService;

    @RequestMapping("/search/list")
    public String fetchSearchViewList(Model model) {
        model.addAttribute("searchViewDto", searchService.fetchSearchViewList());
        model.addAttribute("searchDto", new SearchDto());
        return "search";
    }

    @RequestMapping("/search/delete/{searchId}")
    public String deleteSearch(@PathVariable Long searchId, HttpServletRequest request) {
        searchService.deleteSearch(searchId);
        return goBack(request);
    }

    @RequestMapping(value = "/search/add", method = RequestMethod.POST)
    public String addSearch(@ModelAttribute("searchDto") SearchDto searchDto, BindingResult bindingResult, Model model, HttpServletRequest request) {
        searchService.addSearch(searchDto);
        return goBack(request);
    }

    private String goBack(HttpServletRequest request) {
        return "redirect:" + request.getHeader("Referer");
    }
}
