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

import java.util.Objects;

/**
 * DeliverySettingsDto
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2019-09-16T16:12:46.567+02:00[Europe/Belgrade]")
public class DeliverySettingsDto {
  public static final String SERIALIZED_NAME_FREE_DELIVERY = "freeDelivery";
  @SerializedName(SERIALIZED_NAME_FREE_DELIVERY)
  private DeliverySettingsDtoFreeDelivery freeDelivery;

  public static final String SERIALIZED_NAME_JOIN_POLICY = "joinPolicy";
  @SerializedName(SERIALIZED_NAME_JOIN_POLICY)
  private DeliverySettingsDtoJoinPolicy joinPolicy;

  public static final String SERIALIZED_NAME_CUSTOM_COST = "customCost";
  @SerializedName(SERIALIZED_NAME_CUSTOM_COST)
  private DeliverySettingsDtoCustomCost customCost;

  public static final String SERIALIZED_NAME_UPDATED_AT = "updatedAt";
  @SerializedName(SERIALIZED_NAME_UPDATED_AT)
  private String updatedAt;


  public DeliverySettingsDto freeDelivery(DeliverySettingsDtoFreeDelivery freeDelivery) {
    
    this.freeDelivery = freeDelivery;
    return this;
  }

   /**
   * Get freeDelivery
   * @return freeDelivery
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public DeliverySettingsDtoFreeDelivery getFreeDelivery() {
    return freeDelivery;
  }



  public void setFreeDelivery(DeliverySettingsDtoFreeDelivery freeDelivery) {
    this.freeDelivery = freeDelivery;
  }


  public DeliverySettingsDto joinPolicy(DeliverySettingsDtoJoinPolicy joinPolicy) {
    
    this.joinPolicy = joinPolicy;
    return this;
  }

   /**
   * Get joinPolicy
   * @return joinPolicy
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public DeliverySettingsDtoJoinPolicy getJoinPolicy() {
    return joinPolicy;
  }



  public void setJoinPolicy(DeliverySettingsDtoJoinPolicy joinPolicy) {
    this.joinPolicy = joinPolicy;
  }


  public DeliverySettingsDto customCost(DeliverySettingsDtoCustomCost customCost) {
    
    this.customCost = customCost;
    return this;
  }

   /**
   * Get customCost
   * @return customCost
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public DeliverySettingsDtoCustomCost getCustomCost() {
    return customCost;
  }



  public void setCustomCost(DeliverySettingsDtoCustomCost customCost) {
    this.customCost = customCost;
  }


  public DeliverySettingsDto updatedAt(String updatedAt) {
    
    this.updatedAt = updatedAt;
    return this;
  }

   /**
   * Date and time of the last modification of the set in UTC ISO 8601 format. When updating (Put) settings the field is ignored.
   * @return updatedAt
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Date and time of the last modification of the set in UTC ISO 8601 format. When updating (Put) settings the field is ignored.")

  public String getUpdatedAt() {
    return updatedAt;
  }



  public void setUpdatedAt(String updatedAt) {
    this.updatedAt = updatedAt;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DeliverySettingsDto deliverySettingsDto = (DeliverySettingsDto) o;
    return Objects.equals(this.freeDelivery, deliverySettingsDto.freeDelivery) &&
        Objects.equals(this.joinPolicy, deliverySettingsDto.joinPolicy) &&
        Objects.equals(this.customCost, deliverySettingsDto.customCost) &&
        Objects.equals(this.updatedAt, deliverySettingsDto.updatedAt);
  }

  @Override
  public int hashCode() {
    return Objects.hash(freeDelivery, joinPolicy, customCost, updatedAt);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DeliverySettingsDto {\n");
    sb.append("    freeDelivery: ").append(toIndentedString(freeDelivery)).append("\n");
    sb.append("    joinPolicy: ").append(toIndentedString(joinPolicy)).append("\n");
    sb.append("    customCost: ").append(toIndentedString(customCost)).append("\n");
    sb.append("    updatedAt: ").append(toIndentedString(updatedAt)).append("\n");
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

