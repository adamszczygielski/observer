package allegro.application.common;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
public enum PriceType {
    BUYNOW("Buy now"),
    WITHDELIVERY("With delivery"),
    BIDDING("Bidding"),
    ADVERT("Advert"),
    UNDEFINED("Price");

    String priceType;
}
