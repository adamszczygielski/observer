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
import java.util.Objects;

/**
 * Time period when the campaign is open for applying for badge.
 */
@ApiModel(description = "Time period when the campaign is open for applying for badge.")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2019-09-16T16:12:46.567+02:00[Europe/Belgrade]")
public class ApplicationTimePolicy {
  /**
   * Gets or Sets type
   */
  @JsonAdapter(TypeEnum.Adapter.class)
  public enum TypeEnum {
    ALWAYS("ALWAYS"),
    
    SINCE("SINCE"),
    
    WITHIN("WITHIN"),
    
    UNTIL("UNTIL"),
    
    NEVER("NEVER");

    private String value;

    TypeEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static TypeEnum fromValue(String value) {
      for (TypeEnum b : TypeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<TypeEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final TypeEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public TypeEnum read(final JsonReader jsonReader) throws IOException {
        String value = jsonReader.nextString();
        return TypeEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_TYPE = "type";
  @SerializedName(SERIALIZED_NAME_TYPE)
  private TypeEnum type;

  public static final String SERIALIZED_NAME_FROM = "from";
  @SerializedName(SERIALIZED_NAME_FROM)
  private String from;

  public static final String SERIALIZED_NAME_TO = "to";
  @SerializedName(SERIALIZED_NAME_TO)
  private String to;


  public ApplicationTimePolicy type(TypeEnum type) {
    
    this.type = type;
    return this;
  }

   /**
   * Get type
   * @return type
  **/
  @ApiModelProperty(required = true, value = "")

  public TypeEnum getType() {
    return type;
  }



  public void setType(TypeEnum type) {
    this.type = type;
  }


  public ApplicationTimePolicy from(String from) {
    
    this.from = from;
    return this;
  }

   /**
   * Provided in [ISO 8601 format](link: https://en.wikipedia.org/wiki/ISO_8601).
   * @return from
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "2011-12-03T10:15:30Z", value = "Provided in [ISO 8601 format](link: https://en.wikipedia.org/wiki/ISO_8601).")

  public String getFrom() {
    return from;
  }



  public void setFrom(String from) {
    this.from = from;
  }


  public ApplicationTimePolicy to(String to) {
    
    this.to = to;
    return this;
  }

   /**
   * Provided in [ISO 8601 format](link: https://en.wikipedia.org/wiki/ISO_8601).
   * @return to
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "2011-12-03T10:15:30Z", value = "Provided in [ISO 8601 format](link: https://en.wikipedia.org/wiki/ISO_8601).")

  public String getTo() {
    return to;
  }



  public void setTo(String to) {
    this.to = to;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ApplicationTimePolicy applicationTimePolicy = (ApplicationTimePolicy) o;
    return Objects.equals(this.type, applicationTimePolicy.type) &&
        Objects.equals(this.from, applicationTimePolicy.from) &&
        Objects.equals(this.to, applicationTimePolicy.to);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, from, to);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ApplicationTimePolicy {\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    from: ").append(toIndentedString(from)).append("\n");
    sb.append("    to: ").append(toIndentedString(to)).append("\n");
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

