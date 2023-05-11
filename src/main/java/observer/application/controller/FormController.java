package observer.application.controller;

import lombok.RequiredArgsConstructor;
import observer.application.dto.SearchDto;
import observer.application.mapper.SearchMapper;
import observer.application.service.SearchService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(FormController.API_PATH)
@RequiredArgsConstructor
public class FormController {

    public static final String API_PATH = "/form";

    private final SearchService searchService;
    private final SearchMapper searchMapper = new SearchMapper();

    @GetMapping(value = "/search")
    public String getForm(Model model) {
        model.addAttribute("searchDto", new SearchDto());
        return "form";
    }

    @GetMapping(value = "/search/{id}")
    public String getForm(Model model, @PathVariable(name = "id") Long searchId) {
        model.addAttribute("searchDto", searchMapper.toDto(searchService.getOrThrow(searchId)));
        return "form";
    }
}
