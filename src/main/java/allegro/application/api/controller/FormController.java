package allegro.application.api.controller;

import allegro.application.api.SearchDto;
import allegro.application.service.source.allegro.AllegroService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = FormController.API_PATH)
@AllArgsConstructor
public class FormController {

    public static final String API_PATH = "/form";

    private final AllegroService allegroService;

    @RequestMapping(value = "/allegro", method = RequestMethod.GET)
    public String form(Model model,
                       @RequestParam(value = "category", required = false) String parentId,
                       @ModelAttribute("searchDto") SearchDto searchDto) {

        model.addAttribute("searchDto", new SearchDto());
        model.addAttribute("categories", allegroService.getCategories(searchDto.getCategory()));
        return "form-allegro";
    }
}
