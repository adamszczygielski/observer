package observer.application.service.source.loombard.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Parameter {
    String id;
    String value;

    @JsonProperty("id")
    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("value")
    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
