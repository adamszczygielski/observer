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
 * DisputeAttachment
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2019-09-16T16:12:46.567+02:00[Europe/Belgrade]")
public class DisputeAttachment {
  public static final String SERIALIZED_NAME_FILE_NAME = "fileName";
  @SerializedName(SERIALIZED_NAME_FILE_NAME)
  private String fileName;

  public static final String SERIALIZED_NAME_URL = "url";
  @SerializedName(SERIALIZED_NAME_URL)
  private String url;


  public DisputeAttachment fileName(String fileName) {
    
    this.fileName = fileName;
    return this;
  }

   /**
   * Get fileName
   * @return fileName
  **/
  @ApiModelProperty(required = true, value = "")

  public String getFileName() {
    return fileName;
  }



  public void setFileName(String fileName) {
    this.fileName = fileName;
  }


  public DisputeAttachment url(String url) {
    
    this.url = url;
    return this;
  }

   /**
   * Direct link to the attachment
   * @return url
  **/
  @ApiModelProperty(example = "https://upload.allegro.pl/sale/dispute-attachments/eeed0007-4404-4176-a1eb-11d26f056c0d", required = true, value = "Direct link to the attachment")

  public String getUrl() {
    return url;
  }



  public void setUrl(String url) {
    this.url = url;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DisputeAttachment disputeAttachment = (DisputeAttachment) o;
    return Objects.equals(this.fileName, disputeAttachment.fileName) &&
        Objects.equals(this.url, disputeAttachment.url);
  }

  @Override
  public int hashCode() {
    return Objects.hash(fileName, url);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DisputeAttachment {\n");
    sb.append("    fileName: ").append(toIndentedString(fileName)).append("\n");
    sb.append("    url: ").append(toIndentedString(url)).append("\n");
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

