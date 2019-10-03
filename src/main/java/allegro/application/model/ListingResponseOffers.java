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
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * The lists of search results.
 */
@ApiModel(description = "The lists of search results.")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2019-09-16T16:12:46.567+02:00[Europe/Belgrade]")
public class ListingResponseOffers {
  public static final String SERIALIZED_NAME_PROMOTED = "promoted";
  @SerializedName(SERIALIZED_NAME_PROMOTED)
  private List<ListingOffer> promoted = null;

  public static final String SERIALIZED_NAME_REGULAR = "regular";
  @SerializedName(SERIALIZED_NAME_REGULAR)
  private List<ListingOffer> regular = null;


  public ListingResponseOffers promoted(List<ListingOffer> promoted) {
    
    this.promoted = promoted;
    return this;
  }

  public ListingResponseOffers addPromotedItem(ListingOffer promotedItem) {
    if (this.promoted == null) {
      this.promoted = new ArrayList<ListingOffer>();
    }
    this.promoted.add(promotedItem);
    return this;
  }

   /**
   * List of promoted offers.
   * @return promoted
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "List of promoted offers.")

  public List<ListingOffer> getPromoted() {
    return promoted;
  }



  public void setPromoted(List<ListingOffer> promoted) {
    this.promoted = promoted;
  }


  public ListingResponseOffers regular(List<ListingOffer> regular) {
    
    this.regular = regular;
    return this;
  }

  public ListingResponseOffers addRegularItem(ListingOffer regularItem) {
    if (this.regular == null) {
      this.regular = new ArrayList<ListingOffer>();
    }
    this.regular.add(regularItem);
    return this;
  }

   /**
   * List of regular (non-promoted) offers.
   * @return regular
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "List of regular (non-promoted) offers.")

  public List<ListingOffer> getRegular() {
    return regular;
  }



  public void setRegular(List<ListingOffer> regular) {
    this.regular = regular;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ListingResponseOffers listingResponseOffers = (ListingResponseOffers) o;
    return Objects.equals(this.promoted, listingResponseOffers.promoted) &&
        Objects.equals(this.regular, listingResponseOffers.regular);
  }

  @Override
  public int hashCode() {
    return Objects.hash(promoted, regular);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ListingResponseOffers {\n");
    sb.append("    promoted: ").append(toIndentedString(promoted)).append("\n");
    sb.append("    regular: ").append(toIndentedString(regular)).append("\n");
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

