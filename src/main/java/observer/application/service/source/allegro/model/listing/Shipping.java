
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
    "freeDelivery",
    "freeReturn",
    "lowest",
    "itemWithDelivery",
    "summary"
})
@Generated("jsonschema2pojo")
public class Shipping {

    @JsonProperty("freeDelivery")
    private Boolean freeDelivery;
    @JsonProperty("freeReturn")
    private Boolean freeReturn;
    @JsonProperty("lowest")
    private Lowest lowest;
    @JsonProperty("itemWithDelivery")
    private ItemWithDelivery itemWithDelivery;
    @JsonProperty("summary")
    private Summary summary;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Shipping() {
    }

    /**
     * 
     * @param summary
     * @param freeReturn
     * @param itemWithDelivery
     * @param freeDelivery
     * @param lowest
     */
    public Shipping(Boolean freeDelivery, Boolean freeReturn, Lowest lowest, ItemWithDelivery itemWithDelivery, Summary summary) {
        super();
        this.freeDelivery = freeDelivery;
        this.freeReturn = freeReturn;
        this.lowest = lowest;
        this.itemWithDelivery = itemWithDelivery;
        this.summary = summary;
    }

    @JsonProperty("freeDelivery")
    public Boolean getFreeDelivery() {
        return freeDelivery;
    }

    @JsonProperty("freeDelivery")
    public void setFreeDelivery(Boolean freeDelivery) {
        this.freeDelivery = freeDelivery;
    }

    @JsonProperty("freeReturn")
    public Boolean getFreeReturn() {
        return freeReturn;
    }

    @JsonProperty("freeReturn")
    public void setFreeReturn(Boolean freeReturn) {
        this.freeReturn = freeReturn;
    }

    @JsonProperty("lowest")
    public Lowest getLowest() {
        return lowest;
    }

    @JsonProperty("lowest")
    public void setLowest(Lowest lowest) {
        this.lowest = lowest;
    }

    @JsonProperty("itemWithDelivery")
    public ItemWithDelivery getItemWithDelivery() {
        return itemWithDelivery;
    }

    @JsonProperty("itemWithDelivery")
    public void setItemWithDelivery(ItemWithDelivery itemWithDelivery) {
        this.itemWithDelivery = itemWithDelivery;
    }

    @JsonProperty("summary")
    public Summary getSummary() {
        return summary;
    }

    @JsonProperty("summary")
    public void setSummary(Summary summary) {
        this.summary = summary;
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
