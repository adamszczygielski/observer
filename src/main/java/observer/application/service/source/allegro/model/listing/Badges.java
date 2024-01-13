
package observer.application.service.source.allegro.model.listing;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "installments",
    "logistics"
})
@Generated("jsonschema2pojo")
public class Badges {

    @JsonProperty("installments")
    private Installments installments;
    @JsonProperty("logistics")
    private Logistics logistics;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Badges() {
    }

    /**
     * 
     * @param installments
     * @param logistics
     */
    public Badges(Installments installments, Logistics logistics) {
        super();
        this.installments = installments;
        this.logistics = logistics;
    }

    @JsonProperty("installments")
    public Installments getInstallments() {
        return installments;
    }

    @JsonProperty("installments")
    public void setInstallments(Installments installments) {
        this.installments = installments;
    }

    @JsonProperty("logistics")
    public Logistics getLogistics() {
        return logistics;
    }

    @JsonProperty("logistics")
    public void setLogistics(Logistics logistics) {
        this.logistics = logistics;
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
