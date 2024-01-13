
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
    "badge"
})
@Generated("jsonschema2pojo")
public class Style__1 {

    @JsonProperty("themes")
    private Themes themes;
    @JsonProperty("badge")
    private Boolean badge;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Style__1() {
    }

    /**
     * 
     * @param themes
     * @param badge
     */
    public Style__1(Themes themes, Boolean badge) {
        super();
        this.themes = themes;
        this.badge = badge;
    }

    @JsonProperty("themes")
    public Themes getThemes() {
        return themes;
    }

    @JsonProperty("themes")
    public void setThemes(Themes themes) {
        this.themes = themes;
    }

    @JsonProperty("badge")
    public Boolean getBadge() {
        return badge;
    }

    @JsonProperty("badge")
    public void setBadge(Boolean badge) {
        this.badge = badge;
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
