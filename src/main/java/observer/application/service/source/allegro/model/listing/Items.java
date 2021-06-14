
package observer.application.service.source.allegro.model.listing;

import java.util.List;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "elements",
    "showUserSellsNothingMessage",
    "pageUrl",
    "order",
    "searchMeta",
    "categoryData",
    "searchPhrase",
    "listingType",
    "filtersToClean"
})
@Generated("jsonschema2pojo")
public class Items {

    @JsonProperty("elements")
    private List<Element> elements = null;
    @JsonProperty("showUserSellsNothingMessage")
    private Boolean showUserSellsNothingMessage;
    @JsonProperty("pageUrl")
    private String pageUrl;
    @JsonProperty("order")
    private String order;
    @JsonProperty("searchMeta")
    private SearchMeta searchMeta;
    @JsonProperty("categoryData")
    private List<CategoryDatum> categoryData = null;
    @JsonProperty("searchPhrase")
    private String searchPhrase;
    @JsonProperty("listingType")
    private String listingType;
    @JsonProperty("filtersToClean")
    private List<Object> filtersToClean = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Items() {
    }

    /**
     * 
     * @param showUserSellsNothingMessage
     * @param filtersToClean
     * @param searchPhrase
     * @param elements
     * @param categoryData
     * @param listingType
     * @param pageUrl
     * @param searchMeta
     * @param order
     */
    public Items(List<Element> elements, Boolean showUserSellsNothingMessage, String pageUrl, String order, SearchMeta searchMeta, List<CategoryDatum> categoryData, String searchPhrase, String listingType, List<Object> filtersToClean) {
        super();
        this.elements = elements;
        this.showUserSellsNothingMessage = showUserSellsNothingMessage;
        this.pageUrl = pageUrl;
        this.order = order;
        this.searchMeta = searchMeta;
        this.categoryData = categoryData;
        this.searchPhrase = searchPhrase;
        this.listingType = listingType;
        this.filtersToClean = filtersToClean;
    }

    @JsonProperty("elements")
    public List<Element> getElements() {
        return elements;
    }

    @JsonProperty("elements")
    public void setElements(List<Element> elements) {
        this.elements = elements;
    }

    @JsonProperty("showUserSellsNothingMessage")
    public Boolean getShowUserSellsNothingMessage() {
        return showUserSellsNothingMessage;
    }

    @JsonProperty("showUserSellsNothingMessage")
    public void setShowUserSellsNothingMessage(Boolean showUserSellsNothingMessage) {
        this.showUserSellsNothingMessage = showUserSellsNothingMessage;
    }

    @JsonProperty("pageUrl")
    public String getPageUrl() {
        return pageUrl;
    }

    @JsonProperty("pageUrl")
    public void setPageUrl(String pageUrl) {
        this.pageUrl = pageUrl;
    }

    @JsonProperty("order")
    public String getOrder() {
        return order;
    }

    @JsonProperty("order")
    public void setOrder(String order) {
        this.order = order;
    }

    @JsonProperty("searchMeta")
    public SearchMeta getSearchMeta() {
        return searchMeta;
    }

    @JsonProperty("searchMeta")
    public void setSearchMeta(SearchMeta searchMeta) {
        this.searchMeta = searchMeta;
    }

    @JsonProperty("categoryData")
    public List<CategoryDatum> getCategoryData() {
        return categoryData;
    }

    @JsonProperty("categoryData")
    public void setCategoryData(List<CategoryDatum> categoryData) {
        this.categoryData = categoryData;
    }

    @JsonProperty("searchPhrase")
    public String getSearchPhrase() {
        return searchPhrase;
    }

    @JsonProperty("searchPhrase")
    public void setSearchPhrase(String searchPhrase) {
        this.searchPhrase = searchPhrase;
    }

    @JsonProperty("listingType")
    public String getListingType() {
        return listingType;
    }

    @JsonProperty("listingType")
    public void setListingType(String listingType) {
        this.listingType = listingType;
    }

    @JsonProperty("filtersToClean")
    public List<Object> getFiltersToClean() {
        return filtersToClean;
    }

    @JsonProperty("filtersToClean")
    public void setFiltersToClean(List<Object> filtersToClean) {
        this.filtersToClean = filtersToClean;
    }

}
