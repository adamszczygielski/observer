package observer.application.controller;

import lombok.RequiredArgsConstructor;
import observer.application.logger.LogReader;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(LogController.API_PATH)
@RequiredArgsConstructor
public class LogController {

    public static final String API_PATH = "/logs";

    @GetMapping
    public String getApplicationLogs(Model model, @RequestParam(value = "limit", defaultValue = "100") int limit) {
        model.addAttribute("logs", LogReader.getApplicationLogs(limit));
        return "logs";
    }
}
