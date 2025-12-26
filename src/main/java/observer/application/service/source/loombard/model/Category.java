package observer.application.service.source.loombard.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Category {
    String id;
    String slug;
    String parent_id;
    String name;

    @JsonProperty("id")
    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("slug")
    public String getSlug() {
        return this.slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    @JsonProperty("parent_id")
    public String getParent_id() {
        return this.parent_id;
    }

    public void setParent_id(String parent_id) {
        this.parent_id = parent_id;
    }

    @JsonProperty("name")
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
