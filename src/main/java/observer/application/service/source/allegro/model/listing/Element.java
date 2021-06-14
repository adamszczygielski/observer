
package observer.application.service.source.allegro.model.listing;

import java.util.List;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "type",
    "text",
    "id",
    "url",
    "vendor",
    "location",
    "title",
    "highlight",
    "mainThumbnail",
    "photos",
    "categoryPath",
    "quantity",
    "cartAvailable",
    "isSponsored",
    "openInNewTab",
    "labels",
    "parameters",
    "timingInfo",
    "availabilityInfo",
    "price",
    "deliveryInfo",
    "position",
    "seller",
    "productReview",
    "seoUrl",
    "shipping"
})
@Generated("jsonschema2pojo")
public class Element {

    @JsonProperty("type")
    private String type;
    @JsonProperty("text")
    private String text;
    @JsonProperty("id")
    private String id;
    @JsonProperty("url")
    private String url;
    @JsonProperty("vendor")
    private String vendor;
    @JsonProperty("location")
    private Location location;
    @JsonProperty("title")
    private Title title;
    @JsonProperty("highlight")
    private Boolean highlight;
    @JsonProperty("mainThumbnail")
    private String mainThumbnail;
    @JsonProperty("photos")
    private List<Photo> photos = null;
    @JsonProperty("categoryPath")
    private List<String> categoryPath = null;
    @JsonProperty("quantity")
    private Integer quantity;
    @JsonProperty("cartAvailable")
    private Boolean cartAvailable;
    @JsonProperty("isSponsored")
    private Boolean isSponsored;
    @JsonProperty("openInNewTab")
    private Boolean openInNewTab;
    @JsonProperty("labels")
    private Labels labels;
    @JsonProperty("parameters")
    private List<Object> parameters = null;
    @JsonProperty("timingInfo")
    private TimingInfo timingInfo;
    @JsonProperty("availabilityInfo")
    private AvailabilityInfo availabilityInfo;
    @JsonProperty("price")
    private Price price;
    @JsonProperty("deliveryInfo")
    private DeliveryInfo deliveryInfo;
    @JsonProperty("position")
    private Integer position;
    @JsonProperty("seller")
    private Seller seller;
    @JsonProperty("productReview")
    private ProductReview productReview;
    @JsonProperty("seoUrl")
    private String seoUrl;
    @JsonProperty("shipping")
    private Shipping shipping;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Element() {
    }

