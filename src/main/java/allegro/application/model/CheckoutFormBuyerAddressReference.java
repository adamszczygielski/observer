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
 * Buyer address
 */
@ApiModel(description = "Buyer address")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2019-09-16T16:12:46.567+02:00[Europe/Belgrade]")
public class CheckoutFormBuyerAddressReference {
  public static final String SERIALIZED_NAME_STREET = "street";
  @SerializedName(SERIALIZED_NAME_STREET)
  private String street;

  public static final String SERIALIZED_NAME_CITY = "city";
  @SerializedName(SERIALIZED_NAME_CITY)
  private String city;

  public static final String SERIALIZED_NAME_POST_CODE = "postCode";
  @SerializedName(SERIALIZED_NAME_POST_CODE)
  private String postCode;

  public static final String SERIALIZED_NAME_COUNTRY_CODE = "countryCode";
  @SerializedName(SERIALIZED_NAME_COUNTRY_CODE)
  private String countryCode;


  public CheckoutFormBuyerAddressReference street(String street) {
    
    this.street = street;
    return this;
  }

   /**
   * Street
   * @return street
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "Solna", value = "Street")

  public String getStreet() {
    return street;
  }



  public void setStreet(String street) {
    this.street = street;
  }


  public CheckoutFormBuyerAddressReference city(String city) {
    
    this.city = city;
    return this;
  }

   /**
   * City name
   * @return city
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "Poznań", value = "City name")

  public String getCity() {
    return city;
  }



  public void setCity(String city) {
    this.city = city;
  }


  public CheckoutFormBuyerAddressReference postCode(String postCode) {
    
    this.postCode = postCode;
    return this;
  }

   /**
   * Postal code
   * @return postCode
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "60-166", value = "Postal code")

  public String getPostCode() {
    return postCode;
  }



  public void setPostCode(String postCode) {
    this.postCode = postCode;
  }


  public CheckoutFormBuyerAddressReference countryCode(String countryCode) {
    
    this.countryCode = countryCode;
    return this;
  }

   /**
   * Country code
   * @return countryCode
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "PL", value = "Country code")

  public String getCountryCode() {
    return countryCode;
  }



  public void setCountryCode(String countryCode) {
    this.countryCode = countryCode;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CheckoutFormBuyerAddressReference checkoutFormBuyerAddressReference = (CheckoutFormBuyerAddressReference) o;
    return Objects.equals(this.street, checkoutFormBuyerAddressReference.street) &&
        Objects.equals(this.city, checkoutFormBuyerAddressReference.city) &&
        Objects.equals(this.postCode, checkoutFormBuyerAddressReference.postCode) &&
        Objects.equals(this.countryCode, checkoutFormBuyerAddressReference.countryCode);
  }

  @Override
  public int hashCode() {
    return Objects.hash(street, city, postCode, countryCode);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CheckoutFormBuyerAddressReference {\n");
    sb.append("    street: ").append(toIndentedString(street)).append("\n");
    sb.append("    city: ").append(toIndentedString(city)).append("\n");
    sb.append("    postCode: ").append(toIndentedString(postCode)).append("\n");
    sb.append("    countryCode: ").append(toIndentedString(countryCode)).append("\n");
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

