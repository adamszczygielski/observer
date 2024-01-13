
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
    "light",
    "dark"
})
@Generated("jsonschema2pojo")
public class Themes__1 {

    @JsonProperty("light")
    private Light__1 light;
    @JsonProperty("dark")
    private Dark__1 dark;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Themes__1() {
    }

    /**
     * 
     * @param light
     * @param dark
     */
    public Themes__1(Light__1 light, Dark__1 dark) {
        super();
        this.light = light;
        this.dark = dark;
    }

    @JsonProperty("light")
    public Light__1 getLight() {
        return light;
    }

    @JsonProperty("light")
    public void setLight(Light__1 light) {
        this.light = light;
    }

    @JsonProperty("dark")
    public Dark__1 getDark() {
        return dark;
    }

    @JsonProperty("dark")
    public void setDark(Dark__1 dark) {
        this.dark = dark;
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
