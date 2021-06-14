
package observer.application.service.source.allegro.model.listing;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "activeVariant"
})
@Generated("jsonschema2pojo")
public class MotoCompatibilityFilter {

    @JsonProperty("activeVariant")
    private Object activeVariant;

    /**
     * No args constructor for use in serialization
     * 
     */
    public MotoCompatibilityFilter() {
    }

    /**
     * 
     * @param activeVariant
     */
    public MotoCompatibilityFilter(Object activeVariant) {
        super();
        this.activeVariant = activeVariant;
    }

    @JsonProperty("activeVariant")
    public Object getActiveVariant() {
        return activeVariant;
    }

    @JsonProperty("activeVariant")
    public void setActiveVariant(Object activeVariant) {
        this.activeVariant = activeVariant;
    }

}
