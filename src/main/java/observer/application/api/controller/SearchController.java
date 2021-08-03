package observer.application.api.controller;

import lombok.RequiredArgsConstructor;
import observer.application.api.SearchDto;
import observer.application.mapper.SearchMapper;
import observer.application.mapper.SearchViewMapper;
import observer.application.service.SearchApiService;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping(SearchController.API_PATH)
@RequiredArgsConstructor
public class SearchController {

    public static final String API_PATH = "/searches";

    private final SearchApiService searchApiService;
    private final SearchMapper searchMapper;
    private final SearchViewMapper searchViewMapper;

    @GetMapping
    public String getSearchViewList(Model model) {
        model.addAttribute("searchViewDtoList", searchViewMapper.toDtoList(searchApiService.getSearchViewList()));
        return "searches";
    }

    @PostMapping
    public String addOrUpdateSearch(@ModelAttribute("searchDto") @Valid SearchDto searchDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "form";
        }
        searchApiService.addOrUpdateSearch(searchMapper.toSearch(searchDto));
        return "redirect:" + API_PATH;
    }

    @DeleteMapping
    public String deleteSearches(@RequestParam("id") List<Long> searchIds, HttpServletRequest request) {
        searchApiService.deleteSearches(searchIds);
        return goBack(request);
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
    }

    private String goBack(HttpServletRequest request) {
        return "redirect:" + request.getHeader("Referer");
    }

}
