package observer.application.service.source.olx.model;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.annotation.Generated;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "pageNumber",
        "totalElements",
        "totalPages",
        "ads"
})
@Generated("jsonschema2pojo")
public class ListingDetails {

    @JsonProperty("pageNumber")
    private Integer pageNumber;
    @JsonProperty("totalElements")
    private Integer totalElements;
    @JsonProperty("totalPages")
    private Integer totalPages;
    @JsonProperty("ads")
    private List<Ad> ads = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("pageNumber")
    public Integer getPageNumber() {
        return pageNumber;
    }

    @JsonProperty("pageNumber")
    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    @JsonProperty("totalElements")
    public Integer getTotalElements() {
        return totalElements;
    }

    @JsonProperty("totalElements")
    public void setTotalElements(Integer totalElements) {
        this.totalElements = totalElements;
    }

    @JsonProperty("totalPages")
    public Integer getTotalPages() {
        return totalPages;
    }

    @JsonProperty("totalPages")
    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    @JsonProperty("ads")
    public List<Ad> getAds() {
        return ads;
    }

    @JsonProperty("ads")
    public void setAds(List<Ad> ads) {
        this.ads = ads;
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
