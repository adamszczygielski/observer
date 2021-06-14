
package observer.application.service.source.allegro.model.listing;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "amount",
    "currency"
})
@Generated("jsonschema2pojo")
public class ItemWithDelivery {

    @JsonProperty("amount")
    private String amount;
    @JsonProperty("currency")
    private String currency;

    /**
     * No args constructor for use in serialization
     * 
     */
    public ItemWithDelivery() {
    }

    /**
     * 
     * @param amount
     * @param currency
     */
    public ItemWithDelivery(String amount, String currency) {
        super();
        this.amount = amount;
        this.currency = currency;
    }

    @JsonProperty("amount")
    public String getAmount() {
        return amount;
    }

    @JsonProperty("amount")
    public void setAmount(String amount) {
        this.amount = amount;
    }

    @JsonProperty("currency")
    public String getCurrency() {
        return currency;
    }

    @JsonProperty("currency")
    public void setCurrency(String currency) {
        this.currency = currency;
    }

}
