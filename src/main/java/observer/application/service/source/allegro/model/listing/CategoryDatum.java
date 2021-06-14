
package observer.application.service.source.allegro.model.listing;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "alias",
    "name",
    "count",
    "hasChildren"
})
@Generated("jsonschema2pojo")
public class CategoryDatum {

    @JsonProperty("id")
    private String id;
    @JsonProperty("alias")
    private String alias;
    @JsonProperty("name")
    private String name;
    @JsonProperty("count")
    private Integer count;
    @JsonProperty("hasChildren")
    private Boolean hasChildren;

    /**
     * No args constructor for use in serialization
     * 
     */
    public CategoryDatum() {
    }

    /**
     * 
     * @param hasChildren
     * @param name
     * @param count
     * @param alias
     * @param id
     */
    public CategoryDatum(String id, String alias, String name, Integer count, Boolean hasChildren) {
        super();
        this.id = id;
        this.alias = alias;
        this.name = name;
        this.count = count;
        this.hasChildren = hasChildren;
    }

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("alias")
    public String getAlias() {
        return alias;
    }

    @JsonProperty("alias")
    public void setAlias(String alias) {
        this.alias = alias;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("count")
    public Integer getCount() {
        return count;
    }

    @JsonProperty("count")
    public void setCount(Integer count) {
        this.count = count;
    }

    @JsonProperty("hasChildren")
    public Boolean getHasChildren() {
        return hasChildren;
    }

    @JsonProperty("hasChildren")
    public void setHasChildren(Boolean hasChildren) {
        this.hasChildren = hasChildren;
    }

}
