package observer.application.controller;

import lombok.RequiredArgsConstructor;
import observer.application.mapper.ItemMapper;
import observer.application.service.ItemService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping(ItemController.API_PATH)
@RequiredArgsConstructor
public class ItemController {

    public static final String API_PATH = "/items";

    private final ItemService itemService;
    private final ItemMapper itemMapper;

    @GetMapping
    public String getItems(Model model) {
        model.addAttribute("items", itemMapper.toDtoList(itemService.getItems()));
        return "items";
    }

    @PostMapping("/delete")
    public String deleteItems(@RequestParam("id") List<Long> itemIds, HttpServletRequest request) {
        itemService.deleteItems(itemIds);
        return "redirect:" + request.getHeader("Referer");
    }
}
