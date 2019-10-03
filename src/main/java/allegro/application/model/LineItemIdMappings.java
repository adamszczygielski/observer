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
 * LineItemIdMappings
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2019-09-16T16:12:46.567+02:00[Europe/Belgrade]")
public class LineItemIdMappings {
  public static final String SERIALIZED_NAME_MAPPINGS = "mappings";
  @SerializedName(SERIALIZED_NAME_MAPPINGS)
  private List<LineItemIdMappingsMappings> mappings = null;


  public LineItemIdMappings mappings(List<LineItemIdMappingsMappings> mappings) {
    
    this.mappings = mappings;
    return this;
  }

  public LineItemIdMappings addMappingsItem(LineItemIdMappingsMappings mappingsItem) {
    if (this.mappings == null) {
      this.mappings = new ArrayList<LineItemIdMappingsMappings>();
    }
    this.mappings.add(mappingsItem);
    return this;
  }

   /**
   * Get mappings
   * @return mappings
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public List<LineItemIdMappingsMappings> getMappings() {
    return mappings;
  }



  public void setMappings(List<LineItemIdMappingsMappings> mappings) {
    this.mappings = mappings;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LineItemIdMappings lineItemIdMappings = (LineItemIdMappings) o;
    return Objects.equals(this.mappings, lineItemIdMappings.mappings);
  }

  @Override
  public int hashCode() {
    return Objects.hash(mappings);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LineItemIdMappings {\n");
    sb.append("    mappings: ").append(toIndentedString(mappings)).append("\n");
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

