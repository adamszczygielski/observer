package observer.application.mapper;

import observer.application.api.CategoryDto;
import observer.application.domain.Category;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper implements BaseMapper<Category, CategoryDto> {

    @Override
    public CategoryDto toDto(Category category) {
        return CategoryDto.builder()
                .id(category.getId())
                .name(category.getName())
                .leaf(category.getLeaf())
                .build();
    }
}
