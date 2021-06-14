
package observer.application.service.source.allegro.model.listing;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "superSeller",
    "login",
    "userListingUrl",
    "positiveFeedbackPercent",
    "company"
})
@Generated("jsonschema2pojo")
public class Seller {

    @JsonProperty("id")
    private String id;
    @JsonProperty("superSeller")
    private Boolean superSeller;
    @JsonProperty("login")
    private String login;
    @JsonProperty("userListingUrl")
    private String userListingUrl;
    @JsonProperty("positiveFeedbackPercent")
    private Float positiveFeedbackPercent;
    @JsonProperty("company")
    private Boolean company;

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
     * @param company
     * @param id
     * @param login
     * @param userListingUrl
     */
    public Seller(String id, Boolean superSeller, String login, String userListingUrl, Float positiveFeedbackPercent, Boolean company) {
        super();
        this.id = id;
        this.superSeller = superSeller;
        this.login = login;
        this.userListingUrl = userListingUrl;
        this.positiveFeedbackPercent = positiveFeedbackPercent;
        this.company = company;
    }

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
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

    @JsonProperty("positiveFeedbackPercent")
    public Float getPositiveFeedbackPercent() {
        return positiveFeedbackPercent;
    }

    @JsonProperty("positiveFeedbackPercent")
    public void setPositiveFeedbackPercent(Float positiveFeedbackPercent) {
        this.positiveFeedbackPercent = positiveFeedbackPercent;
    }

    @JsonProperty("company")
    public Boolean getCompany() {
        return company;
    }

    @JsonProperty("company")
    public void setCompany(Boolean company) {
        this.company = company;
    }

}
