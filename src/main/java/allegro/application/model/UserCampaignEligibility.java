/*
 * Allegro REST API
 * https://developer.allegro.pl/about
 *
 * The version of the OpenAPI document: latest
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package allegro.application.model;

import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Summary of user eligibility for participation in the campaign.
 */
@ApiModel(description = "Summary of user eligibility for participation in the campaign.")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2019-09-16T16:12:46.567+02:00[Europe/Belgrade]")
public class UserCampaignEligibility {
  public static final String SERIALIZED_NAME_ELIGIBLE = "eligible";
  @SerializedName(SERIALIZED_NAME_ELIGIBLE)
  private Boolean eligible;

  public static final String SERIALIZED_NAME_REFUSAL_REASONS = "refusalReasons";
  @SerializedName(SERIALIZED_NAME_REFUSAL_REASONS)
  private List<CampaignRefusalReason> refusalReasons = new ArrayList<CampaignRefusalReason>();


  public UserCampaignEligibility eligible(Boolean eligible) {
    
    this.eligible = eligible;
    return this;
  }

   /**
   * Information whether user is eligible to participate in this campaign.
   * @return eligible
  **/
  @ApiModelProperty(required = true, value = "Information whether user is eligible to participate in this campaign.")

  public Boolean getEligible() {
    return eligible;
  }



  public void setEligible(Boolean eligible) {
    this.eligible = eligible;
  }


  public UserCampaignEligibility refusalReasons(List<CampaignRefusalReason> refusalReasons) {
    
    this.refusalReasons = refusalReasons;
    return this;
  }

  public UserCampaignEligibility addRefusalReasonsItem(CampaignRefusalReason refusalReasonsItem) {
    this.refusalReasons.add(refusalReasonsItem);
    return this;
  }

   /**
   * Information why user is not able to participate in the campaign.
   * @return refusalReasons
  **/
  @ApiModelProperty(required = true, value = "Information why user is not able to participate in the campaign.")

  public List<CampaignRefusalReason> getRefusalReasons() {
    return refusalReasons;
  }



  public void setRefusalReasons(List<CampaignRefusalReason> refusalReasons) {
    this.refusalReasons = refusalReasons;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UserCampaignEligibility userCampaignEligibility = (UserCampaignEligibility) o;
    return Objects.equals(this.eligible, userCampaignEligibility.eligible) &&
        Objects.equals(this.refusalReasons, userCampaignEligibility.refusalReasons);
  }

  @Override
  public int hashCode() {
    return Objects.hash(eligible, refusalReasons);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UserCampaignEligibility {\n");
    sb.append("    eligible: ").append(toIndentedString(eligible)).append("\n");
    sb.append("    refusalReasons: ").append(toIndentedString(refusalReasons)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}

