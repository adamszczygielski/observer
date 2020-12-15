package observer.application.api;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ItemDto {

    private final Long itemId;
    private final String originId;
    private final String title;
    private final String dateCreated;
    private final String price;
    private final String url;
    private final String source;

}
