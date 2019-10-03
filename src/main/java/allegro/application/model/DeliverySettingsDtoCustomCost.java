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

import java.util.Objects;

/**
 * Policy of custom delivery cost.
 */
@ApiModel(description = "Policy of custom delivery cost.")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2019-09-16T16:12:46.567+02:00[Europe/Belgrade]")
public class DeliverySettingsDtoCustomCost {
  public static final String SERIALIZED_NAME_ALLOWED = "allowed";
  @SerializedName(SERIALIZED_NAME_ALLOWED)
  private Boolean allowed;


  public DeliverySettingsDtoCustomCost allowed(Boolean allowed) {
    
    this.allowed = allowed;
    return this;
  }

   /**
   * If true the customer can enter a custom shipping cost.
   * @return allowed
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "false", value = "If true the customer can enter a custom shipping cost.")

  public Boolean getAllowed() {
    return allowed;
  }



  public void setAllowed(Boolean allowed) {
    this.allowed = allowed;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DeliverySettingsDtoCustomCost deliverySettingsDtoCustomCost = (DeliverySettingsDtoCustomCost) o;
    return Objects.equals(this.allowed, deliverySettingsDtoCustomCost.allowed);
  }

  @Override
  public int hashCode() {
    return Objects.hash(allowed);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DeliverySettingsDtoCustomCost {\n");
    sb.append("    allowed: ").append(toIndentedString(allowed)).append("\n");
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

