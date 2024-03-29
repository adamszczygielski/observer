
package observer.application.service.source.allegro.model.listing;

import java.util.LinkedHashMap;
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
    "regularLabel",
    "charityLabel"
})
@Generated("jsonschema2pojo")
public class Labels {

    @JsonProperty("regularLabel")
    private RegularLabel regularLabel;
    @JsonProperty("charityLabel")
    private Object charityLabel;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Labels() {
    }

    /**
     * 
     * @param regularLabel
     * @param charityLabel
     */
    public Labels(RegularLabel regularLabel, Object charityLabel) {
        super();
        this.regularLabel = regularLabel;
        this.charityLabel = charityLabel;
    }

    @JsonProperty("regularLabel")
    public RegularLabel getRegularLabel() {
        return regularLabel;
    }

    @JsonProperty("regularLabel")
    public void setRegularLabel(RegularLabel regularLabel) {
        this.regularLabel = regularLabel;
    }

    @JsonProperty("charityLabel")
    public Object getCharityLabel() {
        return charityLabel;
    }

    @JsonProperty("charityLabel")
    public void setCharityLabel(Object charityLabel) {
        this.charityLabel = charityLabel;
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
