
package observer.application.service.source.allegro.model.listing;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "normal"
})
@Generated("jsonschema2pojo")
public class Price {

    @JsonProperty("normal")
    private Normal normal;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Price() {
    }

    /**
     * 
     * @param normal
     */
    public Price(Normal normal) {
        super();
        this.normal = normal;
    }

    @JsonProperty("normal")
    public Normal getNormal() {
        return normal;
    }

    @JsonProperty("normal")
    public void setNormal(Normal normal) {
        this.normal = normal;
    }

}
