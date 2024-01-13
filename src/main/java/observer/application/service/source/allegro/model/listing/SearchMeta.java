
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
    "availableCount",
    "productsCount",
    "totalCount",
    "totalOffersCountForProductization",
    "lastAvailablePage",
    "appliedFiltersCount",
    "type",
    "scenario",
    "resultSetTooLarge",
    "productsListing",
    "containsEroticOffer",
    "searchId",
    "productNavigationEnabled",
    "softProductizationEnabled",
    "experimentsMap",
    "listingId",
    "isBetterSort",
    "isProductFlowAvailable"
})
@Generated("jsonschema2pojo")
public class SearchMeta {

    @JsonProperty("availableCount")
    private Integer availableCount;
    @JsonProperty("productsCount")
    private Integer productsCount;
    @JsonProperty("totalCount")
    private Integer totalCount;
    @JsonProperty("totalOffersCountForProductization")
    private Integer totalOffersCountForProductization;
    @JsonProperty("lastAvailablePage")
    private Integer lastAvailablePage;
    @JsonProperty("appliedFiltersCount")
    private Integer appliedFiltersCount;
    @JsonProperty("type")
    private String type;
    @JsonProperty("scenario")
    private String scenario;
    @JsonProperty("resultSetTooLarge")
    private Boolean resultSetTooLarge;
    @JsonProperty("productsListing")
    private Boolean productsListing;
    @JsonProperty("containsEroticOffer")
    private Boolean containsEroticOffer;
    @JsonProperty("searchId")
    private String searchId;
    @JsonProperty("productNavigationEnabled")
    private Boolean productNavigationEnabled;
    @JsonProperty("softProductizationEnabled")
    private Boolean softProductizationEnabled;
    @JsonProperty("experimentsMap")
    private ExperimentsMap experimentsMap;
    @JsonProperty("listingId")
    private String listingId;
    @JsonProperty("isBetterSort")
    private Boolean isBetterSort;
    @JsonProperty("isProductFlowAvailable")
    private Boolean isProductFlowAvailable;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public SearchMeta() {
    }

    /**
     * 
     * @param availableCount
     * @param experimentsMap
     * @param lastAvailablePage
     * @param productNavigationEnabled
     * @param listingId
     * @param totalCount
     * @param type
     * @param resultSetTooLarge
     * @param isBetterSort
     * @param searchId
     * @param scenario
     * @param containsEroticOffer
     * @param appliedFiltersCount
     * @param softProductizationEnabled
     * @param productsCount
     * @param totalOffersCountForProductization
     * @param productsListing
     * @param isProductFlowAvailable
     */
    public SearchMeta(Integer availableCount, Integer productsCount, Integer totalCount, Integer totalOffersCountForProductization, Integer lastAvailablePage, Integer appliedFiltersCount, String type, String scenario, Boolean resultSetTooLarge, Boolean productsListing, Boolean containsEroticOffer, String searchId, Boolean productNavigationEnabled, Boolean softProductizationEnabled, ExperimentsMap experimentsMap, String listingId, Boolean isBetterSort, Boolean isProductFlowAvailable) {
        super();
        this.availableCount = availableCount;
        this.productsCount = productsCount;
        this.totalCount = totalCount;
        this.totalOffersCountForProductization = totalOffersCountForProductization;
        this.lastAvailablePage = lastAvailablePage;
        this.appliedFiltersCount = appliedFiltersCount;
        this.type = type;
        this.scenario = scenario;
        this.resultSetTooLarge = resultSetTooLarge;
        this.productsListing = productsListing;
        this.containsEroticOffer = containsEroticOffer;
        this.searchId = searchId;
        this.productNavigationEnabled = productNavigationEnabled;
        this.softProductizationEnabled = softProductizationEnabled;
        this.experimentsMap = experimentsMap;
        this.listingId = listingId;
        this.isBetterSort = isBetterSort;
        this.isProductFlowAvailable = isProductFlowAvailable;
    }

    @JsonProperty("availableCount")
    public Integer getAvailableCount() {
        return availableCount;
    }

    @JsonProperty("availableCount")
    public void setAvailableCount(Integer availableCount) {
        this.availableCount = availableCount;
    }

    @JsonProperty("productsCount")
    public Integer getProductsCount() {
        return productsCount;
    }

