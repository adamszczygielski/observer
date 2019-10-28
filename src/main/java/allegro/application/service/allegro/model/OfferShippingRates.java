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

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * OfferShippingRates
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2019-09-16T16:12:46.567+02:00[Europe/Belgrade]")
public class OfferShippingRates {
  public static final String SERIALIZED_NAME_RATES = "rates";
  @SerializedName(SERIALIZED_NAME_RATES)
  private List<ShippingRate> rates = null;


  public OfferShippingRates rates(List<ShippingRate> rates) {
    
    this.rates = rates;
    return this;
  }

  public OfferShippingRates addRatesItem(ShippingRate ratesItem) {
    if (this.rates == null) {
      this.rates = new ArrayList<ShippingRate>();
    }
    this.rates.add(ratesItem);
    return this;
  }

   /**
   * If empty there is the shipping rates set attached to offer. You should use the GET /sale/offers/{offerId} resource to retrieve the shipping rates set ID.
   * @return rates
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "If empty there is the shipping rates set attached to offer. You should use the GET /sale/offers/{offerId} resource to retrieve the shipping rates set ID.")

  public List<ShippingRate> getRates() {
    return rates;
  }



  public void setRates(List<ShippingRate> rates) {
    this.rates = rates;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OfferShippingRates offerShippingRates = (OfferShippingRates) o;
    return Objects.equals(this.rates, offerShippingRates.rates);
  }

  @Override
  public int hashCode() {
    return Objects.hash(rates);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OfferShippingRates {\n");
    sb.append("    rates: ").append(toIndentedString(rates)).append("\n");
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
