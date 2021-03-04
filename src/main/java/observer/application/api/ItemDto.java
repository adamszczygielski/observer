package observer.application.api;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalTime;

@Getter
@Builder
public class ItemDto {

    private final Long itemId;
    private final String originId;
    private final String title;
    private final LocalTime dateCreated;
    private final String price;
    private final String url;
    private final String source;

}
