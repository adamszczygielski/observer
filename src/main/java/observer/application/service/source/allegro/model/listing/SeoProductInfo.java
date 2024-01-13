
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
    "productName",
    "productUrl",
    "isOpenInNewTab"
})
@Generated("jsonschema2pojo")
public class SeoProductInfo {

    @JsonProperty("productName")
    private String productName;
    @JsonProperty("productUrl")
    private String productUrl;
    @JsonProperty("isOpenInNewTab")
    private Boolean isOpenInNewTab;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public SeoProductInfo() {
    }

    /**
     * 
     * @param isOpenInNewTab
     * @param productUrl
     * @param productName
     */
    public SeoProductInfo(String productName, String productUrl, Boolean isOpenInNewTab) {
        super();
        this.productName = productName;
        this.productUrl = productUrl;
        this.isOpenInNewTab = isOpenInNewTab;
    }

    @JsonProperty("productName")
    public String getProductName() {
        return productName;
    }

    @JsonProperty("productName")
    public void setProductName(String productName) {
        this.productName = productName;
    }

    @JsonProperty("productUrl")
    public String getProductUrl() {
        return productUrl;
    }

    @JsonProperty("productUrl")
    public void setProductUrl(String productUrl) {
        this.productUrl = productUrl;
    }

    @JsonProperty("isOpenInNewTab")
    public Boolean getIsOpenInNewTab() {
        return isOpenInNewTab;
    }

    @JsonProperty("isOpenInNewTab")
    public void setIsOpenInNewTab(Boolean isOpenInNewTab) {
        this.isOpenInNewTab = isOpenInNewTab;
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
