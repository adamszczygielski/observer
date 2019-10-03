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
 * FeePreviewResponse
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2019-09-16T16:12:46.567+02:00[Europe/Belgrade]")
public class FeePreviewResponse {
  public static final String SERIALIZED_NAME_COMMISSIONS = "commissions";
  @SerializedName(SERIALIZED_NAME_COMMISSIONS)
  private List<CommissionResponse> commissions = null;

  public static final String SERIALIZED_NAME_QUOTES = "quotes";
  @SerializedName(SERIALIZED_NAME_QUOTES)
  private List<QuoteResponse> quotes = null;


  public FeePreviewResponse commissions(List<CommissionResponse> commissions) {
    
    this.commissions = commissions;
    return this;
  }

  public FeePreviewResponse addCommissionsItem(CommissionResponse commissionsItem) {
    if (this.commissions == null) {
      this.commissions = new ArrayList<CommissionResponse>();
    }
    this.commissions.add(commissionsItem);
    return this;
  }

   /**
   * An array of commissions.
   * @return commissions
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "An array of commissions.")

  public List<CommissionResponse> getCommissions() {
    return commissions;
  }



  public void setCommissions(List<CommissionResponse> commissions) {
    this.commissions = commissions;
  }


  public FeePreviewResponse quotes(List<QuoteResponse> quotes) {
    
    this.quotes = quotes;
    return this;
  }

  public FeePreviewResponse addQuotesItem(QuoteResponse quotesItem) {
    if (this.quotes == null) {
      this.quotes = new ArrayList<QuoteResponse>();
    }
    this.quotes.add(quotesItem);
    return this;
  }

   /**
   * An array of quotes.
   * @return quotes
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "An array of quotes.")

  public List<QuoteResponse> getQuotes() {
    return quotes;
  }



  public void setQuotes(List<QuoteResponse> quotes) {
    this.quotes = quotes;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FeePreviewResponse feePreviewResponse = (FeePreviewResponse) o;
    return Objects.equals(this.commissions, feePreviewResponse.commissions) &&
        Objects.equals(this.quotes, feePreviewResponse.quotes);
  }

  @Override
  public int hashCode() {
    return Objects.hash(commissions, quotes);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FeePreviewResponse {\n");
    sb.append("    commissions: ").append(toIndentedString(commissions)).append("\n");
    sb.append("    quotes: ").append(toIndentedString(quotes)).append("\n");
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

