package observer.application.service.source.loombard.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.Date;

public class LoombardItem {
    String name;
    int id;
    String slug;
    Price price;
    boolean promo;
    int views;
    String desc;
    String region;
    String location;
    String localization;
    ArrayList<Category> categories;
    ArrayList<Parameter> parameters;
    String thumb_url;
    String product_state;
    Date created_at;
    int stock;
    boolean published;
    String product_state_elastic;
    Object warranty;
    MetaData meta_data;
    Category category;
    ArrayList<Image> images;
    Object merchant;

    @JsonProperty("name")
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("id")
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @JsonProperty("slug")
    public String getSlug() {
        return this.slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    @JsonProperty("price")
    public Price getPrice() {
        return this.price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    @JsonProperty("promo")
    public boolean getPromo() {
        return this.promo;
    }

    public void setPromo(boolean promo) {
        this.promo = promo;
    }

    @JsonProperty("views")
    public int getViews() {
        return this.views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    @JsonProperty("desc")
    public String getDesc() {
        return this.desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @JsonProperty("region")
    public String getRegion() {
        return this.region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    @JsonProperty("location")
    public String getLocation() {
        return this.location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @JsonProperty("localization")
    public String getLocalization() {
        return this.localization;
    }

    public void setLocalization(String localization) {
        this.localization = localization;
    }

    @JsonProperty("categories")
    public ArrayList<Category> getCategories() {
        return this.categories;
    }

    public void setCategories(ArrayList<Category> categories) {
        this.categories = categories;
    }

    @JsonProperty("parameters")
    public ArrayList<Parameter> getParameters() {
        return this.parameters;
    }

    public void setParameters(ArrayList<Parameter> parameters) {
        this.parameters = parameters;
    }

    @JsonProperty("thumb_url")
    public String getThumb_url() {
        return this.thumb_url;
    }

    public void setThumb_url(String thumb_url) {
        this.thumb_url = thumb_url;
    }

    @JsonProperty("product_state")
    public String getProduct_state() {
        return this.product_state;
    }

    public void setProduct_state(String product_state) {
        this.product_state = product_state;
    }

    @JsonProperty("created_at")
    public Date getCreated_at() {
        return this.created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    @JsonProperty("stock")
    public int getStock() {
        return this.stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @JsonProperty("published")
    public boolean getPublished() {
        return this.published;
    }

    public void setPublished(boolean published) {
        this.published = published;
    }

    @JsonProperty("product_state_elastic")
    public String getProduct_state_elastic() {
        return this.product_state_elastic;
    }

    public void setProduct_state_elastic(String product_state_elastic) {
        this.product_state_elastic = product_state_elastic;
    }

    @JsonProperty("warranty")
    public Object getWarranty() {
        return this.warranty;
    }

    public void setWarranty(Object warranty) {
        this.warranty = warranty;
    }

    @JsonProperty("meta_data")
    public MetaData getMeta_data() {
        return this.meta_data;
    }

    public void setMeta_data(MetaData meta_data) {
        this.meta_data = meta_data;
    }

    @JsonProperty("category")
    public Category getCategory() {
        return this.category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @JsonProperty("images")
    public ArrayList<Image> getImages() {
        return this.images;
    }

    public void setImages(ArrayList<Image> images) {
        this.images = images;
    }

    @JsonProperty("merchant")
    public Object getMerchant() {
        return this.merchant;
    }

    public void setMerchant(Object merchant) {
        this.merchant = merchant;
    }
}
