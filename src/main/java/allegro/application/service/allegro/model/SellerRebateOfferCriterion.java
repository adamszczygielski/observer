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
import io.swagger.annotations.ApiModelProperty;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * SellerRebateOfferCriterion
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2019-09-16T16:12:46.567+02:00[Europe/Belgrade]")
public class SellerRebateOfferCriterion {
  public static final String SERIALIZED_NAME_OFFERS = "offers";
  @SerializedName(SERIALIZED_NAME_OFFERS)
  private List<SellerRebateOfferCriterionOffers> offers = new ArrayList<SellerRebateOfferCriterionOffers>();

  /**
   * Criteria type: CONTAINS_OFFERS
   */
  @JsonAdapter(TypeEnum.Adapter.class)
  public enum TypeEnum {
    CONTAINS_OFFERS("CONTAINS_OFFERS");

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


  public SellerRebateOfferCriterion offers(List<SellerRebateOfferCriterionOffers> offers) {
    
    this.offers = offers;
    return this;
  }

  public SellerRebateOfferCriterion addOffersItem(SellerRebateOfferCriterionOffers offersItem) {
    this.offers.add(offersItem);
    return this;
  }

   /**
   * Set of offers
   * @return offers
  **/
  @ApiModelProperty(required = true, value = "Set of offers")

  public List<SellerRebateOfferCriterionOffers> getOffers() {
    return offers;
  }



  public void setOffers(List<SellerRebateOfferCriterionOffers> offers) {
    this.offers = offers;
  }


  public SellerRebateOfferCriterion type(TypeEnum type) {
    
    this.type = type;
    return this;
  }

   /**
   * Criteria type: CONTAINS_OFFERS
   * @return type
  **/
  @ApiModelProperty(required = true, value = "Criteria type: CONTAINS_OFFERS")

  public TypeEnum getType() {
    return type;
  }



  public void setType(TypeEnum type) {
    this.type = type;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SellerRebateOfferCriterion sellerRebateOfferCriterion = (SellerRebateOfferCriterion) o;
    return Objects.equals(this.offers, sellerRebateOfferCriterion.offers) &&
        Objects.equals(this.type, sellerRebateOfferCriterion.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(offers, type);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SellerRebateOfferCriterion {\n");
    sb.append("    offers: ").append(toIndentedString(offers)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
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
