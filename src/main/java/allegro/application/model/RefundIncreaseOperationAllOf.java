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

import java.util.Objects;

/**
 * RefundIncreaseOperationAllOf
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2019-09-16T16:12:46.567+02:00[Europe/Belgrade]")
public class RefundIncreaseOperationAllOf {
  public static final String SERIALIZED_NAME_TYPE = "type";
  @SerializedName(SERIALIZED_NAME_TYPE)
  private String type = "REFUND_INCREASE";

  public static final String SERIALIZED_NAME_PAYMENT = "payment";
  @SerializedName(SERIALIZED_NAME_PAYMENT)
  private OperationPayment payment;

  public static final String SERIALIZED_NAME_PARTICIPANT = "participant";
  @SerializedName(SERIALIZED_NAME_PARTICIPANT)
  private SellerParticipant participant = null;


  public RefundIncreaseOperationAllOf type(String type) {
    
    this.type = type;
    return this;
  }

   /**
   * Get type
   * @return type
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getType() {
    return type;
  }



  public void setType(String type) {
    this.type = type;
  }


  public RefundIncreaseOperationAllOf payment(OperationPayment payment) {
    
    this.payment = payment;
    return this;
  }

   /**
   * Get payment
   * @return payment
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public OperationPayment getPayment() {
    return payment;
  }



  public void setPayment(OperationPayment payment) {
    this.payment = payment;
  }


  public RefundIncreaseOperationAllOf participant(SellerParticipant participant) {
    
    this.participant = participant;
    return this;
  }

   /**
   * Get participant
   * @return participant
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public SellerParticipant getParticipant() {
    return participant;
  }



  public void setParticipant(SellerParticipant participant) {
    this.participant = participant;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RefundIncreaseOperationAllOf refundIncreaseOperationAllOf = (RefundIncreaseOperationAllOf) o;
    return Objects.equals(this.type, refundIncreaseOperationAllOf.type) &&
        Objects.equals(this.payment, refundIncreaseOperationAllOf.payment) &&
        Objects.equals(this.participant, refundIncreaseOperationAllOf.participant);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, payment, participant);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RefundIncreaseOperationAllOf {\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    payment: ").append(toIndentedString(payment)).append("\n");
    sb.append("    participant: ").append(toIndentedString(participant)).append("\n");
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

