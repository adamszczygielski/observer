
package observer.application.service.source.allegro.model.listing;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.Generated;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "labelParts",
    "style"
})
@Generated("jsonschema2pojo")
public class Label__1 {

    @JsonProperty("labelParts")
    private List<LabelPart> labelParts = new ArrayList<LabelPart>();
    @JsonProperty("style")
    private Style__1 style;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Label__1() {
    }

    /**
     * 
     * @param style
     * @param labelParts
     */
    public Label__1(List<LabelPart> labelParts, Style__1 style) {
        super();
        this.labelParts = labelParts;
        this.style = style;
    }

    @JsonProperty("labelParts")
    public List<LabelPart> getLabelParts() {
        return labelParts;
    }

    @JsonProperty("labelParts")
    public void setLabelParts(List<LabelPart> labelParts) {
        this.labelParts = labelParts;
    }

    @JsonProperty("style")
    public Style__1 getStyle() {
        return style;
    }

    @JsonProperty("style")
    public void setStyle(Style__1 style) {
        this.style = style;
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
