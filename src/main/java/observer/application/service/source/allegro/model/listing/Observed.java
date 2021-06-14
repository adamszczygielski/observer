
package observer.application.service.source.allegro.model.listing;

import java.util.List;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "ids",
    "pageUrl"
})
@Generated("jsonschema2pojo")
public class Observed {

    @JsonProperty("ids")
    private List<Object> ids = null;
    @JsonProperty("pageUrl")
    private String pageUrl;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Observed() {
    }

    /**
     * 
     * @param ids
     * @param pageUrl
     */
    public Observed(List<Object> ids, String pageUrl) {
        super();
        this.ids = ids;
        this.pageUrl = pageUrl;
    }

    @JsonProperty("ids")
    public List<Object> getIds() {
        return ids;
    }

    @JsonProperty("ids")
    public void setIds(List<Object> ids) {
        this.ids = ids;
    }

    @JsonProperty("pageUrl")
    public String getPageUrl() {
        return pageUrl;
    }

    @JsonProperty("pageUrl")
    public void setPageUrl(String pageUrl) {
        this.pageUrl = pageUrl;
    }

}
