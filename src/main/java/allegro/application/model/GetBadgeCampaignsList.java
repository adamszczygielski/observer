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
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * GetBadgeCampaignsList
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2019-09-16T16:12:46.567+02:00[Europe/Belgrade]")
public class GetBadgeCampaignsList {
  public static final String SERIALIZED_NAME_BADGE_CAMPAIGNS = "badgeCampaigns";
  @SerializedName(SERIALIZED_NAME_BADGE_CAMPAIGNS)
  private List<BadgeCampaign> badgeCampaigns = new ArrayList<BadgeCampaign>();


  public GetBadgeCampaignsList badgeCampaigns(List<BadgeCampaign> badgeCampaigns) {
    
    this.badgeCampaigns = badgeCampaigns;
    return this;
  }

  public GetBadgeCampaignsList addBadgeCampaignsItem(BadgeCampaign badgeCampaignsItem) {
    this.badgeCampaigns.add(badgeCampaignsItem);
    return this;
  }

   /**
   * List of badge campaigns.
   * @return badgeCampaigns
  **/
  @ApiModelProperty(required = true, value = "List of badge campaigns.")

  public List<BadgeCampaign> getBadgeCampaigns() {
    return badgeCampaigns;
  }



  public void setBadgeCampaigns(List<BadgeCampaign> badgeCampaigns) {
    this.badgeCampaigns = badgeCampaigns;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GetBadgeCampaignsList getBadgeCampaignsList = (GetBadgeCampaignsList) o;
    return Objects.equals(this.badgeCampaigns, getBadgeCampaignsList.badgeCampaigns);
  }

  @Override
  public int hashCode() {
    return Objects.hash(badgeCampaigns);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetBadgeCampaignsList {\n");
    sb.append("    badgeCampaigns: ").append(toIndentedString(badgeCampaigns)).append("\n");
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

