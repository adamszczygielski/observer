
package observer.application.service.source.allegro.model.listing;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.Generated;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "calculation",
    "label",
    "labels"
})
@Generated("jsonschema2pojo")
public class Installments {

    @JsonProperty("calculation")
    private Calculation calculation;
    @JsonProperty("label")
    private Label label;
    @JsonProperty("labels")
    private List<Label__1> labels = new ArrayList<Label__1>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Installments() {
    }

    /**
     * 
     * @param calculation
     * @param label
     * @param labels
     */
    public Installments(Calculation calculation, Label label, List<Label__1> labels) {
        super();
        this.calculation = calculation;
        this.label = label;
        this.labels = labels;
    }

    @JsonProperty("calculation")
    public Calculation getCalculation() {
        return calculation;
    }

    @JsonProperty("calculation")
    public void setCalculation(Calculation calculation) {
        this.calculation = calculation;
    }

    @JsonProperty("label")
    public Label getLabel() {
        return label;
    }

    @JsonProperty("label")
    public void setLabel(Label label) {
        this.label = label;
    }

    @JsonProperty("labels")
    public List<Label__1> getLabels() {
        return labels;
    }

    @JsonProperty("labels")
    public void setLabels(List<Label__1> labels) {
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
