
package observer.application.service.source.allegro.model.listing;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "regularLabel",
    "charityLabel"
})
@Generated("jsonschema2pojo")
public class Labels {

    @JsonProperty("regularLabel")
    private Object regularLabel;
    @JsonProperty("charityLabel")
    private Object charityLabel;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Labels() {
    }

    /**
     * 
     * @param regularLabel
     * @param charityLabel
     */
    public Labels(Object regularLabel, Object charityLabel) {
        super();
        this.regularLabel = regularLabel;
        this.charityLabel = charityLabel;
    }

    @JsonProperty("regularLabel")
    public Object getRegularLabel() {
        return regularLabel;
    }

    @JsonProperty("regularLabel")
    public void setRegularLabel(Object regularLabel) {
        this.regularLabel = regularLabel;
    }

    @JsonProperty("charityLabel")
    public Object getCharityLabel() {
        return charityLabel;
    }

    @JsonProperty("charityLabel")
    public void setCharityLabel(Object charityLabel) {
        this.charityLabel = charityLabel;
    }

}
