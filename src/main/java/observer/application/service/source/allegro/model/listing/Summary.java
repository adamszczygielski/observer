
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
    "labels"
})
@Generated("jsonschema2pojo")
public class Summary {

    @JsonProperty("labels")
    private List<Label__3> labels = new ArrayList<Label__3>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Summary() {
    }

    /**
     * 
     * @param labels
     */
    public Summary(List<Label__3> labels) {
        super();
        this.labels = labels;
    }

    @JsonProperty("labels")
    public List<Label__3> getLabels() {
        return labels;
    }

    @JsonProperty("labels")
    public void setLabels(List<Label__3> labels) {
        this.labels = labels;
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
