package observer.application.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(RedirectController.API_PATH)
public class RedirectController {

    public static final String API_PATH = "/";

    @GetMapping
    public ModelAndView redirect() {
        return new ModelAndView("redirect:" + ItemController.API_PATH);
    }
}
