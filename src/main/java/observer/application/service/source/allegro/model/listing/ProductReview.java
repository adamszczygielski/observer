
package observer.application.service.source.allegro.model.listing;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "rating"
})
@Generated("jsonschema2pojo")
public class ProductReview {

    @JsonProperty("rating")
    private Rating rating;

    /**
     * No args constructor for use in serialization
     * 
     */
    public ProductReview() {
    }

    /**
     * 
     * @param rating
     */
    public ProductReview(Rating rating) {
        super();
        this.rating = rating;
    }

    @JsonProperty("rating")
    public Rating getRating() {
        return rating;
    }

    @JsonProperty("rating")
    public void setRating(Rating rating) {
        this.rating = rating;
    }

}
