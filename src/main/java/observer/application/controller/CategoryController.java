package observer.application.controller;

import lombok.RequiredArgsConstructor;
import observer.application.dto.CategoryDto;
import observer.application.mapper.CategoryMapper;
import observer.application.service.source.SourceServiceSolver;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(CategoryController.API_PATH)
@CrossOrigin
@RequiredArgsConstructor
public class CategoryController {

    public static final String API_PATH = "/categories";

    private final SourceServiceSolver sourceServiceSolver;
    private final CategoryMapper categoryMapper = new CategoryMapper();

    @GetMapping
    public List<CategoryDto> getCategories(
            @RequestParam(value = "sourceId") int sourceId,
            @RequestParam(value = "parentId", required = false, defaultValue = "0") String parentId) {
        return categoryMapper.toDtoList(sourceServiceSolver.get(sourceId).fetchCategories(parentId));
    }

}
