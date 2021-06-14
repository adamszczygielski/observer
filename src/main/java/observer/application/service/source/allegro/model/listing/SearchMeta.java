
package observer.application.service.source.allegro.model.listing;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "availableCount",
    "productsCount",
    "totalCount",
    "lastAvailablePage",
    "appliedFiltersCount",
    "type",
    "scenario",
    "resultSetTooLarge",
    "productsListing",
    "containsEroticOffer",
    "filtersSuggestedCategory",
    "searchId",
    "productNavigationEnabled",
    "softProductizationEnabled",
    "motoCompatibilityFilter",
    "experimentsMap",
    "listingId"
})
@Generated("jsonschema2pojo")
public class SearchMeta {

    @JsonProperty("availableCount")
    private Integer availableCount;
    @JsonProperty("productsCount")
    private Integer productsCount;
    @JsonProperty("totalCount")
    private Integer totalCount;
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
    @JsonProperty("filtersSuggestedCategory")
    private FiltersSuggestedCategory filtersSuggestedCategory;
    @JsonProperty("searchId")
    private String searchId;
    @JsonProperty("productNavigationEnabled")
    private Boolean productNavigationEnabled;
    @JsonProperty("softProductizationEnabled")
    private Boolean softProductizationEnabled;
    @JsonProperty("motoCompatibilityFilter")
    private MotoCompatibilityFilter motoCompatibilityFilter;
    @JsonProperty("experimentsMap")
    private ExperimentsMap experimentsMap;
    @JsonProperty("listingId")
    private String listingId;

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
     * @param filtersSuggestedCategory
     * @param productNavigationEnabled
     * @param listingId
     * @param totalCount
     * @param type
     * @param resultSetTooLarge
     * @param searchId
     * @param scenario
     * @param containsEroticOffer
     * @param appliedFiltersCount
     * @param softProductizationEnabled
     * @param productsCount
     * @param productsListing
     * @param motoCompatibilityFilter
     */
    public SearchMeta(Integer availableCount, Integer productsCount, Integer totalCount, Integer lastAvailablePage, Integer appliedFiltersCount, String type, String scenario, Boolean resultSetTooLarge, Boolean productsListing, Boolean containsEroticOffer, FiltersSuggestedCategory filtersSuggestedCategory, String searchId, Boolean productNavigationEnabled, Boolean softProductizationEnabled, MotoCompatibilityFilter motoCompatibilityFilter, ExperimentsMap experimentsMap, String listingId) {
        super();
        this.availableCount = availableCount;
        this.productsCount = productsCount;
        this.totalCount = totalCount;
        this.lastAvailablePage = lastAvailablePage;
        this.appliedFiltersCount = appliedFiltersCount;
        this.type = type;
        this.scenario = scenario;
        this.resultSetTooLarge = resultSetTooLarge;
        this.productsListing = productsListing;
        this.containsEroticOffer = containsEroticOffer;
        this.filtersSuggestedCategory = filtersSuggestedCategory;
        this.searchId = searchId;
        this.productNavigationEnabled = productNavigationEnabled;
        this.softProductizationEnabled = softProductizationEnabled;
        this.motoCompatibilityFilter = motoCompatibilityFilter;
        this.experimentsMap = experimentsMap;
        this.listingId = listingId;
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

    @JsonProperty("filtersSuggestedCategory")
    public FiltersSuggestedCategory getFiltersSuggestedCategory() {
        return filtersSuggestedCategory;
    }

    @JsonProperty("filtersSuggestedCategory")
    public void setFiltersSuggestedCategory(FiltersSuggestedCategory filtersSuggestedCategory) {
        this.filtersSuggestedCategory = filtersSuggestedCategory;
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

    @JsonProperty("motoCompatibilityFilter")
    public MotoCompatibilityFilter getMotoCompatibilityFilter() {
        return motoCompatibilityFilter;
    }

    @JsonProperty("motoCompatibilityFilter")
    public void setMotoCompatibilityFilter(MotoCompatibilityFilter motoCompatibilityFilter) {
        this.motoCompatibilityFilter = motoCompatibilityFilter;
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

}
