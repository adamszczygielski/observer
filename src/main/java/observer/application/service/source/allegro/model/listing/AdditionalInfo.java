
package observer.application.service.source.allegro.model.listing;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.Generated;
import java.util.LinkedHashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "text",
    "strikeThrough",
    "bold"
})
@Generated("jsonschema2pojo")
public class AdditionalInfo {

    @JsonProperty("text")
    private String text;
    @JsonProperty("strikeThrough")
    private Boolean strikeThrough;
    @JsonProperty("bold")
    private Boolean bold;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public AdditionalInfo() {
    }

    /**
     * 
     * @param strikeThrough
     * @param text
     * @param bold
     */
    public AdditionalInfo(String text, Boolean strikeThrough, Boolean bold) {
        super();
        this.text = text;
        this.strikeThrough = strikeThrough;
        this.bold = bold;
    }

    @JsonProperty("text")
    public String getText() {
        return text;
    }

    @JsonProperty("text")
    public void setText(String text) {
        this.text = text;
    }

    @JsonProperty("strikeThrough")
    public Boolean getStrikeThrough() {
        return strikeThrough;
    }

    @JsonProperty("strikeThrough")
    public void setStrikeThrough(Boolean strikeThrough) {
        this.strikeThrough = strikeThrough;
    }

    @JsonProperty("bold")
    public Boolean getBold() {
        return bold;
    }

    @JsonProperty("bold")
    public void setBold(Boolean bold) {
        this.bold = bold;
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
