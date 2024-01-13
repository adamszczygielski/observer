
package observer.application.service.source.allegro.model.listing;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
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
    "aboveTheFoldCount",
    "items",
    "observed",
    "operationalCountry",
    "marketplaceId",
    "isAuthenticated",
    "searchId",
    "sendPageViewEvent",
    "shouldSendPerformanceMetrics",
    "userData",
    "isItemPreviewEnabled",
    "isMweb",
    "variantsVisible",
    "nonce",
    "interlines",
    "interlinesAtTheEnd",
    "isDarkModeSupported",
    "hideSponsoredDataAttributes"
})
@Generated("jsonschema2pojo")
public class ListingStoreState {

    @JsonProperty("aboveTheFoldCount")
    private Integer aboveTheFoldCount;
    @JsonProperty("items")
    private Items items;
    @JsonProperty("observed")
    private Observed observed;
    @JsonProperty("operationalCountry")
    private String operationalCountry;
    @JsonProperty("marketplaceId")
    private String marketplaceId;
    @JsonProperty("isAuthenticated")
    private Boolean isAuthenticated;
    @JsonProperty("searchId")
    private String searchId;
    @JsonProperty("sendPageViewEvent")
    private Boolean sendPageViewEvent;
    @JsonProperty("shouldSendPerformanceMetrics")
    private Boolean shouldSendPerformanceMetrics;
    @JsonProperty("userData")
    private UserData userData;
    @JsonProperty("isItemPreviewEnabled")
    private Boolean isItemPreviewEnabled;
    @JsonProperty("isMweb")
    private Boolean isMweb;
    @JsonProperty("variantsVisible")
    private Boolean variantsVisible;
    @JsonProperty("nonce")
    private String nonce;
    @JsonProperty("interlines")
    private Interlines interlines;
    @JsonProperty("interlinesAtTheEnd")
    private List<InterlinesAtTheEnd> interlinesAtTheEnd = new ArrayList<InterlinesAtTheEnd>();
    @JsonProperty("isDarkModeSupported")
    private Boolean isDarkModeSupported;
    @JsonProperty("hideSponsoredDataAttributes")
    private Boolean hideSponsoredDataAttributes;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public ListingStoreState() {
    }

    /**
     * 
     * @param userData
     * @param isItemPreviewEnabled
     * @param aboveTheFoldCount
     * @param variantsVisible
     * @param operationalCountry
     * @param isAuthenticated
     * @param nonce
     * @param observed
     * @param marketplaceId
     * @param isDarkModeSupported
     * @param interlines
     * @param searchId
     * @param isMweb
     * @param sendPageViewEvent
     * @param items
     * @param shouldSendPerformanceMetrics
     * @param interlinesAtTheEnd
     * @param hideSponsoredDataAttributes
     */
    public ListingStoreState(Integer aboveTheFoldCount, Items items, Observed observed, String operationalCountry, String marketplaceId, Boolean isAuthenticated, String searchId, Boolean sendPageViewEvent, Boolean shouldSendPerformanceMetrics, UserData userData, Boolean isItemPreviewEnabled, Boolean isMweb, Boolean variantsVisible, String nonce, Interlines interlines, List<InterlinesAtTheEnd> interlinesAtTheEnd, Boolean isDarkModeSupported, Boolean hideSponsoredDataAttributes) {
        super();
        this.aboveTheFoldCount = aboveTheFoldCount;
        this.items = items;
        this.observed = observed;
        this.operationalCountry = operationalCountry;
        this.marketplaceId = marketplaceId;
        this.isAuthenticated = isAuthenticated;
        this.searchId = searchId;
        this.sendPageViewEvent = sendPageViewEvent;
        this.shouldSendPerformanceMetrics = shouldSendPerformanceMetrics;
        this.userData = userData;
        this.isItemPreviewEnabled = isItemPreviewEnabled;
        this.isMweb = isMweb;
        this.variantsVisible = variantsVisible;
        this.nonce = nonce;
        this.interlines = interlines;
        this.interlinesAtTheEnd = interlinesAtTheEnd;
        this.isDarkModeSupported = isDarkModeSupported;
        this.hideSponsoredDataAttributes = hideSponsoredDataAttributes;
    }

    @JsonProperty("aboveTheFoldCount")
    public Integer getAboveTheFoldCount() {
        return aboveTheFoldCount;
    }

    @JsonProperty("aboveTheFoldCount")
    public void setAboveTheFoldCount(Integer aboveTheFoldCount) {
        this.aboveTheFoldCount = aboveTheFoldCount;
    }

    @JsonProperty("items")
    public Items getItems() {
        return items;
    }

    @JsonProperty("items")
    public void setItems(Items items) {
        this.items = items;
    }

