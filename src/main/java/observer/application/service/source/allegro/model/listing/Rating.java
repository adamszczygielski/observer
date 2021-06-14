
package observer.application.service.source.allegro.model.listing;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "average",
    "count"
})
@Generated("jsonschema2pojo")
public class Rating {

    @JsonProperty("average")
    private String average;
    @JsonProperty("count")
    private Integer count;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Rating() {
    }

    /**
     * 
     * @param average
     * @param count
     */
    public Rating(String average, Integer count) {
        super();
        this.average = average;
        this.count = count;
    }

    @JsonProperty("average")
    public String getAverage() {
        return average;
    }

    @JsonProperty("average")
    public void setAverage(String average) {
        this.average = average;
    }

    @JsonProperty("count")
    public Integer getCount() {
        return count;
    }

    @JsonProperty("count")
    public void setCount(Integer count) {
        this.count = count;
    }

}
