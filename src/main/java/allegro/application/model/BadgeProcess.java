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

import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Information about badge processing.
 */
@ApiModel(description = "Information about badge processing.")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2019-09-16T16:12:46.567+02:00[Europe/Belgrade]")
public class BadgeProcess {
  /**
   * Gets or Sets status
   */
  @JsonAdapter(StatusEnum.Adapter.class)
  public enum StatusEnum {
    IN_VERIFICATION("IN_VERIFICATION"),
    
    WAITING_FOR_PUBLICATION("WAITING_FOR_PUBLICATION"),
    
    ACTIVE("ACTIVE"),
    
    FINISHED("FINISHED"),
    
    DECLINED("DECLINED");

    private String value;

    StatusEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static StatusEnum fromValue(String value) {
      for (StatusEnum b : StatusEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<StatusEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final StatusEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public StatusEnum read(final JsonReader jsonReader) throws IOException {
        String value = jsonReader.nextString();
        return StatusEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_STATUS = "status";
  @SerializedName(SERIALIZED_NAME_STATUS)
  private StatusEnum status;

  public static final String SERIALIZED_NAME_REJECTION_REASONS = "rejectionReasons";
  @SerializedName(SERIALIZED_NAME_REJECTION_REASONS)
  private List<BadgeApplicationRejectionReason> rejectionReasons = new ArrayList<BadgeApplicationRejectionReason>();


  public BadgeProcess status(StatusEnum status) {
    
    this.status = status;
    return this;
  }

   /**
   * Get status
   * @return status
  **/
  @ApiModelProperty(required = true, value = "")

  public StatusEnum getStatus() {
    return status;
  }



  public void setStatus(StatusEnum status) {
    this.status = status;
  }


  public BadgeProcess rejectionReasons(List<BadgeApplicationRejectionReason> rejectionReasons) {
    
    this.rejectionReasons = rejectionReasons;
    return this;
  }

  public BadgeProcess addRejectionReasonsItem(BadgeApplicationRejectionReason rejectionReasonsItem) {
    this.rejectionReasons.add(rejectionReasonsItem);
    return this;
  }

   /**
   * A list of messages with rejection reasons. Returned for process.status &#x3D; DECLINED only.
   * @return rejectionReasons
  **/
  @ApiModelProperty(required = true, value = "A list of messages with rejection reasons. Returned for process.status = DECLINED only.")

  public List<BadgeApplicationRejectionReason> getRejectionReasons() {
    return rejectionReasons;
  }



  public void setRejectionReasons(List<BadgeApplicationRejectionReason> rejectionReasons) {
    this.rejectionReasons = rejectionReasons;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BadgeProcess badgeProcess = (BadgeProcess) o;
    return Objects.equals(this.status, badgeProcess.status) &&
        Objects.equals(this.rejectionReasons, badgeProcess.rejectionReasons);
  }

  @Override
  public int hashCode() {
    return Objects.hash(status, rejectionReasons);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BadgeProcess {\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    rejectionReasons: ").append(toIndentedString(rejectionReasons)).append("\n");
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

