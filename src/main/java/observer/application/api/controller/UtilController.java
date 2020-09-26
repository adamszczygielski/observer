package observer.application.api.controller;

import lombok.AllArgsConstructor;
import observer.application.api.allegro.AllegroCategoryDto;
import observer.application.service.source.allegro.AllegroService;
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
    public List<AllegroCategoryDto> categories(@RequestParam(value = "id", required = false, defaultValue = "0") String parentId) {
        return allegroService.getCategories(parentId);
    }

}
