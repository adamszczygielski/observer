package observer.application.service.source.loombard.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Options {
    boolean variantsByColorPatternAllowed;
    boolean advertisement;
    boolean offersWithProductPublicationEnabled;
    boolean productCreationEnabled;
    boolean sellerCanRequirePurchaseComments;

    @JsonProperty("variantsByColorPatternAllowed")
    public boolean getVariantsByColorPatternAllowed() {
        return this.variantsByColorPatternAllowed;
    }

    public void setVariantsByColorPatternAllowed(boolean variantsByColorPatternAllowed) {
        this.variantsByColorPatternAllowed = variantsByColorPatternAllowed;
    }

    @JsonProperty("advertisement")
    public boolean getAdvertisement() {
        return this.advertisement;
    }

    public void setAdvertisement(boolean advertisement) {
        this.advertisement = advertisement;
    }

    @JsonProperty("offersWithProductPublicationEnabled")
    public boolean getOffersWithProductPublicationEnabled() {
        return this.offersWithProductPublicationEnabled;
    }

    public void setOffersWithProductPublicationEnabled(boolean offersWithProductPublicationEnabled) {
        this.offersWithProductPublicationEnabled = offersWithProductPublicationEnabled;
    }

    @JsonProperty("productCreationEnabled")
    public boolean getProductCreationEnabled() {
        return this.productCreationEnabled;
    }

    public void setProductCreationEnabled(boolean productCreationEnabled) {
        this.productCreationEnabled = productCreationEnabled;
    }

    @JsonProperty("sellerCanRequirePurchaseComments")
    public boolean getSellerCanRequirePurchaseComments() {
        return this.sellerCanRequirePurchaseComments;
    }

    public void setSellerCanRequirePurchaseComments(boolean sellerCanRequirePurchaseComments) {
        this.sellerCanRequirePurchaseComments = sellerCanRequirePurchaseComments;
    }
}
