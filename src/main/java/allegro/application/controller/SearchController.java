package allegro.application.controller;

import allegro.application.api.SearchDto;
import allegro.application.service.SearchViewService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
@AllArgsConstructor
public class SearchController {

    private SearchViewService searchViewService;

    @RequestMapping("/search/list")
    public String listSearchItems(Model model) {
        model.addAttribute("searchViewDto", searchViewService.fetchSearchViewList());
        model.addAttribute("searchDto", new SearchDto());
        return "search";
    }

    @RequestMapping("/search/delete/{searchId}")
    public String deleteSearch(@PathVariable Long searchId, HttpServletRequest request) {
        searchViewService.deleteSearch(searchId);
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
