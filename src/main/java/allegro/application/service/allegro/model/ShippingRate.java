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


package allegro.application.service.allegro.model;

import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModelProperty;

import java.util.Objects;

/**
 * ShippingRate
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2019-09-16T16:12:46.567+02:00[Europe/Belgrade]")
public class ShippingRate {
  public static final String SERIALIZED_NAME_DELIVERY_METHOD = "deliveryMethod";
  @SerializedName(SERIALIZED_NAME_DELIVERY_METHOD)
  private ShippingRateDeliveryMethod deliveryMethod;

  public static final String SERIALIZED_NAME_MAX_QUANTITY_PER_PACKAGE = "maxQuantityPerPackage";
  @SerializedName(SERIALIZED_NAME_MAX_QUANTITY_PER_PACKAGE)
  private Integer maxQuantityPerPackage;

  public static final String SERIALIZED_NAME_FIRST_ITEM_RATE = "firstItemRate";
  @SerializedName(SERIALIZED_NAME_FIRST_ITEM_RATE)
  private ShippingRateFirstItemRate firstItemRate;

  public static final String SERIALIZED_NAME_NEXT_ITEM_RATE = "nextItemRate";
  @SerializedName(SERIALIZED_NAME_NEXT_ITEM_RATE)
  private ShippingRateNextItemRate nextItemRate;

  public static final String SERIALIZED_NAME_SHIPPING_TIME = "shippingTime";
  @SerializedName(SERIALIZED_NAME_SHIPPING_TIME)
  private ShippingRateShippingTime shippingTime;


  public ShippingRate deliveryMethod(ShippingRateDeliveryMethod deliveryMethod) {
    
    this.deliveryMethod = deliveryMethod;
    return this;
  }

   /**
   * Get deliveryMethod
   * @return deliveryMethod
  **/
  @ApiModelProperty(required = true, value = "")

  public ShippingRateDeliveryMethod getDeliveryMethod() {
    return deliveryMethod;
  }



  public void setDeliveryMethod(ShippingRateDeliveryMethod deliveryMethod) {
    this.deliveryMethod = deliveryMethod;
  }


  public ShippingRate maxQuantityPerPackage(Integer maxQuantityPerPackage) {
    
    this.maxQuantityPerPackage = maxQuantityPerPackage;
    return this;
  }

   /**
   * Maximum quantity per package for the given delivery method. Minimum value is 1.
   * minimum: 1
   * @return maxQuantityPerPackage
  **/
  @ApiModelProperty(required = true, value = "Maximum quantity per package for the given delivery method. Minimum value is 1.")

  public Integer getMaxQuantityPerPackage() {
    return maxQuantityPerPackage;
  }



  public void setMaxQuantityPerPackage(Integer maxQuantityPerPackage) {
    this.maxQuantityPerPackage = maxQuantityPerPackage;
  }


  public ShippingRate firstItemRate(ShippingRateFirstItemRate firstItemRate) {
    
    this.firstItemRate = firstItemRate;
    return this;
  }

   /**
   * Get firstItemRate
   * @return firstItemRate
  **/
  @ApiModelProperty(required = true, value = "")

  public ShippingRateFirstItemRate getFirstItemRate() {
    return firstItemRate;
  }



  public void setFirstItemRate(ShippingRateFirstItemRate firstItemRate) {
    this.firstItemRate = firstItemRate;
  }


  public ShippingRate nextItemRate(ShippingRateNextItemRate nextItemRate) {
    
    this.nextItemRate = nextItemRate;
    return this;
  }

   /**
   * Get nextItemRate
   * @return nextItemRate
  **/
  @ApiModelProperty(required = true, value = "")

  public ShippingRateNextItemRate getNextItemRate() {
    return nextItemRate;
  }



  public void setNextItemRate(ShippingRateNextItemRate nextItemRate) {
    this.nextItemRate = nextItemRate;
  }


  public ShippingRate shippingTime(ShippingRateShippingTime shippingTime) {
    
    this.shippingTime = shippingTime;
    return this;
  }

   /**
   * Get shippingTime
   * @return shippingTime
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public ShippingRateShippingTime getShippingTime() {
    return shippingTime;
  }



  public void setShippingTime(ShippingRateShippingTime shippingTime) {
    this.shippingTime = shippingTime;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ShippingRate shippingRate = (ShippingRate) o;
    return Objects.equals(this.deliveryMethod, shippingRate.deliveryMethod) &&
        Objects.equals(this.maxQuantityPerPackage, shippingRate.maxQuantityPerPackage) &&
        Objects.equals(this.firstItemRate, shippingRate.firstItemRate) &&
        Objects.equals(this.nextItemRate, shippingRate.nextItemRate) &&
        Objects.equals(this.shippingTime, shippingRate.shippingTime);
  }

  @Override
  public int hashCode() {
    return Objects.hash(deliveryMethod, maxQuantityPerPackage, firstItemRate, nextItemRate, shippingTime);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ShippingRate {\n");
    sb.append("    deliveryMethod: ").append(toIndentedString(deliveryMethod)).append("\n");
    sb.append("    maxQuantityPerPackage: ").append(toIndentedString(maxQuantityPerPackage)).append("\n");
    sb.append("    firstItemRate: ").append(toIndentedString(firstItemRate)).append("\n");
    sb.append("    nextItemRate: ").append(toIndentedString(nextItemRate)).append("\n");
    sb.append("    shippingTime: ").append(toIndentedString(shippingTime)).append("\n");
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
