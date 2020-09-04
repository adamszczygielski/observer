package observer.application.api.controller;

import lombok.AllArgsConstructor;
import observer.application.api.SearchDto;
import observer.application.common.SearchMapper;
import observer.application.service.SearchService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = FormController.API_PATH)
@AllArgsConstructor
public class FormController {

    public static final String API_PATH = "/form";

    private final SearchService searchService;
    private final SearchMapper searchMapper;

    @GetMapping(value = {"/search", "/search/{id}"})
    public String form(Model model, @PathVariable(name = "id", required = false) Long searchId) {
        if (searchId == null) {
            model.addAttribute("searchDto", new SearchDto());
        } else {
            model.addAttribute("searchDto", searchMapper.toSearchDto(searchService.getSearch(searchId)));
        }
        return "form";
    }
}