    @JsonProperty("observed")
    public Observed getObserved() {
        return observed;
    }

    @JsonProperty("observed")
    public void setObserved(Observed observed) {
        this.observed = observed;
    }

    @JsonProperty("operationalCountry")
    public String getOperationalCountry() {
        return operationalCountry;
    }

    @JsonProperty("operationalCountry")
    public void setOperationalCountry(String operationalCountry) {
        this.operationalCountry = operationalCountry;
    }

    @JsonProperty("marketplaceId")
    public String getMarketplaceId() {
        return marketplaceId;
    }

    @JsonProperty("marketplaceId")
    public void setMarketplaceId(String marketplaceId) {
        this.marketplaceId = marketplaceId;
    }

    @JsonProperty("isAuthenticated")
    public Boolean getIsAuthenticated() {
        return isAuthenticated;
    }

    @JsonProperty("isAuthenticated")
    public void setIsAuthenticated(Boolean isAuthenticated) {
        this.isAuthenticated = isAuthenticated;
    }

    @JsonProperty("searchId")
    public String getSearchId() {
        return searchId;
    }

    @JsonProperty("searchId")
    public void setSearchId(String searchId) {
        this.searchId = searchId;
    }

    @JsonProperty("sendPageViewEvent")
    public Boolean getSendPageViewEvent() {
        return sendPageViewEvent;
    }

    @JsonProperty("sendPageViewEvent")
    public void setSendPageViewEvent(Boolean sendPageViewEvent) {
        this.sendPageViewEvent = sendPageViewEvent;
    }

    @JsonProperty("shouldSendPerformanceMetrics")
    public Boolean getShouldSendPerformanceMetrics() {
        return shouldSendPerformanceMetrics;
    }

    @JsonProperty("shouldSendPerformanceMetrics")
    public void setShouldSendPerformanceMetrics(Boolean shouldSendPerformanceMetrics) {
        this.shouldSendPerformanceMetrics = shouldSendPerformanceMetrics;
    }

    @JsonProperty("userData")
    public UserData getUserData() {
        return userData;
    }

    @JsonProperty("userData")
    public void setUserData(UserData userData) {
        this.userData = userData;
    }

    @JsonProperty("isItemPreviewEnabled")
    public Boolean getIsItemPreviewEnabled() {
        return isItemPreviewEnabled;
    }

    @JsonProperty("isItemPreviewEnabled")
    public void setIsItemPreviewEnabled(Boolean isItemPreviewEnabled) {
        this.isItemPreviewEnabled = isItemPreviewEnabled;
    }

    @JsonProperty("isMweb")
    public Boolean getIsMweb() {
        return isMweb;
    }

    @JsonProperty("isMweb")
    public void setIsMweb(Boolean isMweb) {
        this.isMweb = isMweb;
    }

    @JsonProperty("variantsVisible")
    public Boolean getVariantsVisible() {
        return variantsVisible;
    }

    @JsonProperty("variantsVisible")
    public void setVariantsVisible(Boolean variantsVisible) {
        this.variantsVisible = variantsVisible;
    }

    @JsonProperty("nonce")
    public String getNonce() {
        return nonce;
    }

    @JsonProperty("nonce")
    public void setNonce(String nonce) {
        this.nonce = nonce;
    }

    @JsonProperty("interlines")
    public Interlines getInterlines() {
        return interlines;
    }

    @JsonProperty("interlines")
    public void setInterlines(Interlines interlines) {
        this.interlines = interlines;
    }

    @JsonProperty("interlinesAtTheEnd")
    public List<InterlinesAtTheEnd> getInterlinesAtTheEnd() {
        return interlinesAtTheEnd;
    }

    @JsonProperty("interlinesAtTheEnd")
    public void setInterlinesAtTheEnd(List<InterlinesAtTheEnd> interlinesAtTheEnd) {
        this.interlinesAtTheEnd = interlinesAtTheEnd;
    }

    @JsonProperty("isDarkModeSupported")
    public Boolean getIsDarkModeSupported() {
        return isDarkModeSupported;
    }

    @JsonProperty("isDarkModeSupported")
    public void setIsDarkModeSupported(Boolean isDarkModeSupported) {
        this.isDarkModeSupported = isDarkModeSupported;
    }

    @JsonProperty("hideSponsoredDataAttributes")
    public Boolean getHideSponsoredDataAttributes() {
        return hideSponsoredDataAttributes;
    }

    @JsonProperty("hideSponsoredDataAttributes")
    public void setHideSponsoredDataAttributes(Boolean hideSponsoredDataAttributes) {
        this.hideSponsoredDataAttributes = hideSponsoredDataAttributes;
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
