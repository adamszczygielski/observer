
package observer.application.service.source.allegro.model.listing;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "text",
    "type"
})
@Generated("jsonschema2pojo")
public class DeliveryInfo {

    @JsonProperty("text")
    private String text;
    @JsonProperty("type")
    private String type;

    /**
     * No args constructor for use in serialization
     * 
     */
    public DeliveryInfo() {
    }

    /**
     * 
     * @param text
     * @param type
     */
    public DeliveryInfo(String text, String type) {
        super();
        this.text = text;
        this.type = type;
    }

    @JsonProperty("text")
    public String getText() {
        return text;
    }

    @JsonProperty("text")
    public void setText(String text) {
        this.text = text;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

}
