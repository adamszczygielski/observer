package observer.application.api.controller;

import observer.application.api.SearchDto;
import observer.application.service.source.allegro.AllegroService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = FormController.API_PATH)
@AllArgsConstructor
public class FormController {

    public static final String API_PATH = "/form";

    private final AllegroService allegroService;

    @RequestMapping(method = RequestMethod.GET)
    public String form(Model model, @ModelAttribute("searchDto") SearchDto searchDto) {
        model.addAttribute("searchDto", new SearchDto());
        model.addAttribute("categories", allegroService.getCategories(searchDto.getCategory()));
        return "form";
    }
}
