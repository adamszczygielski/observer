
package observer.application.service.source.allegro.model.listing;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.Generated;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "type",
    "text",
    "id",
    "url",
    "vendor",
    "location",
    "title",
    "alt",
    "highlight",
    "mainThumbnail",
    "photos",
    "isAddToCartHidden",
    "isBestPriceGuarantee",
    "isEnded",
    "assortmentCategory",
    "navigationCategory",
    "quantity",
    "cartAvailable",
    "isSponsored",
    "openInNewTab",
    "labels",
    "position",
    "context",
    "brand",
    "parameters",
    "timingInfo",
    "availabilityInfo",
    "price",
    "deliveryInfo",
    "seller",
    "badges",
    "seoProductInfo",
    "productId",
    "shipping",
    "analytics"
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
    @JsonProperty("alt")
    private String alt;
    @JsonProperty("highlight")
    private Boolean highlight;
    @JsonProperty("mainThumbnail")
    private String mainThumbnail;
    @JsonProperty("photos")
    private List<Photo> photos = new ArrayList<Photo>();
    @JsonProperty("isAddToCartHidden")
    private Boolean isAddToCartHidden;
    @JsonProperty("isBestPriceGuarantee")
    private Boolean isBestPriceGuarantee;
    @JsonProperty("isEnded")
    private Boolean isEnded;
    @JsonProperty("assortmentCategory")
    private AssortmentCategory assortmentCategory;
    @JsonProperty("navigationCategory")
    private NavigationCategory navigationCategory;
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
    @JsonProperty("position")
    private Integer position;
    @JsonProperty("context")
    private String context;
    @JsonProperty("brand")
    private Brand brand;
    @JsonProperty("parameters")
    private List<Parameter> parameters = new ArrayList<Parameter>();
    @JsonProperty("timingInfo")
    private TimingInfo timingInfo;
    @JsonProperty("availabilityInfo")
    private AvailabilityInfo availabilityInfo;
    @JsonProperty("price")
    private Price price;
    @JsonProperty("deliveryInfo")
    private Object deliveryInfo;
    @JsonProperty("seller")
    private Seller seller;
    @JsonProperty("badges")
    private Badges badges;
    @JsonProperty("seoProductInfo")
    private SeoProductInfo seoProductInfo;
    @JsonProperty("productId")
    private String productId;
    @JsonProperty("shipping")
    private Shipping shipping;
    @JsonProperty("analytics")
    private Analytics analytics;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

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
     * @param analytics
     * @param highlight
     * @param shipping
     * @param vendor
     * @param price
     * @param context
     * @param text
     * @param id
     * @param isEnded
     * @param brand
     * @param assortmentCategory
     * @param deliveryInfo
     * @param navigationCategory
     * @param quantity
     * @param productId
     * @param alt
     * @param isBestPriceGuarantee
     * @param url
     * @param labels
     * @param badges
     * @param timingInfo
     * @param seoProductInfo
     * @param location
     * @param position
     * @param isAddToCartHidden
     * @param parameters
     * @param openInNewTab
     * @param isSponsored
     */
    public Element(String type, String text, String id, String url, String vendor, Location location, Title title, String alt, Boolean highlight, String mainThumbnail, List<Photo> photos, Boolean isAddToCartHidden, Boolean isBestPriceGuarantee, Boolean isEnded, AssortmentCategory assortmentCategory, NavigationCategory navigationCategory, Integer quantity, Boolean cartAvailable, Boolean isSponsored, Boolean openInNewTab, Labels labels, Integer position, String context, Brand brand, List<Parameter> parameters, TimingInfo timingInfo, AvailabilityInfo availabilityInfo, Price price, Object deliveryInfo, Seller seller, Badges badges, SeoProductInfo seoProductInfo, String productId, Shipping shipping, Analytics analytics) {
        super();
        this.type = type;
        this.text = text;
        this.id = id;
        this.url = url;
        this.vendor = vendor;
        this.location = location;
        this.title = title;
        this.alt = alt;
        this.highlight = highlight;
        this.mainThumbnail = mainThumbnail;
        this.photos = photos;
        this.isAddToCartHidden = isAddToCartHidden;
        this.isBestPriceGuarantee = isBestPriceGuarantee;
        this.isEnded = isEnded;
        this.assortmentCategory = assortmentCategory;
        this.navigationCategory = navigationCategory;
        this.quantity = quantity;
        this.cartAvailable = cartAvailable;
        this.isSponsored = isSponsored;
        this.openInNewTab = openInNewTab;
        this.labels = labels;
        this.position = position;
        this.context = context;
        this.brand = brand;
        this.parameters = parameters;
        this.timingInfo = timingInfo;
        this.availabilityInfo = availabilityInfo;
        this.price = price;
        this.deliveryInfo = deliveryInfo;
        this.seller = seller;
        this.badges = badges;
        this.seoProductInfo = seoProductInfo;
        this.productId = productId;
        this.shipping = shipping;
        this.analytics = analytics;
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

    @JsonProperty("alt")
    public String getAlt() {
        return alt;
    }

    @JsonProperty("alt")
    public void setAlt(String alt) {
        this.alt = alt;
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

    @JsonProperty("isAddToCartHidden")
    public Boolean getIsAddToCartHidden() {
        return isAddToCartHidden;
    }

    @JsonProperty("isAddToCartHidden")
    public void setIsAddToCartHidden(Boolean isAddToCartHidden) {
        this.isAddToCartHidden = isAddToCartHidden;
    }

    @JsonProperty("isBestPriceGuarantee")
    public Boolean getIsBestPriceGuarantee() {
        return isBestPriceGuarantee;
    }

    @JsonProperty("isBestPriceGuarantee")
    public void setIsBestPriceGuarantee(Boolean isBestPriceGuarantee) {
        this.isBestPriceGuarantee = isBestPriceGuarantee;
    }

    @JsonProperty("isEnded")
    public Boolean getIsEnded() {
        return isEnded;
    }

    @JsonProperty("isEnded")
    public void setIsEnded(Boolean isEnded) {
        this.isEnded = isEnded;
    }

    @JsonProperty("assortmentCategory")
    public AssortmentCategory getAssortmentCategory() {
        return assortmentCategory;
    }

    @JsonProperty("assortmentCategory")
    public void setAssortmentCategory(AssortmentCategory assortmentCategory) {
        this.assortmentCategory = assortmentCategory;
    }

    @JsonProperty("navigationCategory")
    public NavigationCategory getNavigationCategory() {
        return navigationCategory;
    }

    @JsonProperty("navigationCategory")
    public void setNavigationCategory(NavigationCategory navigationCategory) {
        this.navigationCategory = navigationCategory;
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

    @JsonProperty("position")
    public Integer getPosition() {
        return position;
    }

    @JsonProperty("position")
    public void setPosition(Integer position) {
        this.position = position;
    }

    @JsonProperty("context")
    public String getContext() {
        return context;
    }

    @JsonProperty("context")
    public void setContext(String context) {
        this.context = context;
    }

    @JsonProperty("brand")
    public Brand getBrand() {
        return brand;
    }

    @JsonProperty("brand")
    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    @JsonProperty("parameters")
    public List<Parameter> getParameters() {
        return parameters;
    }

    @JsonProperty("parameters")
    public void setParameters(List<Parameter> parameters) {
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
    public Object getDeliveryInfo() {
        return deliveryInfo;
    }

    @JsonProperty("deliveryInfo")
    public void setDeliveryInfo(Object deliveryInfo) {
        this.deliveryInfo = deliveryInfo;
    }

    @JsonProperty("seller")
    public Seller getSeller() {
        return seller;
    }

    @JsonProperty("seller")
    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    @JsonProperty("badges")
    public Badges getBadges() {
        return badges;
    }

    @JsonProperty("badges")
    public void setBadges(Badges badges) {
        this.badges = badges;
    }

    @JsonProperty("seoProductInfo")
    public SeoProductInfo getSeoProductInfo() {
        return seoProductInfo;
    }

    @JsonProperty("seoProductInfo")
    public void setSeoProductInfo(SeoProductInfo seoProductInfo) {
        this.seoProductInfo = seoProductInfo;
    }

    @JsonProperty("productId")
    public String getProductId() {
        return productId;
    }

    @JsonProperty("productId")
    public void setProductId(String productId) {
        this.productId = productId;
    }

    @JsonProperty("shipping")
    public Shipping getShipping() {
        return shipping;
    }

    @JsonProperty("shipping")
    public void setShipping(Shipping shipping) {
        this.shipping = shipping;
    }

    @JsonProperty("analytics")
    public Analytics getAnalytics() {
        return analytics;
    }

    @JsonProperty("analytics")
    public void setAnalytics(Analytics analytics) {
        this.analytics = analytics;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
