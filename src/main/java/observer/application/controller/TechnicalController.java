package observer.application.controller;

import lombok.RequiredArgsConstructor;
import observer.application.logger.LogReader;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(TechnicalController.API_PATH)
@RequiredArgsConstructor
public class TechnicalController {

    public static final String API_PATH = "/";

    @GetMapping
    public ModelAndView redirect() {
        return new ModelAndView("redirect:" + ItemController.API_PATH);
    }

    @GetMapping(value = "/logs")
    public String getApplicationLogs(Model model, @RequestParam(value = "limit", defaultValue = "100") int limit) {
        model.addAttribute("logs", LogReader.getInstance().getApplicationLogs(limit));
        return "logs";
    }
}
