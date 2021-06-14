
package observer.application.service.source.allegro.model.listing;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "name",
    "alias"
})
@Generated("jsonschema2pojo")
public class Path {

    @JsonProperty("id")
    private String id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("alias")
    private String alias;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Path() {
    }

    /**
     * 
     * @param name
     * @param alias
     * @param id
     */
    public Path(String id, String name, String alias) {
        super();
        this.id = id;
        this.name = name;
        this.alias = alias;
    }

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("alias")
    public String getAlias() {
        return alias;
    }

    @JsonProperty("alias")
    public void setAlias(String alias) {
        this.alias = alias;
    }

}
