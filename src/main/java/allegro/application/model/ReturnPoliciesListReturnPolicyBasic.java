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
 * ReturnPoliciesListReturnPolicyBasic
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2019-09-16T16:12:46.567+02:00[Europe/Belgrade]")
public class ReturnPoliciesListReturnPolicyBasic {
  public static final String SERIALIZED_NAME_COUNT = "count";
  @SerializedName(SERIALIZED_NAME_COUNT)
  private Integer count;

  public static final String SERIALIZED_NAME_RETURN_POLICIES = "returnPolicies";
  @SerializedName(SERIALIZED_NAME_RETURN_POLICIES)
  private List<ReturnPolicyBasic> returnPolicies = null;


  public ReturnPoliciesListReturnPolicyBasic count(Integer count) {
    
    this.count = count;
    return this;
  }

   /**
   * Get count
   * @return count
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Integer getCount() {
    return count;
  }



  public void setCount(Integer count) {
    this.count = count;
  }


  public ReturnPoliciesListReturnPolicyBasic returnPolicies(List<ReturnPolicyBasic> returnPolicies) {
    
    this.returnPolicies = returnPolicies;
    return this;
  }

  public ReturnPoliciesListReturnPolicyBasic addReturnPoliciesItem(ReturnPolicyBasic returnPoliciesItem) {
    if (this.returnPolicies == null) {
      this.returnPolicies = new ArrayList<ReturnPolicyBasic>();
    }
    this.returnPolicies.add(returnPoliciesItem);
    return this;
  }

   /**
   * Get returnPolicies
   * @return returnPolicies
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public List<ReturnPolicyBasic> getReturnPolicies() {
    return returnPolicies;
  }



  public void setReturnPolicies(List<ReturnPolicyBasic> returnPolicies) {
    this.returnPolicies = returnPolicies;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ReturnPoliciesListReturnPolicyBasic returnPoliciesListReturnPolicyBasic = (ReturnPoliciesListReturnPolicyBasic) o;
    return Objects.equals(this.count, returnPoliciesListReturnPolicyBasic.count) &&
        Objects.equals(this.returnPolicies, returnPoliciesListReturnPolicyBasic.returnPolicies);
  }

  @Override
  public int hashCode() {
    return Objects.hash(count, returnPolicies);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ReturnPoliciesListReturnPolicyBasic {\n");
    sb.append("    count: ").append(toIndentedString(count)).append("\n");
    sb.append("    returnPolicies: ").append(toIndentedString(returnPolicies)).append("\n");
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
