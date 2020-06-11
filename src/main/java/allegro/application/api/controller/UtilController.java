package allegro.application.api.controller;

import allegro.application.api.allegro.AllegroCategoryDto;
import allegro.application.service.source.allegro.AllegroService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class UtilController {

    private final AllegroService allegroService;

    @GetMapping("api/allegro/categories")
    public List<AllegroCategoryDto> categories(@RequestParam(value = "id", required = false) String parentId) {
        return allegroService.getCategories(parentId);
    }
}
