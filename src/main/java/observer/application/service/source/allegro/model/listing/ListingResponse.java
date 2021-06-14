
package observer.application.service.source.allegro.model.listing;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.annotation.Generated;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "aboveTheFoldCount",
    "items",
    "observed",
    "sendPageViewEvent",
    "shouldSendPerformanceMetrics",
    "userData"
})
@Generated("jsonschema2pojo")
public class ListingResponse {

    @JsonProperty("aboveTheFoldCount")
    private Integer aboveTheFoldCount;
    @JsonProperty("items")
    private Items items;
    @JsonProperty("observed")
    private Observed observed;
    @JsonProperty("sendPageViewEvent")
    private Boolean sendPageViewEvent;
    @JsonProperty("shouldSendPerformanceMetrics")
    private Boolean shouldSendPerformanceMetrics;
    @JsonProperty("userData")
    private UserData userData;

    /**
     * No args constructor for use in serialization
     * 
     */
    public ListingResponse() {
    }

    /**
     * 
     * @param userData
     * @param aboveTheFoldCount
     * @param sendPageViewEvent
     * @param items
     * @param shouldSendPerformanceMetrics
     * @param observed
     */
    public ListingResponse(Integer aboveTheFoldCount, Items items, Observed observed, Boolean sendPageViewEvent, Boolean shouldSendPerformanceMetrics, UserData userData) {
        super();
        this.aboveTheFoldCount = aboveTheFoldCount;
        this.items = items;
        this.observed = observed;
        this.sendPageViewEvent = sendPageViewEvent;
        this.shouldSendPerformanceMetrics = shouldSendPerformanceMetrics;
        this.userData = userData;
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

}
