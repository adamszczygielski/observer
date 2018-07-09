package allegro.app.controller;

import allegro.app.common.Utils;
import lombok.*;
import org.springframework.stereotype.Component;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SearchDto {

    @Setter(AccessLevel.NONE)
    String keywords;

    Long interval;

    public void setKeywords(String keywords) {
        this.keywords = Utils.stringNormalizer(keywords);
    }
}
