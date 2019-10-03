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
 * OffersSearchResultDto
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2019-09-16T16:12:46.567+02:00[Europe/Belgrade]")
public class OffersSearchResultDto {
  public static final String SERIALIZED_NAME_OFFERS = "offers";
  @SerializedName(SERIALIZED_NAME_OFFERS)
  private List<OfferListingDto> offers = null;

  public static final String SERIALIZED_NAME_COUNT = "count";
  @SerializedName(SERIALIZED_NAME_COUNT)
  private Integer count;

  public static final String SERIALIZED_NAME_TOTAL_COUNT = "totalCount";
  @SerializedName(SERIALIZED_NAME_TOTAL_COUNT)
  private Integer totalCount;


  public OffersSearchResultDto offers(List<OfferListingDto> offers) {
    
    this.offers = offers;
    return this;
  }

  public OffersSearchResultDto addOffersItem(OfferListingDto offersItem) {
    if (this.offers == null) {
      this.offers = new ArrayList<OfferListingDto>();
    }
    this.offers.add(offersItem);
    return this;
  }

   /**
   * The list of seller&#39;s offers matching the request&#39;s criteria.
   * @return offers
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The list of seller's offers matching the request's criteria.")

  public List<OfferListingDto> getOffers() {
    return offers;
  }



  public void setOffers(List<OfferListingDto> offers) {
    this.offers = offers;
  }


  public OffersSearchResultDto count(Integer count) {
    
    this.count = count;
    return this;
  }

   /**
   * Number of offers in the search result.
   * @return count
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "1", value = "Number of offers in the search result.")

  public Integer getCount() {
    return count;
  }



  public void setCount(Integer count) {
    this.count = count;
  }


  public OffersSearchResultDto totalCount(Integer totalCount) {
    
    this.totalCount = totalCount;
    return this;
  }

   /**
   * The total number of offers matching the request&#39;s criteria.
   * @return totalCount
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "1234", value = "The total number of offers matching the request's criteria.")

  public Integer getTotalCount() {
    return totalCount;
  }



  public void setTotalCount(Integer totalCount) {
    this.totalCount = totalCount;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OffersSearchResultDto offersSearchResultDto = (OffersSearchResultDto) o;
    return Objects.equals(this.offers, offersSearchResultDto.offers) &&
        Objects.equals(this.count, offersSearchResultDto.count) &&
        Objects.equals(this.totalCount, offersSearchResultDto.totalCount);
  }

  @Override
  public int hashCode() {
    return Objects.hash(offers, count, totalCount);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OffersSearchResultDto {\n");
    sb.append("    offers: ").append(toIndentedString(offers)).append("\n");
    sb.append("    count: ").append(toIndentedString(count)).append("\n");
    sb.append("    totalCount: ").append(toIndentedString(totalCount)).append("\n");
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

