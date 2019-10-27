package allegro.application.api;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;


@Getter
@Setter
@NoArgsConstructor
public class SearchViewDto implements Serializable {

    private Long id;
    private String keyword;
    private String category;
    private Long timeInterval;
    private String source;
    private Long count;
    private String lastUpdate;
}
