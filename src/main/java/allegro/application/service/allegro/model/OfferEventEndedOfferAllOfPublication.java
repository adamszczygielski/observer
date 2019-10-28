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

import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.threeten.bp.OffsetDateTime;

import java.io.IOException;
import java.util.Objects;

/**
 * Information about publication of the given offer.
 */
@ApiModel(description = "Information about publication of the given offer.")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2019-09-16T16:12:46.567+02:00[Europe/Belgrade]")
public class OfferEventEndedOfferAllOfPublication {
  /**
   * Indicates the reason for ending the offer:  - &#x60;USER&#x60; - offer ended by the seller.  - &#x60;ADMIN&#x60; - offer ended by an admin.  - &#x60;EXPIRATION&#x60; - offer ended because all available items had been sold out or offer duration had expired (valid for    offers with specified duration).  - &#x60;ERROR&#x60; - offer ended due to internal problem with offer publication. The publication command responded with    success status, but further processing failed.  - &#x60;UNKNOWN&#x60; - in rare cases the reason might be unknown.
   */
  @JsonAdapter(EndedByEnum.Adapter.class)
  public enum EndedByEnum {
    USER("USER"),
    
    ADMIN("ADMIN"),
    
    EXPIRATION("EXPIRATION"),
    
    ERROR("ERROR"),
    
    UNKNOWN("UNKNOWN");

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

  public static final String SERIALIZED_NAME_ENDED_AT = "endedAt";
  @SerializedName(SERIALIZED_NAME_ENDED_AT)
  private OffsetDateTime endedAt;


  public OfferEventEndedOfferAllOfPublication endedBy(EndedByEnum endedBy) {
    
    this.endedBy = endedBy;
    return this;
  }

   /**
   * Indicates the reason for ending the offer:  - &#x60;USER&#x60; - offer ended by the seller.  - &#x60;ADMIN&#x60; - offer ended by an admin.  - &#x60;EXPIRATION&#x60; - offer ended because all available items had been sold out or offer duration had expired (valid for    offers with specified duration).  - &#x60;ERROR&#x60; - offer ended due to internal problem with offer publication. The publication command responded with    success status, but further processing failed.  - &#x60;UNKNOWN&#x60; - in rare cases the reason might be unknown.
   * @return endedBy
  **/
  @ApiModelProperty(required = true, value = "Indicates the reason for ending the offer:  - `USER` - offer ended by the seller.  - `ADMIN` - offer ended by an admin.  - `EXPIRATION` - offer ended because all available items had been sold out or offer duration had expired (valid for    offers with specified duration).  - `ERROR` - offer ended due to internal problem with offer publication. The publication command responded with    success status, but further processing failed.  - `UNKNOWN` - in rare cases the reason might be unknown.")

  public EndedByEnum getEndedBy() {
    return endedBy;
  }



  public void setEndedBy(EndedByEnum endedBy) {
    this.endedBy = endedBy;
  }


  public OfferEventEndedOfferAllOfPublication endedAt(OffsetDateTime endedAt) {
    
    this.endedAt = endedAt;
    return this;
  }

   /**
   * Offer publication ending date and time in [ISO 8601](https://en.wikipedia.org/wiki/ISO_8601) format in UTC - &#x60;yyyy-MM-ddTHH:mm:ssZ&#x60;.
   * @return endedAt
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "2019-07-30T12:10:11Z", value = "Offer publication ending date and time in [ISO 8601](https://en.wikipedia.org/wiki/ISO_8601) format in UTC - `yyyy-MM-ddTHH:mm:ssZ`.")

  public OffsetDateTime getEndedAt() {
    return endedAt;
  }



  public void setEndedAt(OffsetDateTime endedAt) {
    this.endedAt = endedAt;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OfferEventEndedOfferAllOfPublication offerEventEndedOfferAllOfPublication = (OfferEventEndedOfferAllOfPublication) o;
    return Objects.equals(this.endedBy, offerEventEndedOfferAllOfPublication.endedBy) &&
        Objects.equals(this.endedAt, offerEventEndedOfferAllOfPublication.endedAt);
  }

  @Override
  public int hashCode() {
    return Objects.hash(endedBy, endedAt);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OfferEventEndedOfferAllOfPublication {\n");
    sb.append("    endedBy: ").append(toIndentedString(endedBy)).append("\n");
    sb.append("    endedAt: ").append(toIndentedString(endedAt)).append("\n");
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
