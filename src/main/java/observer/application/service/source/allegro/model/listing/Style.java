
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
    "textAttributes"
})
@Generated("jsonschema2pojo")
public class Style {

    @JsonProperty("textAttributes")
    private TextAttributes textAttributes;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Style() {
    }

    /**
     * 
     * @param textAttributes
     */
    public Style(TextAttributes textAttributes) {
        super();
        this.textAttributes = textAttributes;
    }

    @JsonProperty("textAttributes")
    public TextAttributes getTextAttributes() {
        return textAttributes;
    }

    @JsonProperty("textAttributes")
    public void setTextAttributes(TextAttributes textAttributes) {
        this.textAttributes = textAttributes;
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
