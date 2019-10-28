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
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Objects;

/**
 * Rules for the shipping time.
 */
@ApiModel(description = "Rules for the shipping time.")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2019-09-16T16:12:46.567+02:00[Europe/Belgrade]")
public class InlineResponse2001ShippingRatesConstraintsShippingTime {
  public static final String SERIALIZED_NAME_DEFAULT = "default";
  @SerializedName(SERIALIZED_NAME_DEFAULT)
  private InlineResponse2001ShippingRatesConstraintsShippingTimeDefault _default;

  public static final String SERIALIZED_NAME_CUSTOMIZABLE = "customizable";
  @SerializedName(SERIALIZED_NAME_CUSTOMIZABLE)
  private Boolean customizable;


  public InlineResponse2001ShippingRatesConstraintsShippingTime _default(InlineResponse2001ShippingRatesConstraintsShippingTimeDefault _default) {
    
    this._default = _default;
    return this;
  }

   /**
   * Get _default
   * @return _default
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public InlineResponse2001ShippingRatesConstraintsShippingTimeDefault getDefault() {
    return _default;
  }



  public void setDefault(InlineResponse2001ShippingRatesConstraintsShippingTimeDefault _default) {
    this._default = _default;
  }


  public InlineResponse2001ShippingRatesConstraintsShippingTime customizable(Boolean customizable) {
    
    this.customizable = customizable;
    return this;
  }

   /**
   * Indicates if custom shipping time can be set when adding or modifying shipping rates.
   * @return customizable
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Indicates if custom shipping time can be set when adding or modifying shipping rates.")

  public Boolean getCustomizable() {
    return customizable;
  }



  public void setCustomizable(Boolean customizable) {
    this.customizable = customizable;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    InlineResponse2001ShippingRatesConstraintsShippingTime inlineResponse2001ShippingRatesConstraintsShippingTime = (InlineResponse2001ShippingRatesConstraintsShippingTime) o;
    return Objects.equals(this._default, inlineResponse2001ShippingRatesConstraintsShippingTime._default) &&
        Objects.equals(this.customizable, inlineResponse2001ShippingRatesConstraintsShippingTime.customizable);
  }

  @Override
  public int hashCode() {
    return Objects.hash(_default, customizable);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InlineResponse2001ShippingRatesConstraintsShippingTime {\n");
    sb.append("    _default: ").append(toIndentedString(_default)).append("\n");
    sb.append("    customizable: ").append(toIndentedString(customizable)).append("\n");
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
