package allegro.app.api;

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

    Long itemId;
    String title;
    Timestamp creationDate;
    String price;
    String url;
}
