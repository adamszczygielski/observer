package allegro.application.api.controller;

import allegro.application.api.allegro.AllegroCategoryDto;
import allegro.application.service.source.allegro.AllegroService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = UtilController.API_PATH)
@AllArgsConstructor
public class UtilController {

    public static final String API_PATH = "/util";

    private final AllegroService allegroService;

    @GetMapping("/categories/allegro")
    public List<AllegroCategoryDto> categories(@RequestParam(value = "id", required = false) String parentId) {
        return allegroService.getCategories(parentId);
    }
}
