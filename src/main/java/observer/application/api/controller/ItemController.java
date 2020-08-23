package observer.application.api.controller;

import lombok.AllArgsConstructor;
import observer.application.common.ItemMapper;
import observer.application.service.ApplicationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

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

    @RequestMapping(method = RequestMethod.DELETE)
    public String deleteItems(@RequestParam("id") List<Long> itemIds, HttpServletRequest request) {
        applicationService.deleteItems(itemIds);
        return "redirect:" + request.getHeader("Referer");
    }
}
