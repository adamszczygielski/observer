package allegro.application.controller;

import allegro.application.service.ItemService;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
@ComponentScan(basePackageClasses = ItemService.class)
public class ItemController {

    private ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @RequestMapping("/item/list/preview/{searchId}")
    public String fetchItemsPreview(Model model, @PathVariable Long searchId) {
        model.addAttribute("items", itemService.fetchItemsPreview(searchId));
        return "items";
    }

    @RequestMapping("/item/list/{searchId}")
    public String fetchItems(Model model, @PathVariable Long searchId) {
        model.addAttribute("items", itemService.fetchItems(searchId));
        return "items";
    }

    @RequestMapping(value = "/item/delete/{id}", method = RequestMethod.DELETE)
    public String deleteItem(@PathVariable Long id, HttpServletRequest request) {
        itemService.deleteItem(id);
        return "redirect:" + request.getHeader("Referer");
    }
}
