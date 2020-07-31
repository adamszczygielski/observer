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

import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Objects;

/**
 * Additional information about offers in auction format.
 */
@ApiModel(description = "Additional information about offers in auction format.")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2019-09-16T16:12:46.567+02:00[Europe/Belgrade]")
public class OfferListingDtoV1SaleInfo {
  public static final String SERIALIZED_NAME_CURRENT_PRICE = "currentPrice";
  @SerializedName(SERIALIZED_NAME_CURRENT_PRICE)
  private CurrentPrice currentPrice = null;

  public static final String SERIALIZED_NAME_BIDDERS_COUNT = "biddersCount";
  @SerializedName(SERIALIZED_NAME_BIDDERS_COUNT)
  private Integer biddersCount;


  public OfferListingDtoV1SaleInfo currentPrice(CurrentPrice currentPrice) {
    
    this.currentPrice = currentPrice;
    return this;
  }

   /**
   * Get currentPrice
   * @return currentPrice
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public CurrentPrice getCurrentPrice() {
    return currentPrice;
  }



  public void setCurrentPrice(CurrentPrice currentPrice) {
    this.currentPrice = currentPrice;
  }


  public OfferListingDtoV1SaleInfo biddersCount(Integer biddersCount) {
    
    this.biddersCount = biddersCount;
    return this;
  }

   /**
   * The number of bidders.
   * @return biddersCount
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "4", value = "The number of bidders.")

  public Integer getBiddersCount() {
    return biddersCount;
  }



  public void setBiddersCount(Integer biddersCount) {
    this.biddersCount = biddersCount;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OfferListingDtoV1SaleInfo offerListingDtoV1SaleInfo = (OfferListingDtoV1SaleInfo) o;
    return Objects.equals(this.currentPrice, offerListingDtoV1SaleInfo.currentPrice) &&
        Objects.equals(this.biddersCount, offerListingDtoV1SaleInfo.biddersCount);
  }

  @Override
  public int hashCode() {
    return Objects.hash(currentPrice, biddersCount);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OfferListingDtoV1SaleInfo {\n");
    sb.append("    currentPrice: ").append(toIndentedString(currentPrice)).append("\n");
    sb.append("    biddersCount: ").append(toIndentedString(biddersCount)).append("\n");
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
