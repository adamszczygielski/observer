
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
    "id",
    "title",
    "superSeller",
    "login",
    "userListingUrl",
    "positiveFeedbackIcon",
    "company",
    "positiveFeedbackPercent"
})
@Generated("jsonschema2pojo")
public class Seller {

    @JsonProperty("id")
    private String id;
    @JsonProperty("title")
    private String title;
    @JsonProperty("superSeller")
    private Boolean superSeller;
    @JsonProperty("login")
    private String login;
    @JsonProperty("userListingUrl")
    private String userListingUrl;
    @JsonProperty("positiveFeedbackIcon")
    private Boolean positiveFeedbackIcon;
    @JsonProperty("company")
    private Boolean company;
    @JsonProperty("positiveFeedbackPercent")
    private Integer positiveFeedbackPercent;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Seller() {
    }

    /**
     * 
     * @param positiveFeedbackPercent
     * @param superSeller
     * @param positiveFeedbackIcon
     * @param company
     * @param id
     * @param title
     * @param login
     * @param userListingUrl
     */
    public Seller(String id, String title, Boolean superSeller, String login, String userListingUrl, Boolean positiveFeedbackIcon, Boolean company, Integer positiveFeedbackPercent) {
        super();
        this.id = id;
        this.title = title;
        this.superSeller = superSeller;
        this.login = login;
        this.userListingUrl = userListingUrl;
        this.positiveFeedbackIcon = positiveFeedbackIcon;
        this.company = company;
        this.positiveFeedbackPercent = positiveFeedbackPercent;
    }

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("superSeller")
    public Boolean getSuperSeller() {
        return superSeller;
    }

    @JsonProperty("superSeller")
    public void setSuperSeller(Boolean superSeller) {
        this.superSeller = superSeller;
    }

    @JsonProperty("login")
    public String getLogin() {
        return login;
    }

    @JsonProperty("login")
    public void setLogin(String login) {
        this.login = login;
    }

    @JsonProperty("userListingUrl")
    public String getUserListingUrl() {
        return userListingUrl;
    }

    @JsonProperty("userListingUrl")
    public void setUserListingUrl(String userListingUrl) {
        this.userListingUrl = userListingUrl;
    }

    @JsonProperty("positiveFeedbackIcon")
    public Boolean getPositiveFeedbackIcon() {
        return positiveFeedbackIcon;
    }

    @JsonProperty("positiveFeedbackIcon")
    public void setPositiveFeedbackIcon(Boolean positiveFeedbackIcon) {
        this.positiveFeedbackIcon = positiveFeedbackIcon;
    }

    @JsonProperty("company")
    public Boolean getCompany() {
        return company;
    }

    @JsonProperty("company")
    public void setCompany(Boolean company) {
        this.company = company;
    }

    @JsonProperty("positiveFeedbackPercent")
    public Integer getPositiveFeedbackPercent() {
        return positiveFeedbackPercent;
    }

    @JsonProperty("positiveFeedbackPercent")
    public void setPositiveFeedbackPercent(Integer positiveFeedbackPercent) {
        this.positiveFeedbackPercent = positiveFeedbackPercent;
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
