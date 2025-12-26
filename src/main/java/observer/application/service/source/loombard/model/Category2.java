package observer.application.service.source.loombard.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class Category2 {
    int id;
    String category_id;
    String name;
    String slug;
    String parent;
    int leaf;
    Options options;
    Date created_at;
    Date updated_at;
    int warranty;
    int is_archived;

    @JsonProperty("id")
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @JsonProperty("category_id")
    public String getCategory_id() {
        return this.category_id;
    }

    public void setCategory_id(String category_id) {
        this.category_id = category_id;
    }

    @JsonProperty("name")
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("slug")
    public String getSlug() {
        return this.slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    @JsonProperty("parent")
    public String getParent() {
        return this.parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    @JsonProperty("leaf")
    public int getLeaf() {
        return this.leaf;
    }

    public void setLeaf(int leaf) {
        this.leaf = leaf;
    }

    @JsonProperty("options")
    public Options getOptions() {
        return this.options;
    }

    public void setOptions(Options options) {
        this.options = options;
    }

    @JsonProperty("created_at")
    public Date getCreated_at() {
        return this.created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    @JsonProperty("updated_at")
    public Date getUpdated_at() {
        return this.updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }

    @JsonProperty("warranty")
    public int getWarranty() {
        return this.warranty;
    }

    public void setWarranty(int warranty) {
        this.warranty = warranty;
    }

    @JsonProperty("is_archived")
    public int getIs_archived() {
        return this.is_archived;
    }

    public void setIs_archived(int is_archived) {
        this.is_archived = is_archived;
    }
}
