package observer.application.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.Instant;

@Getter
@Builder
public class ItemDto {

    private final Long id;
    private final String originId;
    private final String title;
    private final Instant dateCreated;
    private final String price;
    private final String url;
    private final String source;

}
