
package observer.application.service.source.allegro.model.listing;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "small",
    "medium"
})
@Generated("jsonschema2pojo")
public class Photo {

    @JsonProperty("small")
    private String small;
    @JsonProperty("medium")
    private String medium;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Photo() {
    }

    /**
     * 
     * @param small
     * @param medium
     */
    public Photo(String small, String medium) {
        super();
        this.small = small;
        this.medium = medium;
    }

    @JsonProperty("small")
    public String getSmall() {
        return small;
    }

    @JsonProperty("small")
    public void setSmall(String small) {
        this.small = small;
    }

    @JsonProperty("medium")
    public String getMedium() {
        return medium;
    }

    @JsonProperty("medium")
    public void setMedium(String medium) {
        this.medium = medium;
    }

}
