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
 * Rules for the delivery method, i.e. price, quantity, shipping time, etc.
 */
@ApiModel(description = "Rules for the delivery method, i.e. price, quantity, shipping time, etc.")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2019-09-16T16:12:46.567+02:00[Europe/Belgrade]")
public class InlineResponse2001ShippingRatesConstraints {
  public static final String SERIALIZED_NAME_ALLOWED = "allowed";
  @SerializedName(SERIALIZED_NAME_ALLOWED)
  private Boolean allowed;

  public static final String SERIALIZED_NAME_MAX_QUANTITY_PER_PACKAGE = "maxQuantityPerPackage";
  @SerializedName(SERIALIZED_NAME_MAX_QUANTITY_PER_PACKAGE)
  private InlineResponse2001ShippingRatesConstraintsMaxQuantityPerPackage maxQuantityPerPackage;

  public static final String SERIALIZED_NAME_FIRST_ITEM_RATE = "firstItemRate";
  @SerializedName(SERIALIZED_NAME_FIRST_ITEM_RATE)
  private InlineResponse2001ShippingRatesConstraintsFirstItemRate firstItemRate;

  public static final String SERIALIZED_NAME_NEXT_ITEM_RATE = "nextItemRate";
  @SerializedName(SERIALIZED_NAME_NEXT_ITEM_RATE)
  private InlineResponse2001ShippingRatesConstraintsNextItemRate nextItemRate;

  public static final String SERIALIZED_NAME_SHIPPING_TIME = "shippingTime";
  @SerializedName(SERIALIZED_NAME_SHIPPING_TIME)
  private InlineResponse2001ShippingRatesConstraintsShippingTime shippingTime;


  public InlineResponse2001ShippingRatesConstraints allowed(Boolean allowed) {
    
    this.allowed = allowed;
    return this;
  }

   /**
   * Indicates whether delivery method can be used when adding or modifying shipping rates.
   * @return allowed
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Indicates whether delivery method can be used when adding or modifying shipping rates.")

  public Boolean getAllowed() {
    return allowed;
  }



  public void setAllowed(Boolean allowed) {
    this.allowed = allowed;
  }


  public InlineResponse2001ShippingRatesConstraints maxQuantityPerPackage(InlineResponse2001ShippingRatesConstraintsMaxQuantityPerPackage maxQuantityPerPackage) {
    
    this.maxQuantityPerPackage = maxQuantityPerPackage;
    return this;
  }

   /**
   * Get maxQuantityPerPackage
   * @return maxQuantityPerPackage
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public InlineResponse2001ShippingRatesConstraintsMaxQuantityPerPackage getMaxQuantityPerPackage() {
    return maxQuantityPerPackage;
  }



  public void setMaxQuantityPerPackage(InlineResponse2001ShippingRatesConstraintsMaxQuantityPerPackage maxQuantityPerPackage) {
    this.maxQuantityPerPackage = maxQuantityPerPackage;
  }


  public InlineResponse2001ShippingRatesConstraints firstItemRate(InlineResponse2001ShippingRatesConstraintsFirstItemRate firstItemRate) {
    
    this.firstItemRate = firstItemRate;
    return this;
  }

   /**
   * Get firstItemRate
   * @return firstItemRate
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public InlineResponse2001ShippingRatesConstraintsFirstItemRate getFirstItemRate() {
    return firstItemRate;
  }



  public void setFirstItemRate(InlineResponse2001ShippingRatesConstraintsFirstItemRate firstItemRate) {
    this.firstItemRate = firstItemRate;
  }


  public InlineResponse2001ShippingRatesConstraints nextItemRate(InlineResponse2001ShippingRatesConstraintsNextItemRate nextItemRate) {
    
    this.nextItemRate = nextItemRate;
    return this;
  }

   /**
   * Get nextItemRate
   * @return nextItemRate
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public InlineResponse2001ShippingRatesConstraintsNextItemRate getNextItemRate() {
    return nextItemRate;
  }



  public void setNextItemRate(InlineResponse2001ShippingRatesConstraintsNextItemRate nextItemRate) {
    this.nextItemRate = nextItemRate;
  }


  public InlineResponse2001ShippingRatesConstraints shippingTime(InlineResponse2001ShippingRatesConstraintsShippingTime shippingTime) {
    
    this.shippingTime = shippingTime;
    return this;
  }

   /**
   * Get shippingTime
   * @return shippingTime
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public InlineResponse2001ShippingRatesConstraintsShippingTime getShippingTime() {
    return shippingTime;
  }



  public void setShippingTime(InlineResponse2001ShippingRatesConstraintsShippingTime shippingTime) {
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
    InlineResponse2001ShippingRatesConstraints inlineResponse2001ShippingRatesConstraints = (InlineResponse2001ShippingRatesConstraints) o;
    return Objects.equals(this.allowed, inlineResponse2001ShippingRatesConstraints.allowed) &&
        Objects.equals(this.maxQuantityPerPackage, inlineResponse2001ShippingRatesConstraints.maxQuantityPerPackage) &&
        Objects.equals(this.firstItemRate, inlineResponse2001ShippingRatesConstraints.firstItemRate) &&
        Objects.equals(this.nextItemRate, inlineResponse2001ShippingRatesConstraints.nextItemRate) &&
        Objects.equals(this.shippingTime, inlineResponse2001ShippingRatesConstraints.shippingTime);
  }

  @Override
  public int hashCode() {
    return Objects.hash(allowed, maxQuantityPerPackage, firstItemRate, nextItemRate, shippingTime);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InlineResponse2001ShippingRatesConstraints {\n");
    sb.append("    allowed: ").append(toIndentedString(allowed)).append("\n");
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
