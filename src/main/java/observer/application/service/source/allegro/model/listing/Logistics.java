
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
    "additionalInfo",
    "labels"
})
@Generated("jsonschema2pojo")
public class Logistics {

    @JsonProperty("additionalInfo")
    private AdditionalInfo additionalInfo;
    @JsonProperty("labels")
    private List<Label__2> labels = new ArrayList<Label__2>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Logistics() {
    }

    /**
     * 
     * @param additionalInfo
     * @param labels
     */
    public Logistics(AdditionalInfo additionalInfo, List<Label__2> labels) {
        super();
        this.additionalInfo = additionalInfo;
        this.labels = labels;
    }

    @JsonProperty("additionalInfo")
    public AdditionalInfo getAdditionalInfo() {
        return additionalInfo;
    }

    @JsonProperty("additionalInfo")
    public void setAdditionalInfo(AdditionalInfo additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    @JsonProperty("labels")
    public List<Label__2> getLabels() {
        return labels;
    }

    @JsonProperty("labels")
    public void setLabels(List<Label__2> labels) {
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
