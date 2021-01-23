package observer.application.api.controller;

import lombok.RequiredArgsConstructor;
import observer.application.common.ItemMapper;
import observer.application.service.ItemApiService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping(ItemController.API_PATH)
@RequiredArgsConstructor
public class ItemController {

    public static final String API_PATH = "/items";

    private final ItemApiService itemApiService;
    private final ItemMapper itemMapper;

    @GetMapping
    public String fetchActiveItems(Model model) {
        model.addAttribute("items", itemMapper.toDtoList(itemApiService.fetchActiveItems()));
        return "items";
    }

    @GetMapping(value = "/{searchId}")
    public String fetchActiveItems(Model model, @PathVariable Long searchId) {
        model.addAttribute("items", itemMapper.toDtoList(itemApiService.fetchActiveItems(searchId)));
        return "items";
    }

    @GetMapping(value = "/{searchId}/preview")
    public String fetchItemsPreview(Model model, @PathVariable Long searchId) {
        model.addAttribute("items", itemMapper.toDtoList(itemApiService.fetchItemsPreview(searchId)));
        return "items-preview";
    }

    @DeleteMapping
    public String deleteItems(@RequestParam("id") List<Long> itemIds, HttpServletRequest request) {
        itemApiService.deleteItems(itemIds);
        return "redirect:" + request.getHeader("Referer");
    }
}