    @JsonProperty("productsCount")
    public void setProductsCount(Integer productsCount) {
        this.productsCount = productsCount;
    }

    @JsonProperty("totalCount")
    public Integer getTotalCount() {
        return totalCount;
    }

    @JsonProperty("totalCount")
    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    @JsonProperty("totalOffersCountForProductization")
    public Integer getTotalOffersCountForProductization() {
        return totalOffersCountForProductization;
    }

    @JsonProperty("totalOffersCountForProductization")
    public void setTotalOffersCountForProductization(Integer totalOffersCountForProductization) {
        this.totalOffersCountForProductization = totalOffersCountForProductization;
    }

    @JsonProperty("lastAvailablePage")
    public Integer getLastAvailablePage() {
        return lastAvailablePage;
    }

    @JsonProperty("lastAvailablePage")
    public void setLastAvailablePage(Integer lastAvailablePage) {
        this.lastAvailablePage = lastAvailablePage;
    }

    @JsonProperty("appliedFiltersCount")
    public Integer getAppliedFiltersCount() {
        return appliedFiltersCount;
    }

    @JsonProperty("appliedFiltersCount")
    public void setAppliedFiltersCount(Integer appliedFiltersCount) {
        this.appliedFiltersCount = appliedFiltersCount;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("scenario")
    public String getScenario() {
        return scenario;
    }

    @JsonProperty("scenario")
    public void setScenario(String scenario) {
        this.scenario = scenario;
    }

    @JsonProperty("resultSetTooLarge")
    public Boolean getResultSetTooLarge() {
        return resultSetTooLarge;
    }

    @JsonProperty("resultSetTooLarge")
    public void setResultSetTooLarge(Boolean resultSetTooLarge) {
        this.resultSetTooLarge = resultSetTooLarge;
    }

    @JsonProperty("productsListing")
    public Boolean getProductsListing() {
        return productsListing;
    }

    @JsonProperty("productsListing")
    public void setProductsListing(Boolean productsListing) {
        this.productsListing = productsListing;
    }

    @JsonProperty("containsEroticOffer")
    public Boolean getContainsEroticOffer() {
        return containsEroticOffer;
    }

    @JsonProperty("containsEroticOffer")
    public void setContainsEroticOffer(Boolean containsEroticOffer) {
        this.containsEroticOffer = containsEroticOffer;
    }

    @JsonProperty("searchId")
    public String getSearchId() {
        return searchId;
    }

    @JsonProperty("searchId")
    public void setSearchId(String searchId) {
        this.searchId = searchId;
    }

    @JsonProperty("productNavigationEnabled")
    public Boolean getProductNavigationEnabled() {
        return productNavigationEnabled;
    }

    @JsonProperty("productNavigationEnabled")
    public void setProductNavigationEnabled(Boolean productNavigationEnabled) {
        this.productNavigationEnabled = productNavigationEnabled;
    }

    @JsonProperty("softProductizationEnabled")
    public Boolean getSoftProductizationEnabled() {
        return softProductizationEnabled;
    }

    @JsonProperty("softProductizationEnabled")
    public void setSoftProductizationEnabled(Boolean softProductizationEnabled) {
        this.softProductizationEnabled = softProductizationEnabled;
    }

    @JsonProperty("experimentsMap")
    public ExperimentsMap getExperimentsMap() {
        return experimentsMap;
    }

    @JsonProperty("experimentsMap")
    public void setExperimentsMap(ExperimentsMap experimentsMap) {
        this.experimentsMap = experimentsMap;
    }

    @JsonProperty("listingId")
    public String getListingId() {
        return listingId;
    }

    @JsonProperty("listingId")
    public void setListingId(String listingId) {
        this.listingId = listingId;
    }

    @JsonProperty("isBetterSort")
    public Boolean getIsBetterSort() {
        return isBetterSort;
    }

    @JsonProperty("isBetterSort")
    public void setIsBetterSort(Boolean isBetterSort) {
        this.isBetterSort = isBetterSort;
    }

    @JsonProperty("isProductFlowAvailable")
    public Boolean getIsProductFlowAvailable() {
        return isProductFlowAvailable;
    }

    @JsonProperty("isProductFlowAvailable")
    public void setIsProductFlowAvailable(Boolean isProductFlowAvailable) {
        this.isProductFlowAvailable = isProductFlowAvailable;
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
