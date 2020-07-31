package observer.application.api.controller;

import observer.application.common.ItemMapper;
import observer.application.service.ApplicationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(ItemController.API_PATH)
@AllArgsConstructor
public class ItemController {

    public static final String API_PATH = "/items";

    private final ApplicationService applicationService;
    private final ItemMapper itemMapper;

    @RequestMapping(method = RequestMethod.GET)
    public String fetchActiveItems(Model model) {
        model.addAttribute("items", itemMapper.toDtoList(applicationService.fetchActiveItems()));
        return "items";
    }

    @RequestMapping(value = "/{searchId}", method = RequestMethod.GET)
    public String fetchItems(Model model, @PathVariable Long searchId) {
        model.addAttribute("items", itemMapper.toDtoList(applicationService.fetchItems(searchId)));
        return "items";
    }

    @RequestMapping(value = "/{searchId}/preview", method = RequestMethod.GET)
    public String fetchItemsPreview(Model model, @PathVariable Long searchId) {
        model.addAttribute("items", itemMapper.toDtoList(applicationService.fetchItemsPreview(searchId)));
        return "items-preview";
    }

    @RequestMapping(value = "/{itemId}", method = RequestMethod.DELETE)
    public String deleteItem(@PathVariable Long itemId, HttpServletRequest request) {
        applicationService.deleteItem(itemId);
        return "redirect:" + request.getHeader("Referer");
    }
}
