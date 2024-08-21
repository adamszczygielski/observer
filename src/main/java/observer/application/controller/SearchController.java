package observer.application.controller;

import lombok.RequiredArgsConstructor;
import observer.application.mapper.ItemMapper;
import observer.application.mapper.SearchMapper;
import observer.application.service.ItemService;
import observer.application.service.SearchService;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping(SearchController.API_PATH)
@RequiredArgsConstructor
public class SearchController {

    public static final String API_PATH = "/searches";

    private final SearchService searchService;
    private final ItemService itemService;
    private final SearchMapper searchMapper;
    private final ItemMapper itemMapper;

    @GetMapping
    public String getSearches(Model model) {
        model.addAttribute("searches", searchMapper.toDtos(searchService.getViewList()));
        return "searches";
    }

    @DeleteMapping
    public String deleteSearches(@RequestParam("id") List<Long> searchIds, HttpServletRequest request) {
        searchService.delete(searchIds);
        return "redirect:" + request.getHeader("Referer");
    }

    @GetMapping(value = "/{searchId}/items")
    public String getItems(@PathVariable Long searchId, Model model) {
        model.addAttribute("items", itemMapper.toDtoList(itemService.getItems(searchId)));
        return "items";
    }

    @GetMapping(value = "/{searchId}/fetched-items")
    public String fetchItems(@PathVariable Long searchId, Model model) {
        model.addAttribute("items", itemMapper.toDtoList(itemService.fetchItems(searchId)));
        return "fetched-items";
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
    }
}
