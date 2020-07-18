package allegro.application.api;

import lombok.Builder;
import lombok.Data;

import java.sql.Timestamp;

@Data
@Builder
public class ItemDto {

    private Long itemId;
    private String originId;
    private String title;
    private Timestamp dateCreated;
    private String price;
    private String url;
    private String source;
}
