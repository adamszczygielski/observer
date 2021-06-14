
package observer.application.service.source.allegro.model.listing;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.annotation.Generated;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "text",
    "bold",
    "superSeller"
})
@Generated("jsonschema2pojo")
public class Title {

    @JsonProperty("text")
    private String text;
    @JsonProperty("bold")
    private Boolean bold;
    @JsonProperty("superSeller")
    private Boolean superSeller;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Title() {
    }

    /**
     * 
     * @param superSeller
     * @param text
     * @param bold
     */
    public Title(String text, Boolean bold, Boolean superSeller) {
        super();
        this.text = text;
        this.bold = bold;
        this.superSeller = superSeller;
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

    @JsonProperty("superSeller")
    public Boolean getSuperSeller() {
        return superSeller;
    }

    @JsonProperty("superSeller")
    public void setSuperSeller(Boolean superSeller) {
        this.superSeller = superSeller;
    }

}
