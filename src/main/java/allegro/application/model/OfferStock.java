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
 * Information about the stock.
 */
@ApiModel(description = "Information about the stock.")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2019-09-16T16:12:46.567+02:00[Europe/Belgrade]")
public class OfferStock {
  /**
   * The unit type of the stock.
   */
  @JsonAdapter(UnitEnum.Adapter.class)
  public enum UnitEnum {
    UNIT("UNIT"),
    
    PAIR("PAIR"),
    
    SET("SET");

    private String value;

    UnitEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static UnitEnum fromValue(String value) {
      for (UnitEnum b : UnitEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<UnitEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final UnitEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public UnitEnum read(final JsonReader jsonReader) throws IOException {
        String value = jsonReader.nextString();
        return UnitEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_UNIT = "unit";
  @SerializedName(SERIALIZED_NAME_UNIT)
  private UnitEnum unit;

  public static final String SERIALIZED_NAME_AVAILABLE = "available";
  @SerializedName(SERIALIZED_NAME_AVAILABLE)
  private Integer available;


  public OfferStock unit(UnitEnum unit) {
    
    this.unit = unit;
    return this;
  }

   /**
   * The unit type of the stock.
   * @return unit
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The unit type of the stock.")

  public UnitEnum getUnit() {
    return unit;
  }



  public void setUnit(UnitEnum unit) {
    this.unit = unit;
  }


  public OfferStock available(Integer available) {
    
    this.available = available;
    return this;
  }

   /**
   * The available stock value.
   * @return available
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "23", value = "The available stock value.")

  public Integer getAvailable() {
    return available;
  }



  public void setAvailable(Integer available) {
    this.available = available;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OfferStock offerStock = (OfferStock) o;
    return Objects.equals(this.unit, offerStock.unit) &&
        Objects.equals(this.available, offerStock.available);
  }

  @Override
  public int hashCode() {
    return Objects.hash(unit, available);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OfferStock {\n");
    sb.append("    unit: ").append(toIndentedString(unit)).append("\n");
    sb.append("    available: ").append(toIndentedString(available)).append("\n");
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

