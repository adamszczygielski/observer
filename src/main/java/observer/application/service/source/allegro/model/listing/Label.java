
package observer.application.service.source.allegro.model.listing;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "text",
    "bold"
})
@Generated("jsonschema2pojo")
public class Label {

    @JsonProperty("text")
    private String text;
    @JsonProperty("bold")
    private Boolean bold;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Label() {
    }

    /**
     * 
     * @param text
     * @param bold
     */
    public Label(String text, Boolean bold) {
        super();
        this.text = text;
        this.bold = bold;
    }

    @JsonProperty("text")
    public String getText() {
        return text;
    }

    @JsonProperty("text")
    public void setText(String text) {
        this.text = text;
    }

    @JsonProperty("bold")
    public Boolean getBold() {
        return bold;
    }

    @JsonProperty("bold")
    public void setBold(Boolean bold) {
        this.bold = bold;
    }

}
