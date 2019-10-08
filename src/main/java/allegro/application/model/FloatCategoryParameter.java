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
 * FloatCategoryParameter
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2019-09-16T16:12:46.567+02:00[Europe/Belgrade]")
public class FloatCategoryParameter extends CategoryParameter {
  public static final String SERIALIZED_NAME_TYPE = "type";
  @SerializedName(SERIALIZED_NAME_TYPE)
  private String type = "float";

  public static final String SERIALIZED_NAME_RESTRICTIONS = "restrictions";
  @SerializedName(SERIALIZED_NAME_RESTRICTIONS)
  private FloatCategoryProductParameterAllOfRestrictions restrictions;


  public FloatCategoryParameter type(String type) {
    
    this.type = type;
    return this;
  }

   /**
   * Get type
   * @return type
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getType() {
    return "";
  }



  public void setType(String type) {
    this.type = type;
  }


  public FloatCategoryParameter restrictions(FloatCategoryProductParameterAllOfRestrictions restrictions) {
    
    this.restrictions = restrictions;
    return this;
  }

   /**
   * Get restrictions
   * @return restrictions
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public FloatCategoryProductParameterAllOfRestrictions getRestrictions() {
    return restrictions;
  }



  public void setRestrictions(FloatCategoryProductParameterAllOfRestrictions restrictions) {
    this.restrictions = restrictions;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FloatCategoryParameter floatCategoryParameter = (FloatCategoryParameter) o;
    return Objects.equals(this.type, floatCategoryParameter.type) &&
        Objects.equals(this.restrictions, floatCategoryParameter.restrictions) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, restrictions, super.hashCode());
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FloatCategoryParameter {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    restrictions: ").append(toIndentedString(restrictions)).append("\n");
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
