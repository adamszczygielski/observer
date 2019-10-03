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
 * CheckoutFormDeliveryReference
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2019-09-16T16:12:46.567+02:00[Europe/Belgrade]")
public class CheckoutFormDeliveryReference {
  public static final String SERIALIZED_NAME_ADDRESS = "address";
  @SerializedName(SERIALIZED_NAME_ADDRESS)
  private CheckoutFormDeliveryAddress address;

  public static final String SERIALIZED_NAME_METHOD = "method";
  @SerializedName(SERIALIZED_NAME_METHOD)
  private CheckoutFormDeliveryMethod method;

  public static final String SERIALIZED_NAME_PICKUP_POINT = "pickupPoint";
  @SerializedName(SERIALIZED_NAME_PICKUP_POINT)
  private CheckoutFormDeliveryPickupPoint pickupPoint;

  public static final String SERIALIZED_NAME_COST = "cost";
  @SerializedName(SERIALIZED_NAME_COST)
  private Price cost;

  public static final String SERIALIZED_NAME_TIME = "time";
  @SerializedName(SERIALIZED_NAME_TIME)
  private CheckoutFormDeliveryTime time;

  public static final String SERIALIZED_NAME_SMART = "smart";
  @SerializedName(SERIALIZED_NAME_SMART)
  private Boolean smart;


  public CheckoutFormDeliveryReference address(CheckoutFormDeliveryAddress address) {
    
    this.address = address;
    return this;
  }

   /**
   * Get address
   * @return address
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public CheckoutFormDeliveryAddress getAddress() {
    return address;
  }



  public void setAddress(CheckoutFormDeliveryAddress address) {
    this.address = address;
  }


  public CheckoutFormDeliveryReference method(CheckoutFormDeliveryMethod method) {
    
    this.method = method;
    return this;
  }

   /**
   * Get method
   * @return method
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public CheckoutFormDeliveryMethod getMethod() {
    return method;
  }



  public void setMethod(CheckoutFormDeliveryMethod method) {
    this.method = method;
  }


  public CheckoutFormDeliveryReference pickupPoint(CheckoutFormDeliveryPickupPoint pickupPoint) {
    
    this.pickupPoint = pickupPoint;
    return this;
  }

   /**
   * Get pickupPoint
   * @return pickupPoint
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public CheckoutFormDeliveryPickupPoint getPickupPoint() {
    return pickupPoint;
  }



  public void setPickupPoint(CheckoutFormDeliveryPickupPoint pickupPoint) {
    this.pickupPoint = pickupPoint;
  }


  public CheckoutFormDeliveryReference cost(Price cost) {
    
    this.cost = cost;
    return this;
  }

   /**
   * Get cost
   * @return cost
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Price getCost() {
    return cost;
  }



  public void setCost(Price cost) {
    this.cost = cost;
  }


  public CheckoutFormDeliveryReference time(CheckoutFormDeliveryTime time) {
    
    this.time = time;
    return this;
  }

   /**
   * Get time
   * @return time
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public CheckoutFormDeliveryTime getTime() {
    return time;
  }



  public void setTime(CheckoutFormDeliveryTime time) {
    this.time = time;
  }


  public CheckoutFormDeliveryReference smart(Boolean smart) {
    
    this.smart = smart;
    return this;
  }

   /**
   * Buyer used a SMART option
   * @return smart
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "true", value = "Buyer used a SMART option")

  public Boolean getSmart() {
    return smart;
  }



  public void setSmart(Boolean smart) {
    this.smart = smart;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CheckoutFormDeliveryReference checkoutFormDeliveryReference = (CheckoutFormDeliveryReference) o;
    return Objects.equals(this.address, checkoutFormDeliveryReference.address) &&
        Objects.equals(this.method, checkoutFormDeliveryReference.method) &&
        Objects.equals(this.pickupPoint, checkoutFormDeliveryReference.pickupPoint) &&
        Objects.equals(this.cost, checkoutFormDeliveryReference.cost) &&
        Objects.equals(this.time, checkoutFormDeliveryReference.time) &&
        Objects.equals(this.smart, checkoutFormDeliveryReference.smart);
  }

  @Override
  public int hashCode() {
    return Objects.hash(address, method, pickupPoint, cost, time, smart);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CheckoutFormDeliveryReference {\n");
    sb.append("    address: ").append(toIndentedString(address)).append("\n");
    sb.append("    method: ").append(toIndentedString(method)).append("\n");
    sb.append("    pickupPoint: ").append(toIndentedString(pickupPoint)).append("\n");
    sb.append("    cost: ").append(toIndentedString(cost)).append("\n");
    sb.append("    time: ").append(toIndentedString(time)).append("\n");
    sb.append("    smart: ").append(toIndentedString(smart)).append("\n");
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

