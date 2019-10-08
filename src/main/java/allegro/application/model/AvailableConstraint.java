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
 * AvailableConstraint
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2019-09-16T16:12:46.567+02:00[Europe/Belgrade]")
public class AvailableConstraint {
  public static final String SERIALIZED_NAME_TYPE = "type";
  @SerializedName(SERIALIZED_NAME_TYPE)
  private String type;

  public static final String SERIALIZED_NAME_AVAILABLE_DELIVERY_METHODS = "availableDeliveryMethods";
  @SerializedName(SERIALIZED_NAME_AVAILABLE_DELIVERY_METHODS)
  private List<String> availableDeliveryMethods = null;


  public AvailableConstraint type(String type) {
    
    this.type = type;
    return this;
  }

   /**
   * One of the type COUNTRY_SAME_QUANTITY or COUNTRY_DELIVERY_SAME_QUANTITY
   * @return type
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "One of the type COUNTRY_SAME_QUANTITY or COUNTRY_DELIVERY_SAME_QUANTITY")

  public String getType() {
    return type;
  }



  public void setType(String type) {
    this.type = type;
  }


  public AvailableConstraint availableDeliveryMethods(List<String> availableDeliveryMethods) {
    
    this.availableDeliveryMethods = availableDeliveryMethods;
    return this;
  }

  public AvailableConstraint addAvailableDeliveryMethodsItem(String availableDeliveryMethodsItem) {
    if (this.availableDeliveryMethods == null) {
      this.availableDeliveryMethods = new ArrayList<String>();
    }
    this.availableDeliveryMethods.add(availableDeliveryMethodsItem);
    return this;
  }

   /**
   * Get availableDeliveryMethods
   * @return availableDeliveryMethods
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public List<String> getAvailableDeliveryMethods() {
    return availableDeliveryMethods;
  }



  public void setAvailableDeliveryMethods(List<String> availableDeliveryMethods) {
    this.availableDeliveryMethods = availableDeliveryMethods;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AvailableConstraint availableConstraint = (AvailableConstraint) o;
    return Objects.equals(this.type, availableConstraint.type) &&
        Objects.equals(this.availableDeliveryMethods, availableConstraint.availableDeliveryMethods);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, availableDeliveryMethods);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AvailableConstraint {\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    availableDeliveryMethods: ").append(toIndentedString(availableDeliveryMethods)).append("\n");
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
