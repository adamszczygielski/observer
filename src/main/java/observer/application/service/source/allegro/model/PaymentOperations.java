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
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * PaymentOperations
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2019-09-16T16:12:46.567+02:00[Europe/Belgrade]")
public class PaymentOperations {
  public static final String SERIALIZED_NAME_PAYMENT_OPERATIONS = "paymentOperations";
  @SerializedName(SERIALIZED_NAME_PAYMENT_OPERATIONS)
  private List<BaseOperation> paymentOperations = new ArrayList<BaseOperation>();

  public static final String SERIALIZED_NAME_COUNT = "count";
  @SerializedName(SERIALIZED_NAME_COUNT)
  private Integer count;

  public static final String SERIALIZED_NAME_TOTAL_COUNT = "totalCount";
  @SerializedName(SERIALIZED_NAME_TOTAL_COUNT)
  private Integer totalCount;


  public PaymentOperations paymentOperations(List<BaseOperation> paymentOperations) {
    
    this.paymentOperations = paymentOperations;
    return this;
  }

  public PaymentOperations addPaymentOperationsItem(BaseOperation paymentOperationsItem) {
    this.paymentOperations.add(paymentOperationsItem);
    return this;
  }

   /**
   * Collection of payment operations.
   * @return paymentOperations
  **/
  @ApiModelProperty(required = true, value = "Collection of payment operations.")

  public List<BaseOperation> getPaymentOperations() {
    return paymentOperations;
  }



  public void setPaymentOperations(List<BaseOperation> paymentOperations) {
    this.paymentOperations = paymentOperations;
  }


  public PaymentOperations count(Integer count) {
    
    this.count = count;
    return this;
  }

   /**
   * Number of payment operations returned in search result for the given parameters.
   * @return count
  **/
  @ApiModelProperty(example = "50", required = true, value = "Number of payment operations returned in search result for the given parameters.")

  public Integer getCount() {
    return count;
  }



  public void setCount(Integer count) {
    this.count = count;
  }


  public PaymentOperations totalCount(Integer totalCount) {
    
    this.totalCount = totalCount;
    return this;
  }

   /**
   * Total number of payment operations for the given parameters.
   * @return totalCount
  **/
  @ApiModelProperty(example = "123", required = true, value = "Total number of payment operations for the given parameters.")

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
    PaymentOperations paymentOperations = (PaymentOperations) o;
    return Objects.equals(this.paymentOperations, paymentOperations.paymentOperations) &&
        Objects.equals(this.count, paymentOperations.count) &&
        Objects.equals(this.totalCount, paymentOperations.totalCount);
  }

  @Override
  public int hashCode() {
    return Objects.hash(paymentOperations, count, totalCount);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PaymentOperations {\n");
    sb.append("    paymentOperations: ").append(toIndentedString(paymentOperations)).append("\n");
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
