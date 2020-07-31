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


package observer.application.service.source.allegro.model;

import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.annotations.ApiModelProperty;
import org.threeten.bp.OffsetDateTime;

import java.io.IOException;
import java.util.Objects;

/**
 * Publication
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2019-09-16T16:12:46.567+02:00[Europe/Belgrade]")
public class Publication {
  public static final String SERIALIZED_NAME_DURATION = "duration";
  @SerializedName(SERIALIZED_NAME_DURATION)
  private String duration;

  public static final String SERIALIZED_NAME_ENDING_AT = "endingAt";
  @SerializedName(SERIALIZED_NAME_ENDING_AT)
  private OffsetDateTime endingAt;

  public static final String SERIALIZED_NAME_STARTING_AT = "startingAt";
  @SerializedName(SERIALIZED_NAME_STARTING_AT)
  private OffsetDateTime startingAt;

  public static final String SERIALIZED_NAME_STATUS = "status";
  @SerializedName(SERIALIZED_NAME_STATUS)
  private OfferStatus status;

  /**
   * Indicates the reason for ending the offer:  - &#x60;USER&#x60; - offer ended by the seller.  - &#x60;ADMIN&#x60; - offer ended by an admin.  - &#x60;EXPIRATION&#x60; - offer ended because all available items had been sold out or offer duration had expired (valid for    offers with specified duration).  - &#x60;ERROR&#x60; - offer ended due to internal problem with offer publication. The publication command responded with    success status, but further processing failed.
   */
  @JsonAdapter(EndedByEnum.Adapter.class)
  public enum EndedByEnum {
    USER("USER"),
    
    ADMIN("ADMIN"),
    
    EXPIRATION("EXPIRATION"),
    
    ERROR("ERROR");

    private String value;

    EndedByEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static EndedByEnum fromValue(String value) {
      for (EndedByEnum b : EndedByEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<EndedByEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final EndedByEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public EndedByEnum read(final JsonReader jsonReader) throws IOException {
        String value = jsonReader.nextString();
        return EndedByEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_ENDED_BY = "endedBy";
  @SerializedName(SERIALIZED_NAME_ENDED_BY)
  private EndedByEnum endedBy;

  public static final String SERIALIZED_NAME_REPUBLISH = "republish";
  @SerializedName(SERIALIZED_NAME_REPUBLISH)
  private Boolean republish;


  public Publication duration(String duration) {
    
    this.duration = duration;
    return this;
  }

   /**
   * Publication duration, ISO 8601 duration format
   * @return duration
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "PDT12H30M5S", value = "Publication duration, ISO 8601 duration format")

  public String getDuration() {
    return duration;
  }



  public void setDuration(String duration) {
    this.duration = duration;
  }


  public Publication endingAt(OffsetDateTime endingAt) {
    
    this.endingAt = endingAt;
    return this;
  }

   /**
   * Publication ending date: Format (ISO 8601) - yyyy-MM-dd&#39;T&#39;HH:mm:ss.SSSZ. Cannot be modified
   * @return endingAt
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Publication ending date: Format (ISO 8601) - yyyy-MM-dd'T'HH:mm:ss.SSSZ. Cannot be modified")

  public OffsetDateTime getEndingAt() {
    return endingAt;
  }



  public void setEndingAt(OffsetDateTime endingAt) {
    this.endingAt = endingAt;
  }


  public Publication startingAt(OffsetDateTime startingAt) {
    
    this.startingAt = startingAt;
    return this;
  }

   /**
   * Publication starting date: Format (ISO 8601) - yyyy-MM-dd&#39;T&#39;HH:mm:ss.SSSZ. Cannot be modified
   * @return startingAt
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Publication starting date: Format (ISO 8601) - yyyy-MM-dd'T'HH:mm:ss.SSSZ. Cannot be modified")

  public OffsetDateTime getStartingAt() {
    return startingAt;
  }



  public void setStartingAt(OffsetDateTime startingAt) {
    this.startingAt = startingAt;
  }


  public Publication status(OfferStatus status) {
    
    this.status = status;
    return this;
  }

   /**
   * Get status
   * @return status
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public OfferStatus getStatus() {
    return status;
  }



  public void setStatus(OfferStatus status) {
    this.status = status;
  }


  public Publication endedBy(EndedByEnum endedBy) {
    
    this.endedBy = endedBy;
    return this;
  }

   /**
   * Indicates the reason for ending the offer:  - &#x60;USER&#x60; - offer ended by the seller.  - &#x60;ADMIN&#x60; - offer ended by an admin.  - &#x60;EXPIRATION&#x60; - offer ended because all available items had been sold out or offer duration had expired (valid for    offers with specified duration).  - &#x60;ERROR&#x60; - offer ended due to internal problem with offer publication. The publication command responded with    success status, but further processing failed.
   * @return endedBy
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Indicates the reason for ending the offer:  - `USER` - offer ended by the seller.  - `ADMIN` - offer ended by an admin.  - `EXPIRATION` - offer ended because all available items had been sold out or offer duration had expired (valid for    offers with specified duration).  - `ERROR` - offer ended due to internal problem with offer publication. The publication command responded with    success status, but further processing failed.")

  public EndedByEnum getEndedBy() {
    return endedBy;
  }



  public void setEndedBy(EndedByEnum endedBy) {
    this.endedBy = endedBy;
  }


  public Publication republish(Boolean republish) {
    
    this.republish = republish;
    return this;
  }

   /**
   * Whether to republish an offer after ending. Automatically republish offers or auctions:&lt;/br&gt; - &#x60;BUY_NOW&#x60; offer type are republished with initial stock, regardless of how many items you have sold.&lt;/br&gt; - &#x60;AUCTION&#x60; offer type are republished only if they were not concluded with purchase.&lt;/br&gt; - &#x60;ADVERTISEMENT&#x60; offer type cannot be republished.
   * @return republish
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "false", value = "Whether to republish an offer after ending. Automatically republish offers or auctions:</br> - `BUY_NOW` offer type are republished with initial stock, regardless of how many items you have sold.</br> - `AUCTION` offer type are republished only if they were not concluded with purchase.</br> - `ADVERTISEMENT` offer type cannot be republished.")

  public Boolean getRepublish() {
    return republish;
  }



  public void setRepublish(Boolean republish) {
    this.republish = republish;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Publication publication = (Publication) o;
    return Objects.equals(this.duration, publication.duration) &&
        Objects.equals(this.endingAt, publication.endingAt) &&
        Objects.equals(this.startingAt, publication.startingAt) &&
        Objects.equals(this.status, publication.status) &&
        Objects.equals(this.endedBy, publication.endedBy) &&
        Objects.equals(this.republish, publication.republish);
  }

  @Override
  public int hashCode() {
    return Objects.hash(duration, endingAt, startingAt, status, endedBy, republish);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Publication {\n");
    sb.append("    duration: ").append(toIndentedString(duration)).append("\n");
    sb.append("    endingAt: ").append(toIndentedString(endingAt)).append("\n");
    sb.append("    startingAt: ").append(toIndentedString(startingAt)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    endedBy: ").append(toIndentedString(endedBy)).append("\n");
    sb.append("    republish: ").append(toIndentedString(republish)).append("\n");
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
