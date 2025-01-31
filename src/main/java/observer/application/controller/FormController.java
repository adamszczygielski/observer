package observer.application.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import observer.application.dto.SearchDto;
import observer.application.mapper.SearchMapper;
import observer.application.service.SearchService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping(FormController.API_PATH)
@RequiredArgsConstructor
public class FormController {

    public static final String API_PATH = "/form";

    private final SearchService searchService;
    private final SearchMapper searchMapper;

    @GetMapping(value = "/search")
    public String getForm(Model model) {
        model.addAttribute("search", SearchDto.builder().build());
        return "form";
    }

    @GetMapping(value = "/search/{id}")
    public String getForm(Model model, @PathVariable(name = "id") Long searchId) {
        model.addAttribute("search", searchMapper.toDto(searchService.getOrThrow(searchId)));
        return "form";
    }

    @PostMapping(value = "/search")
    public String submitForm(@ModelAttribute("search") @Valid SearchDto searchDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "form";
        }
        searchService.createOrUpdate(searchMapper.toSearch(searchDto));
        return "redirect:" + SearchController.API_PATH;
    }
}
