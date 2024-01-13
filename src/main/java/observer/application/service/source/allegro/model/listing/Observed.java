
package observer.application.service.source.allegro.model.listing;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "ids",
    "tooManyObservedFor",
    "pageUrl"
})
@Generated("jsonschema2pojo")
public class Observed {

    @JsonProperty("ids")
    private List<Object> ids = new ArrayList<Object>();
    @JsonProperty("tooManyObservedFor")
    private Object tooManyObservedFor;
    @JsonProperty("pageUrl")
    private String pageUrl;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

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
     * @param tooManyObservedFor
     */
    public Observed(List<Object> ids, Object tooManyObservedFor, String pageUrl) {
        super();
        this.ids = ids;
        this.tooManyObservedFor = tooManyObservedFor;
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

    @JsonProperty("tooManyObservedFor")
    public Object getTooManyObservedFor() {
        return tooManyObservedFor;
    }

    @JsonProperty("tooManyObservedFor")
    public void setTooManyObservedFor(Object tooManyObservedFor) {
        this.tooManyObservedFor = tooManyObservedFor;
    }

    @JsonProperty("pageUrl")
    public String getPageUrl() {
        return pageUrl;
    }

    @JsonProperty("pageUrl")
    public void setPageUrl(String pageUrl) {
        this.pageUrl = pageUrl;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
