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

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * ShippingRatesSet
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2019-09-16T16:12:46.567+02:00[Europe/Belgrade]")
public class ShippingRatesSet {
  public static final String SERIALIZED_NAME_ID = "id";
  @SerializedName(SERIALIZED_NAME_ID)
  private String id;

  public static final String SERIALIZED_NAME_NAME = "name";
  @SerializedName(SERIALIZED_NAME_NAME)
  private String name;

  public static final String SERIALIZED_NAME_RATES = "rates";
  @SerializedName(SERIALIZED_NAME_RATES)
  private List<ShippingRate> rates = new ArrayList<ShippingRate>();

  public static final String SERIALIZED_NAME_LAST_MODIFIED = "lastModified";
  @SerializedName(SERIALIZED_NAME_LAST_MODIFIED)
  private String lastModified;


  public ShippingRatesSet id(String id) {
    
    this.id = id;
    return this;
  }

   /**
   * Shipping rates set ID (UUID) When creating a shipping rates set (Post) the field is ignored. It is required when updating (Put) a shipping rates.
   * @return id
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Shipping rates set ID (UUID) When creating a shipping rates set (Post) the field is ignored. It is required when updating (Put) a shipping rates.")

  public String getId() {
    return id;
  }



  public void setId(String id) {
    this.id = id;
  }


  public ShippingRatesSet name(String name) {
    
    this.name = name;
    return this;
  }

   /**
   * User defined name of the shipping rates set. It may only contain: letters, numbers, hyphens, dots, commas and spaces.
   * @return name
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "User defined name of the shipping rates set. It may only contain: letters, numbers, hyphens, dots, commas and spaces.")

  public String getName() {
    return name;
  }



  public void setName(String name) {
    this.name = name;
  }


  public ShippingRatesSet rates(List<ShippingRate> rates) {
    
    this.rates = rates;
    return this;
  }

  public ShippingRatesSet addRatesItem(ShippingRate ratesItem) {
    this.rates.add(ratesItem);
    return this;
  }

   /**
   * Get rates
   * @return rates
  **/
  @ApiModelProperty(required = true, value = "")

  public List<ShippingRate> getRates() {
    return rates;
  }



  public void setRates(List<ShippingRate> rates) {
    this.rates = rates;
  }


  public ShippingRatesSet lastModified(String lastModified) {
    
    this.lastModified = lastModified;
    return this;
  }

   /**
   * Date and time of the last modification of the set in UTC ISO 8601 format. When creating (Post) or updating (Put) a shipping rates set the field is ignored.
   * @return lastModified
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Date and time of the last modification of the set in UTC ISO 8601 format. When creating (Post) or updating (Put) a shipping rates set the field is ignored.")

  public String getLastModified() {
    return lastModified;
  }



  public void setLastModified(String lastModified) {
    this.lastModified = lastModified;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ShippingRatesSet shippingRatesSet = (ShippingRatesSet) o;
    return Objects.equals(this.id, shippingRatesSet.id) &&
        Objects.equals(this.name, shippingRatesSet.name) &&
        Objects.equals(this.rates, shippingRatesSet.rates) &&
        Objects.equals(this.lastModified, shippingRatesSet.lastModified);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, rates, lastModified);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ShippingRatesSet {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    rates: ").append(toIndentedString(rates)).append("\n");
    sb.append("    lastModified: ").append(toIndentedString(lastModified)).append("\n");
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

