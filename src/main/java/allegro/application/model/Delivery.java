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
import org.threeten.bp.OffsetDateTime;

import java.util.Objects;

/**
 * Delivery
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2019-09-16T16:12:46.567+02:00[Europe/Belgrade]")
public class Delivery {
  public static final String SERIALIZED_NAME_ADDITIONAL_INFO = "additionalInfo";
  @SerializedName(SERIALIZED_NAME_ADDITIONAL_INFO)
  private String additionalInfo;

  public static final String SERIALIZED_NAME_HANDLING_TIME = "handlingTime";
  @SerializedName(SERIALIZED_NAME_HANDLING_TIME)
  private String handlingTime;

  public static final String SERIALIZED_NAME_SHIPMENT_DATE = "shipmentDate";
  @SerializedName(SERIALIZED_NAME_SHIPMENT_DATE)
  private OffsetDateTime shipmentDate;

  public static final String SERIALIZED_NAME_SHIPPING_RATES = "shippingRates";
  @SerializedName(SERIALIZED_NAME_SHIPPING_RATES)
  private JustId shippingRates;


  public Delivery additionalInfo(String additionalInfo) {
    
    this.additionalInfo = additionalInfo;
    return this;
  }

   /**
   * Get additionalInfo
   * @return additionalInfo
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getAdditionalInfo() {
    return additionalInfo;
  }



  public void setAdditionalInfo(String additionalInfo) {
    this.additionalInfo = additionalInfo;
  }


  public Delivery handlingTime(String handlingTime) {
    
    this.handlingTime = handlingTime;
    return this;
  }

   /**
   * Handling time, ISO 8601 duration format
   * @return handlingTime
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "PDT12H30M5S", value = "Handling time, ISO 8601 duration format")

  public String getHandlingTime() {
    return handlingTime;
  }



  public void setHandlingTime(String handlingTime) {
    this.handlingTime = handlingTime;
  }


  public Delivery shipmentDate(OffsetDateTime shipmentDate) {
    
    this.shipmentDate = shipmentDate;
    return this;
  }

   /**
   * Shipment date, Format (ISO 8601) - yyyy-MM-dd&#39;T&#39;HH:mm:ss.SSSZ
   * @return shipmentDate
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "2018-04-01T08:00Z", value = "Shipment date, Format (ISO 8601) - yyyy-MM-dd'T'HH:mm:ss.SSSZ")

  public OffsetDateTime getShipmentDate() {
    return shipmentDate;
  }



  public void setShipmentDate(OffsetDateTime shipmentDate) {
    this.shipmentDate = shipmentDate;
  }


  public Delivery shippingRates(JustId shippingRates) {
    
    this.shippingRates = shippingRates;
    return this;
  }

   /**
   * Get shippingRates
   * @return shippingRates
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public JustId getShippingRates() {
    return shippingRates;
  }



  public void setShippingRates(JustId shippingRates) {
    this.shippingRates = shippingRates;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Delivery delivery = (Delivery) o;
    return Objects.equals(this.additionalInfo, delivery.additionalInfo) &&
        Objects.equals(this.handlingTime, delivery.handlingTime) &&
        Objects.equals(this.shipmentDate, delivery.shipmentDate) &&
        Objects.equals(this.shippingRates, delivery.shippingRates);
  }

  @Override
  public int hashCode() {
    return Objects.hash(additionalInfo, handlingTime, shipmentDate, shippingRates);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Delivery {\n");
    sb.append("    additionalInfo: ").append(toIndentedString(additionalInfo)).append("\n");
    sb.append("    handlingTime: ").append(toIndentedString(handlingTime)).append("\n");
    sb.append("    shipmentDate: ").append(toIndentedString(shipmentDate)).append("\n");
    sb.append("    shippingRates: ").append(toIndentedString(shippingRates)).append("\n");
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
