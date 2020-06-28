package allegro.application.api.controller;

import allegro.application.api.allegro.AllegroCategoryDto;
import allegro.application.service.source.allegro.AllegroService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
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
