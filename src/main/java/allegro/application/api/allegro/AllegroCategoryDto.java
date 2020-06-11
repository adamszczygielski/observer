package allegro.application.api.allegro;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class AllegroCategoryDto {

    private final String id;
    private final String name;
    private final Boolean leaf;
}
