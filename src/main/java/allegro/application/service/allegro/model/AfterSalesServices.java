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
 * The definitions of the different after sales services assigned to the offer.
 */
@ApiModel(description = "The definitions of the different after sales services assigned to the offer.")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2019-09-16T16:12:46.567+02:00[Europe/Belgrade]")
public class AfterSalesServices {
  public static final String SERIALIZED_NAME_IMPLIED_WARRANTY = "impliedWarranty";
  @SerializedName(SERIALIZED_NAME_IMPLIED_WARRANTY)
  private ImpliedWarranty impliedWarranty;

  public static final String SERIALIZED_NAME_RETURN_POLICY = "returnPolicy";
  @SerializedName(SERIALIZED_NAME_RETURN_POLICY)
  private ReturnPolicy returnPolicy;

  public static final String SERIALIZED_NAME_WARRANTY = "warranty";
  @SerializedName(SERIALIZED_NAME_WARRANTY)
  private Warranty warranty;


  public AfterSalesServices impliedWarranty(ImpliedWarranty impliedWarranty) {
    
    this.impliedWarranty = impliedWarranty;
    return this;
  }

   /**
   * Get impliedWarranty
   * @return impliedWarranty
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public ImpliedWarranty getImpliedWarranty() {
    return impliedWarranty;
  }



  public void setImpliedWarranty(ImpliedWarranty impliedWarranty) {
    this.impliedWarranty = impliedWarranty;
  }


  public AfterSalesServices returnPolicy(ReturnPolicy returnPolicy) {
    
    this.returnPolicy = returnPolicy;
    return this;
  }

   /**
   * Get returnPolicy
   * @return returnPolicy
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public ReturnPolicy getReturnPolicy() {
    return returnPolicy;
  }



  public void setReturnPolicy(ReturnPolicy returnPolicy) {
    this.returnPolicy = returnPolicy;
  }


  public AfterSalesServices warranty(Warranty warranty) {
    
    this.warranty = warranty;
    return this;
  }

   /**
   * Get warranty
   * @return warranty
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Warranty getWarranty() {
    return warranty;
  }



  public void setWarranty(Warranty warranty) {
    this.warranty = warranty;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AfterSalesServices afterSalesServices = (AfterSalesServices) o;
    return Objects.equals(this.impliedWarranty, afterSalesServices.impliedWarranty) &&
        Objects.equals(this.returnPolicy, afterSalesServices.returnPolicy) &&
        Objects.equals(this.warranty, afterSalesServices.warranty);
  }

  @Override
  public int hashCode() {
    return Objects.hash(impliedWarranty, returnPolicy, warranty);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AfterSalesServices {\n");
    sb.append("    impliedWarranty: ").append(toIndentedString(impliedWarranty)).append("\n");
    sb.append("    returnPolicy: ").append(toIndentedString(returnPolicy)).append("\n");
    sb.append("    warranty: ").append(toIndentedString(warranty)).append("\n");
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
