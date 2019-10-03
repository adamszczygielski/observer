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

import java.math.BigDecimal;
import java.util.Objects;

/**
 * SellerRebateOfferCriterionOffers
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2019-09-16T16:12:46.567+02:00[Europe/Belgrade]")
public class SellerRebateOfferCriterionOffers {
  public static final String SERIALIZED_NAME_ID = "id";
  @SerializedName(SERIALIZED_NAME_ID)
  private String id;

  public static final String SERIALIZED_NAME_QUANTITY = "quantity";
  @SerializedName(SERIALIZED_NAME_QUANTITY)
  private BigDecimal quantity;

  public static final String SERIALIZED_NAME_PROMOTION_ENTRY_POINT = "promotionEntryPoint";
  @SerializedName(SERIALIZED_NAME_PROMOTION_ENTRY_POINT)
  private Boolean promotionEntryPoint;


  public SellerRebateOfferCriterionOffers id(String id) {
    
    this.id = id;
    return this;
  }

   /**
   * Offer id
   * @return id
  **/
  @ApiModelProperty(example = "1233432", required = true, value = "Offer id")

  public String getId() {
    return id;
  }



  public void setId(String id) {
    this.id = id;
  }


  public SellerRebateOfferCriterionOffers quantity(BigDecimal quantity) {
    
    this.quantity = quantity;
    return this;
  }

   /**
   * that many pieces of your offer will be part of the bundle, valid only for bundle &#x60;ORDER_FIXED_DISCOUNT&#x60; promotions
   * @return quantity
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "5", value = "that many pieces of your offer will be part of the bundle, valid only for bundle `ORDER_FIXED_DISCOUNT` promotions")

  public BigDecimal getQuantity() {
    return quantity;
  }



  public void setQuantity(BigDecimal quantity) {
    this.quantity = quantity;
  }


  public SellerRebateOfferCriterionOffers promotionEntryPoint(Boolean promotionEntryPoint) {
    
    this.promotionEntryPoint = promotionEntryPoint;
    return this;
  }

   /**
   * offers with this flag set to true will have a section that allows the users to purchase your bundle, valid only for bundle &#x60;ORDER_FIXED_DISCOUNT&#x60; promotions
   * @return promotionEntryPoint
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "false", value = "offers with this flag set to true will have a section that allows the users to purchase your bundle, valid only for bundle `ORDER_FIXED_DISCOUNT` promotions")

  public Boolean getPromotionEntryPoint() {
    return promotionEntryPoint;
  }



  public void setPromotionEntryPoint(Boolean promotionEntryPoint) {
    this.promotionEntryPoint = promotionEntryPoint;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SellerRebateOfferCriterionOffers sellerRebateOfferCriterionOffers = (SellerRebateOfferCriterionOffers) o;
    return Objects.equals(this.id, sellerRebateOfferCriterionOffers.id) &&
        Objects.equals(this.quantity, sellerRebateOfferCriterionOffers.quantity) &&
        Objects.equals(this.promotionEntryPoint, sellerRebateOfferCriterionOffers.promotionEntryPoint);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, quantity, promotionEntryPoint);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SellerRebateOfferCriterionOffers {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    quantity: ").append(toIndentedString(quantity)).append("\n");
    sb.append("    promotionEntryPoint: ").append(toIndentedString(promotionEntryPoint)).append("\n");
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