    /**
     * 
     * @param seller
     * @param cartAvailable
     * @param mainThumbnail
     * @param availabilityInfo
     * @param type
     * @param title
     * @param photos
     * @param productReview
     * @param highlight
     * @param seoUrl
     * @param shipping
     * @param vendor
     * @param price
     * @param text
     * @param id
     * @param deliveryInfo
     * @param quantity
     * @param categoryPath
     * @param url
     * @param labels
     * @param timingInfo
     * @param location
     * @param position
     * @param parameters
     * @param openInNewTab
     * @param isSponsored
     */
    public Element(String type, String text, String id, String url, String vendor, Location location, Title title, Boolean highlight, String mainThumbnail, List<Photo> photos, List<String> categoryPath, Integer quantity, Boolean cartAvailable, Boolean isSponsored, Boolean openInNewTab, Labels labels, List<Object> parameters, TimingInfo timingInfo, AvailabilityInfo availabilityInfo, Price price, DeliveryInfo deliveryInfo, Integer position, Seller seller, ProductReview productReview, String seoUrl, Shipping shipping) {
        super();
        this.type = type;
        this.text = text;
        this.id = id;
        this.url = url;
        this.vendor = vendor;
        this.location = location;
        this.title = title;
        this.highlight = highlight;
        this.mainThumbnail = mainThumbnail;
        this.photos = photos;
        this.categoryPath = categoryPath;
        this.quantity = quantity;
        this.cartAvailable = cartAvailable;
        this.isSponsored = isSponsored;
        this.openInNewTab = openInNewTab;
        this.labels = labels;
        this.parameters = parameters;
        this.timingInfo = timingInfo;
        this.availabilityInfo = availabilityInfo;
        this.price = price;
        this.deliveryInfo = deliveryInfo;
        this.position = position;
        this.seller = seller;
        this.productReview = productReview;
        this.seoUrl = seoUrl;
        this.shipping = shipping;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("text")
    public String getText() {
        return text;
    }

    @JsonProperty("text")
    public void setText(String text) {
        this.text = text;
    }

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

    @JsonProperty("vendor")
    public String getVendor() {
        return vendor;
    }

    @JsonProperty("vendor")
    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    @JsonProperty("location")
    public Location getLocation() {
        return location;
    }

    @JsonProperty("location")
    public void setLocation(Location location) {
        this.location = location;
    }

    @JsonProperty("title")
    public Title getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(Title title) {
        this.title = title;
    }

    @JsonProperty("highlight")
    public Boolean getHighlight() {
        return highlight;
    }

    @JsonProperty("highlight")
    public void setHighlight(Boolean highlight) {
        this.highlight = highlight;
    }

    @JsonProperty("mainThumbnail")
    public String getMainThumbnail() {
        return mainThumbnail;
    }

    @JsonProperty("mainThumbnail")
    public void setMainThumbnail(String mainThumbnail) {
        this.mainThumbnail = mainThumbnail;
    }

    @JsonProperty("photos")
    public List<Photo> getPhotos() {
        return photos;
    }

    @JsonProperty("photos")
    public void setPhotos(List<Photo> photos) {
        this.photos = photos;
    }

    @JsonProperty("categoryPath")
    public List<String> getCategoryPath() {
        return categoryPath;
    }

    @JsonProperty("categoryPath")
    public void setCategoryPath(List<String> categoryPath) {
        this.categoryPath = categoryPath;
    }

    @JsonProperty("quantity")
    public Integer getQuantity() {
        return quantity;
    }

    @JsonProperty("quantity")
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @JsonProperty("cartAvailable")
    public Boolean getCartAvailable() {
        return cartAvailable;
    }

    @JsonProperty("cartAvailable")
    public void setCartAvailable(Boolean cartAvailable) {
        this.cartAvailable = cartAvailable;
    }

    @JsonProperty("isSponsored")
    public Boolean getIsSponsored() {
        return isSponsored;
    }

    @JsonProperty("isSponsored")
    public void setIsSponsored(Boolean isSponsored) {
        this.isSponsored = isSponsored;
    }

    @JsonProperty("openInNewTab")
    public Boolean getOpenInNewTab() {
        return openInNewTab;
    }

    @JsonProperty("openInNewTab")
    public void setOpenInNewTab(Boolean openInNewTab) {
        this.openInNewTab = openInNewTab;
    }

    @JsonProperty("labels")
    public Labels getLabels() {
        return labels;
    }

    @JsonProperty("labels")
    public void setLabels(Labels labels) {
        this.labels = labels;
    }

    @JsonProperty("parameters")
    public List<Object> getParameters() {
        return parameters;
    }

    @JsonProperty("parameters")
    public void setParameters(List<Object> parameters) {
        this.parameters = parameters;
    }

    @JsonProperty("timingInfo")
    public TimingInfo getTimingInfo() {
        return timingInfo;
    }

    @JsonProperty("timingInfo")
    public void setTimingInfo(TimingInfo timingInfo) {
        this.timingInfo = timingInfo;
    }

    @JsonProperty("availabilityInfo")
    public AvailabilityInfo getAvailabilityInfo() {
        return availabilityInfo;
    }

    @JsonProperty("availabilityInfo")
    public void setAvailabilityInfo(AvailabilityInfo availabilityInfo) {
        this.availabilityInfo = availabilityInfo;
    }

    @JsonProperty("price")
    public Price getPrice() {
        return price;
    }

    @JsonProperty("price")
    public void setPrice(Price price) {
        this.price = price;
    }

    @JsonProperty("deliveryInfo")
    public DeliveryInfo getDeliveryInfo() {
        return deliveryInfo;
    }

    @JsonProperty("deliveryInfo")
    public void setDeliveryInfo(DeliveryInfo deliveryInfo) {
        this.deliveryInfo = deliveryInfo;
    }

    @JsonProperty("position")
    public Integer getPosition() {
        return position;
    }

    @JsonProperty("position")
    public void setPosition(Integer position) {
        this.position = position;
    }

    @JsonProperty("seller")
    public Seller getSeller() {
        return seller;
    }

    @JsonProperty("seller")
    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    @JsonProperty("productReview")
    public ProductReview getProductReview() {
        return productReview;
    }

    @JsonProperty("productReview")
    public void setProductReview(ProductReview productReview) {
        this.productReview = productReview;
    }

    @JsonProperty("seoUrl")
    public String getSeoUrl() {
        return seoUrl;
    }

    @JsonProperty("seoUrl")
    public void setSeoUrl(String seoUrl) {
        this.seoUrl = seoUrl;
    }

    @JsonProperty("shipping")
    public Shipping getShipping() {
        return shipping;
    }

    @JsonProperty("shipping")
    public void setShipping(Shipping shipping) {
        this.shipping = shipping;
    }

}
