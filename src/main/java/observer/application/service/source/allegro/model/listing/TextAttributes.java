
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
    "bold",
    "strikethrough"
})
@Generated("jsonschema2pojo")
public class TextAttributes {

    @JsonProperty("bold")
    private Boolean bold;
    @JsonProperty("strikethrough")
    private Boolean strikethrough;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public TextAttributes() {
    }

    /**
     * 
     * @param bold
     * @param strikethrough
     */
    public TextAttributes(Boolean bold, Boolean strikethrough) {
        super();
        this.bold = bold;
        this.strikethrough = strikethrough;
    }

    @JsonProperty("bold")
    public Boolean getBold() {
        return bold;
    }

    @JsonProperty("bold")
    public void setBold(Boolean bold) {
        this.bold = bold;
    }

    @JsonProperty("strikethrough")
    public Boolean getStrikethrough() {
        return strikethrough;
    }

    @JsonProperty("strikethrough")
    public void setStrikethrough(Boolean strikethrough) {
        this.strikethrough = strikethrough;
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
