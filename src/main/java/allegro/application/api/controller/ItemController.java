package allegro.application.api.controller;

import allegro.application.common.ItemAssembler;
import allegro.application.service.ApplicationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
@AllArgsConstructor
public class ItemController {

    private final ApplicationService applicationService;
    private final ItemAssembler itemAssembler;

    @RequestMapping("/item/list/preview/{searchId}")
    public String fetchItemsPreview(Model model, @PathVariable Long searchId) {
        model.addAttribute("items", itemAssembler.toDtoList(applicationService.fetchItemsPreview(searchId)));
        return "items-preview";
    }

    @RequestMapping("/item/list/{searchId}")
    public String fetchItems(Model model, @PathVariable Long searchId) {
        model.addAttribute("items", itemAssembler.toDtoList(applicationService.fetchItems(searchId)));
        return "items";
    }

    @RequestMapping("/item/list")
    public String fetchActiveItems(Model model) {
        model.addAttribute("items", itemAssembler.toDtoList(applicationService.fetchActiveItems()));
        return "items";
    }

    @RequestMapping(value = "/item/delete/{itemId}", method = RequestMethod.DELETE)
    public String deleteItem(@PathVariable Long itemId, HttpServletRequest request) {
        applicationService.deleteItem(itemId);
        return "redirect:" + request.getHeader("Referer");
    }
}
