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
 * CompatibilityListIdItemAllOf
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2019-09-16T16:12:46.567+02:00[Europe/Belgrade]")
public class CompatibilityListIdItemAllOf {
  public static final String SERIALIZED_NAME_TYPE = "type";
  @SerializedName(SERIALIZED_NAME_TYPE)
  private String type = "ID";

  public static final String SERIALIZED_NAME_ID = "id";
  @SerializedName(SERIALIZED_NAME_ID)
  private String id;

  public static final String SERIALIZED_NAME_TEXT = "text";
  @SerializedName(SERIALIZED_NAME_TEXT)
  private String text;

  public static final String SERIALIZED_NAME_ADDITIONAL_INFO = "additionalInfo";
  @SerializedName(SERIALIZED_NAME_ADDITIONAL_INFO)
  private List<CompatibilityListIdItemAdditionalInfo> additionalInfo = null;


  public CompatibilityListIdItemAllOf type(String type) {
    
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
    return type;
  }



  public void setType(String type) {
    this.type = type;
  }


  public CompatibilityListIdItemAllOf id(String id) {
    
    this.id = id;
    return this;
  }

   /**
   * Id of the compatible item. Should be used in categories where ID version of compatible list is supported. See &lt;a href&#x3D;\&quot;/documentation/#tag/Compatibility-List/paths/~1sale~1compatibility-list~1supported-categories/get\&quot;&gt; supported-categories&lt;/a&gt; resource. &lt;a href&#x3D;\&quot;../../compatibility_list\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Read more&lt;/a&gt;.
   * @return id
  **/
  @ApiModelProperty(example = "0006563f-f2b9-44ea-ae67-4678679be1f1", required = true, value = "Id of the compatible item. Should be used in categories where ID version of compatible list is supported. See <a href=\"/documentation/#tag/Compatibility-List/paths/~1sale~1compatibility-list~1supported-categories/get\"> supported-categories</a> resource. <a href=\"../../compatibility_list\" target=\"_blank\">Read more</a>.")

  public String getId() {
    return id;
  }



  public void setId(String id) {
    this.id = id;
  }


  public CompatibilityListIdItemAllOf text(String text) {
    
    this.text = text;
    return this;
  }

   /**
   * Text description of the compatible item. When creating (Post) or updating (Put) a compatibility list the field is ignored.
   * @return text
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "CITROËN C6 (TD_) 2005/09-2011/12 2.7 HDi 204KM/150kW", value = "Text description of the compatible item. When creating (Post) or updating (Put) a compatibility list the field is ignored.")

  public String getText() {
    return text;
  }



  public void setText(String text) {
    this.text = text;
  }


  public CompatibilityListIdItemAllOf additionalInfo(List<CompatibilityListIdItemAdditionalInfo> additionalInfo) {
    
    this.additionalInfo = additionalInfo;
    return this;
  }

  public CompatibilityListIdItemAllOf addAdditionalInfoItem(CompatibilityListIdItemAdditionalInfo additionalInfoItem) {
    if (this.additionalInfo == null) {
      this.additionalInfo = new ArrayList<CompatibilityListIdItemAdditionalInfo>();
    }
    this.additionalInfo.add(additionalInfoItem);
    return this;
  }

   /**
   * Details of the compatible item represented by ID.
   * @return additionalInfo
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Details of the compatible item represented by ID.")

  public List<CompatibilityListIdItemAdditionalInfo> getAdditionalInfo() {
    return additionalInfo;
  }



  public void setAdditionalInfo(List<CompatibilityListIdItemAdditionalInfo> additionalInfo) {
    this.additionalInfo = additionalInfo;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CompatibilityListIdItemAllOf compatibilityListIdItemAllOf = (CompatibilityListIdItemAllOf) o;
    return Objects.equals(this.type, compatibilityListIdItemAllOf.type) &&
        Objects.equals(this.id, compatibilityListIdItemAllOf.id) &&
        Objects.equals(this.text, compatibilityListIdItemAllOf.text) &&
        Objects.equals(this.additionalInfo, compatibilityListIdItemAllOf.additionalInfo);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, id, text, additionalInfo);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CompatibilityListIdItemAllOf {\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    text: ").append(toIndentedString(text)).append("\n");
    sb.append("    additionalInfo: ").append(toIndentedString(additionalInfo)).append("\n");
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
