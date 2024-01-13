
package observer.application.service.source.allegro.model.listing;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.Generated;
import java.util.LinkedHashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "listingType",
    "__listing_StoreState"
})
@Generated("jsonschema2pojo")
public class ListingResponse {

    @JsonProperty("listingType")
    private String listingType;
    @JsonProperty("__listing_StoreState")
    private ListingStoreState listingStoreState;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public ListingResponse() {
    }

    /**
     * 
     * @param listingStoreState
     * @param listingType
     */
    public ListingResponse(String listingType, ListingStoreState listingStoreState) {
        super();
        this.listingType = listingType;
        this.listingStoreState = listingStoreState;
    }

    @JsonProperty("listingType")
    public String getListingType() {
        return listingType;
    }

    @JsonProperty("listingType")
    public void setListingType(String listingType) {
        this.listingType = listingType;
    }

    @JsonProperty("__listing_StoreState")
    public ListingStoreState getListingStoreState() {
        return listingStoreState;
    }

    @JsonProperty("__listing_StoreState")
    public void setListingStoreState(ListingStoreState listingStoreState) {
        this.listingStoreState = listingStoreState;
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
