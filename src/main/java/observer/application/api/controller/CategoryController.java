package observer.application.api.controller;

import lombok.AllArgsConstructor;
import observer.application.api.CategoryDto;
import observer.application.common.CategoryMapper;
import observer.application.domain.Category;
import observer.application.service.ItemApiService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = CategoryController.API_PATH)
@AllArgsConstructor
public class CategoryController {

    public static final String API_PATH = "/categories";

    private final ItemApiService itemApiService;
    private final CategoryMapper categoryMapper;

    @GetMapping
    public List<CategoryDto> getCategories(
            @RequestParam(value = "sourceId") Long sourceId,
            @RequestParam(value = "parentId", required = false, defaultValue = "0") String parentId) {

        List<Category> categories = itemApiService.getCategories(sourceId, parentId);
        return categoryMapper.toDtoList(categories);
    }

}
