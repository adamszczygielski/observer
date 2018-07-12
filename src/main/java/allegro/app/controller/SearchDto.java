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
    String keyword;
    String category;
    Long interval;

    public void setKeyword(String keyword) {
        this.keyword = Utils.stringNormalizer(keyword);
    }
}
