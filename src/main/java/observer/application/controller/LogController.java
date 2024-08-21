package observer.application.controller;

import lombok.RequiredArgsConstructor;
import observer.application.logger.LogReader;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(LogController.API_PATH)
@RequiredArgsConstructor
public class LogController {

    public static final String API_PATH = "/logs";

    @GetMapping
    @ModelAttribute("logs")
    public String getApplicationLogs(@RequestParam(value = "limit", defaultValue = "100") int limit) {
        return LogReader.getApplicationLogs(limit);
    }
}
