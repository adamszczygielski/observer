package observer.application.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CategoryDto {

    private final String id;
    private final String name;
    private final Boolean leaf;
}
