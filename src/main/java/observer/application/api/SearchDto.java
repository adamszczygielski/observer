package observer.application.api;

import observer.application.common.Utils;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.util.StringUtils;

@Getter
@NoArgsConstructor
public class SearchDto {

    private String keyword;
    private String category;
    private Long interval;
    private Source source;
    private String priceFrom;
    private String priceTo;

    public void setKeyword(String keyword) {
        this.keyword = Utils.normalize(keyword);
    }

    public void setCategory(String category) {
        if(StringUtils.isEmpty(category)) {
            this.category = null;
        } else {
            this.category = category;
        }
    }

    public void setInterval(Long interval) {
        this.interval = Math.abs(interval);
    }

    public void setSource(Source source) {
        this.source = source;
    }

    public void setPriceFrom(String priceFrom) {
        this.priceFrom = priceFrom;
    }

    public void setPriceTo(String priceTo) {
        this.priceTo = priceTo;
    }
}