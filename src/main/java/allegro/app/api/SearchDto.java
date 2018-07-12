package allegro.app.api;

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
    @Setter(AccessLevel.NONE)
    String category;
    Long interval;

    public void setKeyword(String keyword) {
        this.keyword = Utils.stringNormalizer(keyword);
    }

    public void setCategory(String category) {
        if(org.springframework.util.StringUtils.isEmpty(category)) {
            this.category = null;
        } else {
            this.category = category;
        }
    }
}
