package observer.application.api.controller;

import lombok.RequiredArgsConstructor;
import observer.application.api.CategoryDto;
import observer.application.domain.Category;
import observer.application.mapper.CategoryMapper;
import observer.application.service.ItemApiService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = CategoryController.API_PATH)
@RequiredArgsConstructor
public class CategoryController {

    public static final String API_PATH = "/categories";

    private final ItemApiService itemApiService;
    private final CategoryMapper categoryMapper;

    @GetMapping
    public List<CategoryDto> getCategories(
            @RequestParam(value = "sourceId") Integer sourceId,
            @RequestParam(value = "parentId", required = false, defaultValue = "0") String parentId) {
        List<Category> categories = itemApiService.getCategories(sourceId, parentId);
        return categoryMapper.toDtoList(categories);
    }

}
