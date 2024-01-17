package observer.application.controller;

import lombok.RequiredArgsConstructor;
import observer.application.dto.SearchDto;
import observer.application.mapper.SearchMapper;
import observer.application.service.SearchService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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

    @PostMapping(value = "/search")
    public String submitForm(@ModelAttribute("searchDto") @Valid SearchDto searchDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "form";
        }
        searchService.createOrUpdate(searchMapper.toSearch(searchDto));
        return "redirect:" + SearchController.API_PATH;
    }
}
