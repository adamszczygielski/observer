
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
    "name",
    "values",
    "highlight"
})
@Generated("jsonschema2pojo")
public class Parameter {

    @JsonProperty("name")
    private String name;
    @JsonProperty("values")
    private List<String> values = new ArrayList<String>();
    @JsonProperty("highlight")
    private Boolean highlight;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Parameter() {
    }

    /**
     * 
     * @param highlight
     * @param values
     * @param name
     */
    public Parameter(String name, List<String> values, Boolean highlight) {
        super();
        this.name = name;
        this.values = values;
        this.highlight = highlight;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("values")
    public List<String> getValues() {
        return values;
    }

    @JsonProperty("values")
    public void setValues(List<String> values) {
        this.values = values;
    }

    @JsonProperty("highlight")
    public Boolean getHighlight() {
        return highlight;
    }

    @JsonProperty("highlight")
    public void setHighlight(Boolean highlight) {
        this.highlight = highlight;
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
