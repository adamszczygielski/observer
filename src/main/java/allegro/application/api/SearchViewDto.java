package allegro.application.api;

import lombok.Data;

import java.io.Serializable;


@Data
public class SearchViewDto implements Serializable {

    private Long id;
    private String keyword;
    private String category;
    private Long timeInterval;
    private String source;
    private Long count;
    private String lastUpdate;
}
