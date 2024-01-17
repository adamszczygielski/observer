package observer.application.controller;

import lombok.RequiredArgsConstructor;
import observer.application.mapper.SearchMapper;
import observer.application.service.SearchService;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping(SearchController.API_PATH)
@RequiredArgsConstructor
public class SearchController {

    public static final String API_PATH = "/searches";

    private final SearchService searchService;
    private final SearchMapper searchMapper = new SearchMapper();

    @GetMapping
    public String getSearchDtos(Model model) {
        model.addAttribute("searchDtos", searchMapper.toDtos(searchService.getViewList()));
        return "searches";
    }

    @DeleteMapping
    public String deleteSearches(@RequestParam("id") List<Long> searchIds, HttpServletRequest request) {
        searchService.delete(searchIds);
        return "redirect:" + request.getHeader("Referer");
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
    }
}
