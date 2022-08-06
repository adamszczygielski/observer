package observer.application.service.source.olx.model;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.annotation.Generated;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "budget",
        "free",
        "exchange",
        "regularPrice"
})
@Generated("jsonschema2pojo")
public class Price {

    @JsonProperty("budget")
    private Boolean budget;
    @JsonProperty("free")
    private Boolean free;
    @JsonProperty("exchange")
    private Boolean exchange;
    @JsonProperty("regularPrice")
    private RegularPrice regularPrice;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("budget")
    public Boolean getBudget() {
        return budget;
    }

    @JsonProperty("budget")
    public void setBudget(Boolean budget) {
        this.budget = budget;
    }

    @JsonProperty("free")
    public Boolean getFree() {
        return free;
    }

    @JsonProperty("free")
    public void setFree(Boolean free) {
        this.free = free;
    }

    @JsonProperty("exchange")
    public Boolean getExchange() {
        return exchange;
    }

    @JsonProperty("exchange")
    public void setExchange(Boolean exchange) {
        this.exchange = exchange;
    }

    @JsonProperty("regularPrice")
    public RegularPrice getRegularPrice() {
        return regularPrice;
    }

    @JsonProperty("regularPrice")
    public void setRegularPrice(RegularPrice regularPrice) {
        this.regularPrice = regularPrice;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
