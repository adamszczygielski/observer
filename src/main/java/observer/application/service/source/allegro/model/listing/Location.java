
package observer.application.service.source.allegro.model.listing;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "city",
    "popover"
})
@Generated("jsonschema2pojo")
public class Location {

    @JsonProperty("city")
    private String city;
    @JsonProperty("popover")
    private Popover popover;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Location() {
    }

    /**
     * 
     * @param city
     * @param popover
     */
    public Location(String city, Popover popover) {
        super();
        this.city = city;
        this.popover = popover;
    }

    @JsonProperty("city")
    public String getCity() {
        return city;
    }

    @JsonProperty("city")
    public void setCity(String city) {
        this.city = city;
    }

    @JsonProperty("popover")
    public Popover getPopover() {
        return popover;
    }

    @JsonProperty("popover")
    public void setPopover(Popover popover) {
        this.popover = popover;
    }

}
