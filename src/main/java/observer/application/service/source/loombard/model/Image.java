package observer.application.service.source.loombard.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Image {
    int id;
    int parent_id;
    String parent_type;
    String dir;
    String file;
    String title;
    Object alt;
    String dimensions;
    int main;
    int processed;
    Object created_at;
    Object updated_at;
    String url;
    String thumbUrl;
    String mdUrl;

    @JsonProperty("id")
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @JsonProperty("parent_id")
    public int getParent_id() {
        return this.parent_id;
    }

    public void setParent_id(int parent_id) {
        this.parent_id = parent_id;
    }

    @JsonProperty("parent_type")
    public String getParent_type() {
        return this.parent_type;
    }

    public void setParent_type(String parent_type) {
        this.parent_type = parent_type;
    }

    @JsonProperty("dir")
    public String getDir() {
        return this.dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    @JsonProperty("file")
    public String getFile() {
        return this.file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    @JsonProperty("title")
    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("alt")
    public Object getAlt() {
        return this.alt;
    }

    public void setAlt(Object alt) {
        this.alt = alt;
    }

    @JsonProperty("dimensions")
    public String getDimensions() {
        return this.dimensions;
    }

    public void setDimensions(String dimensions) {
        this.dimensions = dimensions;
    }

    @JsonProperty("main")
    public int getMain() {
        return this.main;
    }

    public void setMain(int main) {
        this.main = main;
    }

    @JsonProperty("processed")
    public int getProcessed() {
        return this.processed;
    }

    public void setProcessed(int processed) {
        this.processed = processed;
    }

    @JsonProperty("created_at")
    public Object getCreated_at() {
        return this.created_at;
    }

    public void setCreated_at(Object created_at) {
        this.created_at = created_at;
    }

    @JsonProperty("updated_at")
    public Object getUpdated_at() {
        return this.updated_at;
    }

    public void setUpdated_at(Object updated_at) {
        this.updated_at = updated_at;
    }

    @JsonProperty("url")
    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @JsonProperty("thumbUrl")
    public String getThumbUrl() {
        return this.thumbUrl;
    }

    public void setThumbUrl(String thumbUrl) {
        this.thumbUrl = thumbUrl;
    }

    @JsonProperty("mdUrl")
    public String getMdUrl() {
        return this.mdUrl;
    }

    public void setMdUrl(String mdUrl) {
        this.mdUrl = mdUrl;
    }
}
