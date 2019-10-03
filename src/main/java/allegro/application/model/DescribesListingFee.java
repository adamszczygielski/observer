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
 * DescribesListingFee
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2019-09-16T16:12:46.567+02:00[Europe/Belgrade]")
public class DescribesListingFee {
  public static final String SERIALIZED_NAME_FEE = "fee";
  @SerializedName(SERIALIZED_NAME_FEE)
  private Fee fee;

  public static final String SERIALIZED_NAME_NAME = "name";
  @SerializedName(SERIALIZED_NAME_NAME)
  private String name;

  public static final String SERIALIZED_NAME_TYPE = "type";
  @SerializedName(SERIALIZED_NAME_TYPE)
  private String type;

  public static final String SERIALIZED_NAME_CYCLE_DURATION = "cycleDuration";
  @SerializedName(SERIALIZED_NAME_CYCLE_DURATION)
  private String cycleDuration;


  public DescribesListingFee fee(Fee fee) {
    
    this.fee = fee;
    return this;
  }

   /**
   * Get fee
   * @return fee
  **/
  @ApiModelProperty(required = true, value = "")

  public Fee getFee() {
    return fee;
  }



  public void setFee(Fee fee) {
    this.fee = fee;
  }


  public DescribesListingFee name(String name) {
    
    this.name = name;
    return this;
  }

   /**
   * Get name
   * @return name
  **/
  @ApiModelProperty(required = true, value = "")

  public String getName() {
    return name;
  }



  public void setName(String name) {
    this.name = name;
  }


  public DescribesListingFee type(String type) {
    
    this.type = type;
    return this;
  }

   /**
   * Get type
   * @return type
  **/
  @ApiModelProperty(required = true, value = "")

  public String getType() {
    return type;
  }



  public void setType(String type) {
    this.type = type;
  }


  public DescribesListingFee cycleDuration(String cycleDuration) {
    
    this.cycleDuration = cycleDuration;
    return this;
  }

   /**
   * Pricing cycle duration, ISO 8601 duration format
   * @return cycleDuration
  **/
  @ApiModelProperty(example = "PT240H", required = true, value = "Pricing cycle duration, ISO 8601 duration format")

  public String getCycleDuration() {
    return cycleDuration;
  }



  public void setCycleDuration(String cycleDuration) {
    this.cycleDuration = cycleDuration;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DescribesListingFee describesListingFee = (DescribesListingFee) o;
    return Objects.equals(this.fee, describesListingFee.fee) &&
        Objects.equals(this.name, describesListingFee.name) &&
        Objects.equals(this.type, describesListingFee.type) &&
        Objects.equals(this.cycleDuration, describesListingFee.cycleDuration);
  }

  @Override
  public int hashCode() {
    return Objects.hash(fee, name, type, cycleDuration);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DescribesListingFee {\n");
    sb.append("    fee: ").append(toIndentedString(fee)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    cycleDuration: ").append(toIndentedString(cycleDuration)).append("\n");
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

