package observer.application.api.controller;

import lombok.RequiredArgsConstructor;
import observer.application.mapper.ItemMapper;
import observer.application.service.ItemApiService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    public String getActiveItems(Model model) {
        model.addAttribute("items", itemMapper.toDtoList(itemApiService.getActiveItems()));
        return "items";
    }

    @GetMapping(value = "/{searchId}")
    public String getActiveItems(Model model, @PathVariable Long searchId) {
        model.addAttribute("items", itemMapper.toDtoList(itemApiService.getActiveItems(searchId)));
        return "items";
    }

    @GetMapping(value = "/{searchId}/preview")
    public String fetchItems(Model model, @PathVariable Long searchId) {
        model.addAttribute("items", itemMapper.toDtoList(itemApiService.fetchItems(searchId)));
        return "items-preview";
    }

    @DeleteMapping
    public String deleteItems(@RequestParam("id") List<Long> itemIds, HttpServletRequest request) {
        itemApiService.deleteItems(itemIds);
        return "redirect:" + request.getHeader("Referer");
    }

}
