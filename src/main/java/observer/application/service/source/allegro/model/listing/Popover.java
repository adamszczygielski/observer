
package observer.application.service.source.allegro.model.listing;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "text"
})
@Generated("jsonschema2pojo")
public class Popover {

    @JsonProperty("text")
    private String text;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Popover() {
    }

    /**
     * 
     * @param text
     */
    public Popover(String text) {
        super();
        this.text = text;
    }

    @JsonProperty("text")
    public String getText() {
        return text;
    }

    @JsonProperty("text")
    public void setText(String text) {
        this.text = text;
    }

}
