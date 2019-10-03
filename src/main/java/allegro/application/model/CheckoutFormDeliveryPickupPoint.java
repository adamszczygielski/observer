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
 * CheckoutFormDeliveryPickupPoint
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2019-09-16T16:12:46.567+02:00[Europe/Belgrade]")
public class CheckoutFormDeliveryPickupPoint {
  public static final String SERIALIZED_NAME_ID = "id";
  @SerializedName(SERIALIZED_NAME_ID)
  private String id;

  public static final String SERIALIZED_NAME_NAME = "name";
  @SerializedName(SERIALIZED_NAME_NAME)
  private String name;

  public static final String SERIALIZED_NAME_DESCRIPTION = "description";
  @SerializedName(SERIALIZED_NAME_DESCRIPTION)
  private String description;

  public static final String SERIALIZED_NAME_ADDRESS = "address";
  @SerializedName(SERIALIZED_NAME_ADDRESS)
  private CheckoutFormDeliveryPickupPointAddress address;


  public CheckoutFormDeliveryPickupPoint id(String id) {
    
    this.id = id;
    return this;
  }

   /**
   * Delivery point id
   * @return id
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "POZ08A", value = "Delivery point id")

  public String getId() {
    return id;
  }



  public void setId(String id) {
    this.id = id;
  }


  public CheckoutFormDeliveryPickupPoint name(String name) {
    
    this.name = name;
    return this;
  }

   /**
   * Delivery point name
   * @return name
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "Paczkomat POZ08A", value = "Delivery point name")

  public String getName() {
    return name;
  }



  public void setName(String name) {
    this.name = name;
  }


  public CheckoutFormDeliveryPickupPoint description(String description) {
    
    this.description = description;
    return this;
  }

   /**
   * Delivery point description
   * @return description
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "Stacja paliw BP", value = "Delivery point description")

  public String getDescription() {
    return description;
  }



  public void setDescription(String description) {
    this.description = description;
  }


  public CheckoutFormDeliveryPickupPoint address(CheckoutFormDeliveryPickupPointAddress address) {
    
    this.address = address;
    return this;
  }

   /**
   * Get address
   * @return address
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public CheckoutFormDeliveryPickupPointAddress getAddress() {
    return address;
  }



  public void setAddress(CheckoutFormDeliveryPickupPointAddress address) {
    this.address = address;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CheckoutFormDeliveryPickupPoint checkoutFormDeliveryPickupPoint = (CheckoutFormDeliveryPickupPoint) o;
    return Objects.equals(this.id, checkoutFormDeliveryPickupPoint.id) &&
        Objects.equals(this.name, checkoutFormDeliveryPickupPoint.name) &&
        Objects.equals(this.description, checkoutFormDeliveryPickupPoint.description) &&
        Objects.equals(this.address, checkoutFormDeliveryPickupPoint.address);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, description, address);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CheckoutFormDeliveryPickupPoint {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    address: ").append(toIndentedString(address)).append("\n");
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

