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

import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Objects;

/**
 * Rate for every other item, after the first, in the same parcel for the given delivery method
 */
@ApiModel(description = "Rate for every other item, after the first, in the same parcel for the given delivery method")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2019-09-16T16:12:46.567+02:00[Europe/Belgrade]")
public class ShippingRateNextItemRate {
  public static final String SERIALIZED_NAME_AMOUNT = "amount";
  @SerializedName(SERIALIZED_NAME_AMOUNT)
  private String amount;

  public static final String SERIALIZED_NAME_CURRENCY = "currency";
  @SerializedName(SERIALIZED_NAME_CURRENCY)
  private String currency;


  public ShippingRateNextItemRate amount(String amount) {
    
    this.amount = amount;
    return this;
  }

   /**
   * Amount
   * @return amount
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Amount")

  public String getAmount() {
    return amount;
  }



  public void setAmount(String amount) {
    this.amount = amount;
  }


  public ShippingRateNextItemRate currency(String currency) {
    
    this.currency = currency;
    return this;
  }

   /**
   * ISO 4217 currency code
   * @return currency
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "ISO 4217 currency code")

  public String getCurrency() {
    return currency;
  }



  public void setCurrency(String currency) {
    this.currency = currency;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ShippingRateNextItemRate shippingRateNextItemRate = (ShippingRateNextItemRate) o;
    return Objects.equals(this.amount, shippingRateNextItemRate.amount) &&
        Objects.equals(this.currency, shippingRateNextItemRate.currency);
  }

  @Override
  public int hashCode() {
    return Objects.hash(amount, currency);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ShippingRateNextItemRate {\n");
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
    sb.append("    currency: ").append(toIndentedString(currency)).append("\n");
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
