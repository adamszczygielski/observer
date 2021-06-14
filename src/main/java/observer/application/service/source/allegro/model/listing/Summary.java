
package observer.application.service.source.allegro.model.listing;

import java.util.List;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "labels"
})
@Generated("jsonschema2pojo")
public class Summary {

    @JsonProperty("labels")
    private List<Label> labels = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Summary() {
    }

    /**
     * 
     * @param labels
     */
    public Summary(List<Label> labels) {
        super();
        this.labels = labels;
    }

    @JsonProperty("labels")
    public List<Label> getLabels() {
        return labels;
    }

    @JsonProperty("labels")
    public void setLabels(List<Label> labels) {
        this.labels = labels;
    }

}
