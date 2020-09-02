package observer.application.api.controller;

import lombok.AllArgsConstructor;
import observer.application.api.SearchDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = FormController.API_PATH)
@AllArgsConstructor
public class FormController {

    public static final String API_PATH = "/form";

    @GetMapping
    public String form(Model model) {
        model.addAttribute("searchDto", new SearchDto());
        return "form";
    }
}
