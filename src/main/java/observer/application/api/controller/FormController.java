package observer.application.api.controller;

import lombok.RequiredArgsConstructor;
import observer.application.api.SearchDto;
import observer.application.mapper.SearchMapper;
import observer.application.service.SearchApiService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = FormController.API_PATH)
@RequiredArgsConstructor
public class FormController {

    public static final String API_PATH = "/form";

    private final SearchApiService searchApiService;
    private final SearchMapper searchMapper;

    @GetMapping(value = "/search")
    public String newForm(Model model) {
        model.addAttribute("searchDto", new SearchDto());
        return "form";
    }

    @GetMapping(value = "/search/{id}")
    public String editForm(Model model, @PathVariable(name = "id") Long searchId) {
        model.addAttribute("searchDto", searchMapper.toSearchDto(searchApiService.getSearch(searchId)));
        return "form";
    }
}
