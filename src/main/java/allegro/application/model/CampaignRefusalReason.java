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
 * CampaignRefusalReason
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2019-09-16T16:12:46.567+02:00[Europe/Belgrade]")
public class CampaignRefusalReason {
  public static final String SERIALIZED_NAME_CODE = "code";
  @SerializedName(SERIALIZED_NAME_CODE)
  private String code;

  public static final String SERIALIZED_NAME_MESSAGES = "messages";
  @SerializedName(SERIALIZED_NAME_MESSAGES)
  private List<RefusalMessage> messages = new ArrayList<RefusalMessage>();


  public CampaignRefusalReason code(String code) {
    
    this.code = code;
    return this;
  }

   /**
   * Code corresponding to the message. For more information visit &lt;a href&#x3D;\&quot;/badge/#6\&quot; target&#x3D;\&quot;_blank\&quot;&gt;the list of available codes&lt;/a&gt;.
   * @return code
  **/
  @ApiModelProperty(required = true, value = "Code corresponding to the message. For more information visit <a href=\"/badge/#6\" target=\"_blank\">the list of available codes</a>.")

  public String getCode() {
    return code;
  }



  public void setCode(String code) {
    this.code = code;
  }


  public CampaignRefusalReason messages(List<RefusalMessage> messages) {
    
    this.messages = messages;
    return this;
  }

  public CampaignRefusalReason addMessagesItem(RefusalMessage messagesItem) {
    this.messages.add(messagesItem);
    return this;
  }

   /**
   * List of refusal messages.
   * @return messages
  **/
  @ApiModelProperty(required = true, value = "List of refusal messages.")

  public List<RefusalMessage> getMessages() {
    return messages;
  }



  public void setMessages(List<RefusalMessage> messages) {
    this.messages = messages;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CampaignRefusalReason campaignRefusalReason = (CampaignRefusalReason) o;
    return Objects.equals(this.code, campaignRefusalReason.code) &&
        Objects.equals(this.messages, campaignRefusalReason.messages);
  }

  @Override
  public int hashCode() {
    return Objects.hash(code, messages);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CampaignRefusalReason {\n");
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("    messages: ").append(toIndentedString(messages)).append("\n");
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

