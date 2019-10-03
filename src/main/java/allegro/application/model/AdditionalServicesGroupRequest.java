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
 * AdditionalServicesGroupRequest
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2019-09-16T16:12:46.567+02:00[Europe/Belgrade]")
public class AdditionalServicesGroupRequest {
  public static final String SERIALIZED_NAME_NAME = "name";
  @SerializedName(SERIALIZED_NAME_NAME)
  private String name;

  public static final String SERIALIZED_NAME_ADDITIONAL_SERVICES = "additionalServices";
  @SerializedName(SERIALIZED_NAME_ADDITIONAL_SERVICES)
  private List<AdditionalServiceRequest> additionalServices = new ArrayList<AdditionalServiceRequest>();


  public AdditionalServicesGroupRequest name(String name) {
    
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


  public AdditionalServicesGroupRequest additionalServices(List<AdditionalServiceRequest> additionalServices) {
    
    this.additionalServices = additionalServices;
    return this;
  }

  public AdditionalServicesGroupRequest addAdditionalServicesItem(AdditionalServiceRequest additionalServicesItem) {
    this.additionalServices.add(additionalServicesItem);
    return this;
  }

   /**
   * Get additionalServices
   * @return additionalServices
  **/
  @ApiModelProperty(required = true, value = "")

  public List<AdditionalServiceRequest> getAdditionalServices() {
    return additionalServices;
  }



  public void setAdditionalServices(List<AdditionalServiceRequest> additionalServices) {
    this.additionalServices = additionalServices;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AdditionalServicesGroupRequest additionalServicesGroupRequest = (AdditionalServicesGroupRequest) o;
    return Objects.equals(this.name, additionalServicesGroupRequest.name) &&
        Objects.equals(this.additionalServices, additionalServicesGroupRequest.additionalServices);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, additionalServices);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AdditionalServicesGroupRequest {\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    additionalServices: ").append(toIndentedString(additionalServices)).append("\n");
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

