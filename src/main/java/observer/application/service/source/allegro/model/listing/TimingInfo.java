
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
    "itemText",
    "popoverText"
})
@Generated("jsonschema2pojo")
public class TimingInfo {

    @JsonProperty("itemText")
    private String itemText;
    @JsonProperty("popoverText")
    private String popoverText;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public TimingInfo() {
    }

    /**
     * 
     * @param popoverText
     * @param itemText
     */
    public TimingInfo(String itemText, String popoverText) {
        super();
        this.itemText = itemText;
        this.popoverText = popoverText;
    }

    @JsonProperty("itemText")
    public String getItemText() {
        return itemText;
    }

    @JsonProperty("itemText")
    public void setItemText(String itemText) {
        this.itemText = itemText;
    }

    @JsonProperty("popoverText")
    public String getPopoverText() {
        return popoverText;
    }

    @JsonProperty("popoverText")
    public void setPopoverText(String popoverText) {
        this.popoverText = popoverText;
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
