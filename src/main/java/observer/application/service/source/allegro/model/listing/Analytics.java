
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
    "itemView"
})
@Generated("jsonschema2pojo")
public class Analytics {

    @JsonProperty("itemView")
    private List<ItemView> itemView = new ArrayList<ItemView>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Analytics() {
    }

    /**
     * 
     * @param itemView
     */
    public Analytics(List<ItemView> itemView) {
        super();
        this.itemView = itemView;
    }

    @JsonProperty("itemView")
    public List<ItemView> getItemView() {
        return itemView;
    }

    @JsonProperty("itemView")
    public void setItemView(List<ItemView> itemView) {
        this.itemView = itemView;
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
