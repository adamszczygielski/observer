package allegro.application.api;

import allegro.application.common.Utils;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.util.StringUtils;

import java.util.HashMap;

@Getter
@NoArgsConstructor
public class SearchDto {

    private String keyword;
    private String category;
    private Long interval;
    private Source source;
    private HashMap<ParameterType, String> params;

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

    public String getParamValue(ParameterType parameterType) {
        return params.get(parameterType);
    }

    public void putParamValue(ParameterType parameterType, String value) {
        params.put(parameterType, value);
    }
}
