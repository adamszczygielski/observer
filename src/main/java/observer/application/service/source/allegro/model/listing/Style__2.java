
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
    "themes",
    "textAttributes"
})
@Generated("jsonschema2pojo")
public class Style__2 {

    @JsonProperty("themes")
    private Themes__1 themes;
    @JsonProperty("textAttributes")
    private TextAttributes__1 textAttributes;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Style__2() {
    }

    /**
     * 
     * @param themes
     * @param textAttributes
     */
    public Style__2(Themes__1 themes, TextAttributes__1 textAttributes) {
        super();
        this.themes = themes;
        this.textAttributes = textAttributes;
    }

    @JsonProperty("themes")
    public Themes__1 getThemes() {
        return themes;
    }

    @JsonProperty("themes")
    public void setThemes(Themes__1 themes) {
        this.themes = themes;
    }

    @JsonProperty("textAttributes")
    public TextAttributes__1 getTextAttributes() {
        return textAttributes;
    }

    @JsonProperty("textAttributes")
    public void setTextAttributes(TextAttributes__1 textAttributes) {
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
