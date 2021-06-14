
package observer.application.service.source.allegro.model.listing;

import java.util.List;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "path"
})
@Generated("jsonschema2pojo")
public class FiltersSuggestedCategory {

    @JsonProperty("path")
    private List<Path> path = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public FiltersSuggestedCategory() {
    }

    /**
     * 
     * @param path
     */
    public FiltersSuggestedCategory(List<Path> path) {
        super();
        this.path = path;
    }

    @JsonProperty("path")
    public List<Path> getPath() {
        return path;
    }

    @JsonProperty("path")
    public void setPath(List<Path> path) {
        this.path = path;
    }

}
