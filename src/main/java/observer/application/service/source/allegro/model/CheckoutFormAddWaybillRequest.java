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


package observer.application.service.source.allegro.model;

import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.annotations.ApiModelProperty;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * CheckoutFormAddWaybillRequest
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2019-09-16T16:12:46.567+02:00[Europe/Belgrade]")
public class CheckoutFormAddWaybillRequest {
  /**
   * Carrier identifier taken from the dictionary below. It’s highly recommended to use an identifier different from OTHER, because its parcel status may be updated automatically. Carrier identifier OTHER is reserved for cases when seller uses a custom carrier or not yet integrated with Allegro.
   */
  @JsonAdapter(CarrierIdEnum.Adapter.class)
  public enum CarrierIdEnum {
    UPS("UPS"),
    
    INPOST("INPOST"),
    
    DHL("DHL"),
    
    GLS("GLS"),
    
    RUCH("RUCH"),
    
    POCZTA_POLSKA("POCZTA_POLSKA"),
    
    DPD("DPD"),
    
    FEDEX("FEDEX"),
    
    TNT_EXPRESS("TNT_EXPRESS"),
    
    DB_SCHENKER("DB_SCHENKER"),
    
    RABEN("RABEN"),
    
    GEIS("GEIS"),
    
    DTS("DTS"),
    
    PEKAES("PEKAES"),
    
    PATRON("PATRON"),
    
    X_PRESS_COURIERS("X_PRESS_COURIERS"),
    
    RHENUS_LOGISTICS("RHENUS_LOGISTICS"),
    
    OTHER("OTHER");

    private String value;

    CarrierIdEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static CarrierIdEnum fromValue(String value) {
      for (CarrierIdEnum b : CarrierIdEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<CarrierIdEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final CarrierIdEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public CarrierIdEnum read(final JsonReader jsonReader) throws IOException {
        String value = jsonReader.nextString();
        return CarrierIdEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_CARRIER_ID = "carrierId";
  @SerializedName(SERIALIZED_NAME_CARRIER_ID)
  private CarrierIdEnum carrierId;

  public static final String SERIALIZED_NAME_WAYBILL = "waybill";
  @SerializedName(SERIALIZED_NAME_WAYBILL)
  private String waybill;

  public static final String SERIALIZED_NAME_CARRIER_NAME = "carrierName";
  @SerializedName(SERIALIZED_NAME_CARRIER_NAME)
  private String carrierName;

  public static final String SERIALIZED_NAME_LINE_ITEMS = "lineItems";
  @SerializedName(SERIALIZED_NAME_LINE_ITEMS)
  private List<Object> lineItems = new ArrayList<Object>();


  public CheckoutFormAddWaybillRequest carrierId(CarrierIdEnum carrierId) {
    
    this.carrierId = carrierId;
    return this;
  }

   /**
   * Carrier identifier taken from the dictionary below. It’s highly recommended to use an identifier different from OTHER, because its parcel status may be updated automatically. Carrier identifier OTHER is reserved for cases when seller uses a custom carrier or not yet integrated with Allegro.
   * @return carrierId
  **/
  @ApiModelProperty(required = true, value = "Carrier identifier taken from the dictionary below. It’s highly recommended to use an identifier different from OTHER, because its parcel status may be updated automatically. Carrier identifier OTHER is reserved for cases when seller uses a custom carrier or not yet integrated with Allegro.")

  public CarrierIdEnum getCarrierId() {
    return carrierId;
  }



  public void setCarrierId(CarrierIdEnum carrierId) {
    this.carrierId = carrierId;
  }


  public CheckoutFormAddWaybillRequest waybill(String waybill) {
    
    this.waybill = waybill;
    return this;
  }

   /**
   * Waybill number (parcel tracking number). Cannot be empty and must be no longer than 64 characters. It can contain any word character (equal to [a-zA-Z0-9_]) and special characters: parentheses and hyphen-minus.
   * @return waybill
  **/
  @ApiModelProperty(required = true, value = "Waybill number (parcel tracking number). Cannot be empty and must be no longer than 64 characters. It can contain any word character (equal to [a-zA-Z0-9_]) and special characters: parentheses and hyphen-minus.")

  public String getWaybill() {
    return waybill;
  }



  public void setWaybill(String waybill) {
    this.waybill = waybill;
  }


  public CheckoutFormAddWaybillRequest carrierName(String carrierName) {
    
    this.carrierName = carrierName;
    return this;
  }

   /**
   * Carrier name to be provided only if carrierId is OTHER, otherwise it’s ignored. Must be no longer than 30 characters.
   * @return carrierName
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Carrier name to be provided only if carrierId is OTHER, otherwise it’s ignored. Must be no longer than 30 characters.")

  public String getCarrierName() {
    return carrierName;
  }



  public void setCarrierName(String carrierName) {
    this.carrierName = carrierName;
  }


  public CheckoutFormAddWaybillRequest lineItems(List<Object> lineItems) {
    
    this.lineItems = lineItems;
    return this;
  }

  public CheckoutFormAddWaybillRequest addLineItemsItem(Object lineItemsItem) {
    this.lineItems.add(lineItemsItem);
    return this;
  }

   /**
   * List of order line items. They must be from the order specified in the path parameter. List cannot be empty.
   * @return lineItems
  **/
  @ApiModelProperty(required = true, value = "List of order line items. They must be from the order specified in the path parameter. List cannot be empty.")

  public List<Object> getLineItems() {
    return lineItems;
  }



  public void setLineItems(List<Object> lineItems) {
    this.lineItems = lineItems;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CheckoutFormAddWaybillRequest checkoutFormAddWaybillRequest = (CheckoutFormAddWaybillRequest) o;
    return Objects.equals(this.carrierId, checkoutFormAddWaybillRequest.carrierId) &&
        Objects.equals(this.waybill, checkoutFormAddWaybillRequest.waybill) &&
        Objects.equals(this.carrierName, checkoutFormAddWaybillRequest.carrierName) &&
        Objects.equals(this.lineItems, checkoutFormAddWaybillRequest.lineItems);
  }

  @Override
  public int hashCode() {
    return Objects.hash(carrierId, waybill, carrierName, lineItems);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CheckoutFormAddWaybillRequest {\n");
    sb.append("    carrierId: ").append(toIndentedString(carrierId)).append("\n");
    sb.append("    waybill: ").append(toIndentedString(waybill)).append("\n");
    sb.append("    carrierName: ").append(toIndentedString(carrierName)).append("\n");
    sb.append("    lineItems: ").append(toIndentedString(lineItems)).append("\n");
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
