package allegro.application.api.allegro;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AllegroCategoryDto {

    private String id;
    private String name;
    private Boolean leaf;
}
