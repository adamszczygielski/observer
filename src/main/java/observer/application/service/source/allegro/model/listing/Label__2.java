
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
    "labelParts"
})
@Generated("jsonschema2pojo")
public class Label__2 {

    @JsonProperty("labelParts")
    private List<LabelPart__1> labelParts = new ArrayList<LabelPart__1>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Label__2() {
    }

    /**
     * 
     * @param labelParts
     */
    public Label__2(List<LabelPart__1> labelParts) {
        super();
        this.labelParts = labelParts;
    }

    @JsonProperty("labelParts")
    public List<LabelPart__1> getLabelParts() {
        return labelParts;
    }

    @JsonProperty("labelParts")
    public void setLabelParts(List<LabelPart__1> labelParts) {
        this.labelParts = labelParts;
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
