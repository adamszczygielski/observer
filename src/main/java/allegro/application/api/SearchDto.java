package allegro.application.api;

import allegro.application.common.Utils;
import lombok.*;
import org.springframework.util.StringUtils;

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
        if(StringUtils.isEmpty(category)) {
            this.category = null;
        } else {
            this.category = category;
        }
    }
}
