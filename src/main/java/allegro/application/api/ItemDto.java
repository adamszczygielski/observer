package allegro.application.api;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@Data
@NoArgsConstructor
public class ItemDto {

    private Long itemId;
    private String originId;
    private String title;
    private Timestamp creationDate;
    private String price;
    private String url;
    private String source;
}
