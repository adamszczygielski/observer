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
 * CheckoutFormDeliveryTime
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2019-09-16T16:12:46.567+02:00[Europe/Belgrade]")
public class CheckoutFormDeliveryTime {
  public static final String SERIALIZED_NAME_GUARANTEED = "guaranteed";
  @SerializedName(SERIALIZED_NAME_GUARANTEED)
  private CheckoutFormDeliveryTimeGuaranteed guaranteed;


  public CheckoutFormDeliveryTime guaranteed(CheckoutFormDeliveryTimeGuaranteed guaranteed) {
    
    this.guaranteed = guaranteed;
    return this;
  }

   /**
   * Get guaranteed
   * @return guaranteed
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public CheckoutFormDeliveryTimeGuaranteed getGuaranteed() {
    return guaranteed;
  }



  public void setGuaranteed(CheckoutFormDeliveryTimeGuaranteed guaranteed) {
    this.guaranteed = guaranteed;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CheckoutFormDeliveryTime checkoutFormDeliveryTime = (CheckoutFormDeliveryTime) o;
    return Objects.equals(this.guaranteed, checkoutFormDeliveryTime.guaranteed);
  }

  @Override
  public int hashCode() {
    return Objects.hash(guaranteed);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CheckoutFormDeliveryTime {\n");
    sb.append("    guaranteed: ").append(toIndentedString(guaranteed)).append("\n");
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
