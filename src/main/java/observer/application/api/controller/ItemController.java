package observer.application.api.controller;

import lombok.AllArgsConstructor;
import observer.application.common.ItemMapper;
import observer.application.service.ApplicationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping(ItemController.API_PATH)
@AllArgsConstructor
public class ItemController {

    public static final String API_PATH = "/items";

    private final ApplicationService applicationService;
    private final ItemMapper itemMapper;

    @GetMapping
    public String fetchActiveItems(Model model) {
        model.addAttribute("items", itemMapper.toDtoList(applicationService.fetchActiveItems()));
        return "items";
    }

    @GetMapping(value = "/{searchId}")
    public String fetchItems(Model model, @PathVariable Long searchId) {
        model.addAttribute("items", itemMapper.toDtoList(applicationService.fetchItems(searchId)));
        return "items";
    }

    @GetMapping(value = "/{searchId}/preview")
    public String fetchItemsPreview(Model model, @PathVariable Long searchId) {
        model.addAttribute("items", itemMapper.toDtoList(applicationService.fetchItemsPreview(searchId)));
        return "items-preview";
    }

    @DeleteMapping
    public String deleteItems(@RequestParam("id") List<Long> itemIds, HttpServletRequest request) {
        applicationService.deleteItems(itemIds);
        return "redirect:" + request.getHeader("Referer");
    }
}
