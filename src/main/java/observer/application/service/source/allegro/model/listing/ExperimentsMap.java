
package observer.application.service.source.allegro.model.listing;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "front-productization-long"
})
@Generated("jsonschema2pojo")
public class ExperimentsMap {

    @JsonProperty("front-productization-long")
    private String frontProductizationLong;

    /**
     * No args constructor for use in serialization
     * 
     */
    public ExperimentsMap() {
    }

    /**
     * 
     * @param frontProductizationLong
     */
    public ExperimentsMap(String frontProductizationLong) {
        super();
        this.frontProductizationLong = frontProductizationLong;
    }

    @JsonProperty("front-productization-long")
    public String getFrontProductizationLong() {
        return frontProductizationLong;
    }

    @JsonProperty("front-productization-long")
    public void setFrontProductizationLong(String frontProductizationLong) {
        this.frontProductizationLong = frontProductizationLong;
    }

}
