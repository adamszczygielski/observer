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

import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.annotations.ApiModelProperty;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * ParametersForPreviewPrice
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2019-09-16T16:12:46.567+02:00[Europe/Belgrade]")
public class ParametersForPreviewPrice {
  public static final String SERIALIZED_NAME_CATEGORY = "category";
  @SerializedName(SERIALIZED_NAME_CATEGORY)
  private Category category;

  /**
   * Offer condition, if is new, used or other.
   */
  @JsonAdapter(ConditionEnum.Adapter.class)
  public enum ConditionEnum {
    NEW("NEW"),
    
    USED("USED"),
    
    OTHER("OTHER");

    private String value;

    ConditionEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static ConditionEnum fromValue(String value) {
      for (ConditionEnum b : ConditionEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<ConditionEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final ConditionEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public ConditionEnum read(final JsonReader jsonReader) throws IOException {
        String value = jsonReader.nextString();
        return ConditionEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_CONDITION = "condition";
  @SerializedName(SERIALIZED_NAME_CONDITION)
  private ConditionEnum condition;

  /**
   * Gets or Sets duration
   */
  @JsonAdapter(DurationEnum.Adapter.class)
  public enum DurationEnum {
    PT72H("PT72H"),
    
    PT120H("PT120H"),
    
    PT168H("PT168H"),
    
    PT240H("PT240H"),
    
    PT336H("PT336H"),
    
    PT480H("PT480H"),
    
    PT720H("PT720H");

    private String value;

    DurationEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static DurationEnum fromValue(String value) {
      for (DurationEnum b : DurationEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<DurationEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final DurationEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public DurationEnum read(final JsonReader jsonReader) throws IOException {
        String value = jsonReader.nextString();
        return DurationEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_DURATION = "duration";
  @SerializedName(SERIALIZED_NAME_DURATION)
  private DurationEnum duration;

  public static final String SERIALIZED_NAME_HAS_ANY_QUANTITY = "hasAnyQuantity";
  @SerializedName(SERIALIZED_NAME_HAS_ANY_QUANTITY)
  private Boolean hasAnyQuantity;

  public static final String SERIALIZED_NAME_NUMBER_OF_BIG_PHOTOS = "numberOfBigPhotos";
  @SerializedName(SERIALIZED_NAME_NUMBER_OF_BIG_PHOTOS)
  private Integer numberOfBigPhotos;

  public static final String SERIALIZED_NAME_NUMBER_OF_PHOTOS = "numberOfPhotos";
  @SerializedName(SERIALIZED_NAME_NUMBER_OF_PHOTOS)
  private Integer numberOfPhotos;

  public static final String SERIALIZED_NAME_QUANTITY = "quantity";
  @SerializedName(SERIALIZED_NAME_QUANTITY)
  private Integer quantity;

  public static final String SERIALIZED_NAME_SHOP = "shop";
  @SerializedName(SERIALIZED_NAME_SHOP)
  private Boolean shop;

  public static final String SERIALIZED_NAME_SOLD_QUANTITY = "soldQuantity";
  @SerializedName(SERIALIZED_NAME_SOLD_QUANTITY)
  private Integer soldQuantity;

  /**
   * Offer type. &#39;type&#39; or &#39;shop&#39; fields must be provided. Takes precedence over &#39;shop&#39; field. Note: if type &#x3D; &#39;advertisement&#39; then either &#39;quantity&#39; or &#39;soldQuantity&#39; field must be set.
   */
  @JsonAdapter(TypeEnum.Adapter.class)
  public enum TypeEnum {
    SHOP("shop"),
    
    OFFER("offer"),
    
    ADVERTISEMENT("advertisement");

    private String value;

    TypeEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static TypeEnum fromValue(String value) {
      for (TypeEnum b : TypeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<TypeEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final TypeEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public TypeEnum read(final JsonReader jsonReader) throws IOException {
        String value = jsonReader.nextString();
        return TypeEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_TYPE = "type";
  @SerializedName(SERIALIZED_NAME_TYPE)
  private TypeEnum type;

  public static final String SERIALIZED_NAME_UNIT_PRICE = "unitPrice";
  @SerializedName(SERIALIZED_NAME_UNIT_PRICE)
  private BigDecimal unitPrice;

  public static final String SERIALIZED_NAME_BOLD = "bold";
  @SerializedName(SERIALIZED_NAME_BOLD)
  private Boolean bold;

  public static final String SERIALIZED_NAME_HIGHLIGHT = "highlight";
  @SerializedName(SERIALIZED_NAME_HIGHLIGHT)
  private Boolean highlight;

  public static final String SERIALIZED_NAME_DEPARTMENT_PAGE = "departmentPage";
  @SerializedName(SERIALIZED_NAME_DEPARTMENT_PAGE)
  private Boolean departmentPage;

  public static final String SERIALIZED_NAME_EMPHASIZED = "emphasized";
  @SerializedName(SERIALIZED_NAME_EMPHASIZED)
  private Boolean emphasized;

  public static final String SERIALIZED_NAME_EMPHASIZED_HIGHLIGHT_BOLD_PACKAGE = "emphasizedHighlightBoldPackage";
  @SerializedName(SERIALIZED_NAME_EMPHASIZED_HIGHLIGHT_BOLD_PACKAGE)
  private Boolean emphasizedHighlightBoldPackage;

  public static final String SERIALIZED_NAME_MULTI_VARIANT = "multiVariant";
  @SerializedName(SERIALIZED_NAME_MULTI_VARIANT)
  private Boolean multiVariant;


  public ParametersForPreviewPrice category(Category category) {
    
    this.category = category;
    return this;
  }

   /**
   * Get category
   * @return category
  **/
  @ApiModelProperty(required = true, value = "")

  public Category getCategory() {
    return category;
  }



  public void setCategory(Category category) {
    this.category = category;
  }


  public ParametersForPreviewPrice condition(ConditionEnum condition) {
    
    this.condition = condition;
    return this;
  }

   /**
   * Offer condition, if is new, used or other.
   * @return condition
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Offer condition, if is new, used or other.")

  public ConditionEnum getCondition() {
    return condition;
  }



  public void setCondition(ConditionEnum condition) {
    this.condition = condition;
  }


  public ParametersForPreviewPrice duration(DurationEnum duration) {
    
    this.duration = duration;
    return this;
  }

   /**
   * Get duration
   * @return duration
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public DurationEnum getDuration() {
    return duration;
  }



  public void setDuration(DurationEnum duration) {
    this.duration = duration;
  }


  public ParametersForPreviewPrice hasAnyQuantity(Boolean hasAnyQuantity) {
    
    this.hasAnyQuantity = hasAnyQuantity;
    return this;
  }

   /**
   * Get hasAnyQuantity
   * @return hasAnyQuantity
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Boolean getHasAnyQuantity() {
    return hasAnyQuantity;
  }



  public void setHasAnyQuantity(Boolean hasAnyQuantity) {
    this.hasAnyQuantity = hasAnyQuantity;
  }


  public ParametersForPreviewPrice numberOfBigPhotos(Integer numberOfBigPhotos) {
    
    this.numberOfBigPhotos = numberOfBigPhotos;
    return this;
  }

   /**
   * If set, minimum value 0
   * @return numberOfBigPhotos
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "If set, minimum value 0")

  public Integer getNumberOfBigPhotos() {
    return numberOfBigPhotos;
  }



  public void setNumberOfBigPhotos(Integer numberOfBigPhotos) {
    this.numberOfBigPhotos = numberOfBigPhotos;
  }


  public ParametersForPreviewPrice numberOfPhotos(Integer numberOfPhotos) {
    
    this.numberOfPhotos = numberOfPhotos;
    return this;
  }

   /**
   * If set, minimum value 0
   * @return numberOfPhotos
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "If set, minimum value 0")

  public Integer getNumberOfPhotos() {
    return numberOfPhotos;
  }



  public void setNumberOfPhotos(Integer numberOfPhotos) {
    this.numberOfPhotos = numberOfPhotos;
  }


  public ParametersForPreviewPrice quantity(Integer quantity) {
    
    this.quantity = quantity;
    return this;
  }

   /**
   * Quantity of items to be sold. If set, minimum value 1
   * @return quantity
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Quantity of items to be sold. If set, minimum value 1")

  public Integer getQuantity() {
    return quantity;
  }



  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }


  public ParametersForPreviewPrice shop(Boolean shop) {
    
    this.shop = shop;
    return this;
  }

   /**
   * Deprecated. Value &#39;true&#39; sets the &#39;offer.type&#39; field to &#39;shop&#39;, value &#39;false&#39; to &#39;offer&#39;. This field is ignored if &#39;offer.type&#39; field is set.
   * @return shop
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "false", value = "Deprecated. Value 'true' sets the 'offer.type' field to 'shop', value 'false' to 'offer'. This field is ignored if 'offer.type' field is set.")

  public Boolean getShop() {
    return shop;
  }



  public void setShop(Boolean shop) {
    this.shop = shop;
  }


  public ParametersForPreviewPrice soldQuantity(Integer soldQuantity) {
    
    this.soldQuantity = soldQuantity;
    return this;
  }

   /**
   * Quantity of sold items. Relates to commission success fee. If set, minimum value 1
   * @return soldQuantity
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Quantity of sold items. Relates to commission success fee. If set, minimum value 1")

  public Integer getSoldQuantity() {
    return soldQuantity;
  }



  public void setSoldQuantity(Integer soldQuantity) {
    this.soldQuantity = soldQuantity;
  }


  public ParametersForPreviewPrice type(TypeEnum type) {
    
    this.type = type;
    return this;
  }

   /**
   * Offer type. &#39;type&#39; or &#39;shop&#39; fields must be provided. Takes precedence over &#39;shop&#39; field. Note: if type &#x3D; &#39;advertisement&#39; then either &#39;quantity&#39; or &#39;soldQuantity&#39; field must be set.
   * @return type
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Offer type. 'type' or 'shop' fields must be provided. Takes precedence over 'shop' field. Note: if type = 'advertisement' then either 'quantity' or 'soldQuantity' field must be set.")

  public TypeEnum getType() {
    return type;
  }



  public void setType(TypeEnum type) {
    this.type = type;
  }


  public ParametersForPreviewPrice unitPrice(BigDecimal unitPrice) {
    
    this.unitPrice = unitPrice;
    return this;
  }

   /**
   * Get unitPrice
   * @return unitPrice
  **/
  @ApiModelProperty(required = true, value = "")

  public BigDecimal getUnitPrice() {
    return unitPrice;
  }



  public void setUnitPrice(BigDecimal unitPrice) {
    this.unitPrice = unitPrice;
  }


  public ParametersForPreviewPrice bold(Boolean bold) {
    
    this.bold = bold;
    return this;
  }

   /**
   * Get bold
   * @return bold
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Boolean getBold() {
    return bold;
  }



  public void setBold(Boolean bold) {
    this.bold = bold;
  }


  public ParametersForPreviewPrice highlight(Boolean highlight) {
    
    this.highlight = highlight;
    return this;
  }

   /**
   * Get highlight
   * @return highlight
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Boolean getHighlight() {
    return highlight;
  }



  public void setHighlight(Boolean highlight) {
    this.highlight = highlight;
  }


  public ParametersForPreviewPrice departmentPage(Boolean departmentPage) {
    
    this.departmentPage = departmentPage;
    return this;
  }

   /**
   * Get departmentPage
   * @return departmentPage
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Boolean getDepartmentPage() {
    return departmentPage;
  }



  public void setDepartmentPage(Boolean departmentPage) {
    this.departmentPage = departmentPage;
  }


  public ParametersForPreviewPrice emphasized(Boolean emphasized) {
    
    this.emphasized = emphasized;
    return this;
  }

   /**
   * Get emphasized
   * @return emphasized
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Boolean getEmphasized() {
    return emphasized;
  }



  public void setEmphasized(Boolean emphasized) {
    this.emphasized = emphasized;
  }


  public ParametersForPreviewPrice emphasizedHighlightBoldPackage(Boolean emphasizedHighlightBoldPackage) {
    
    this.emphasizedHighlightBoldPackage = emphasizedHighlightBoldPackage;
    return this;
  }

   /**
   * Get emphasizedHighlightBoldPackage
   * @return emphasizedHighlightBoldPackage
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Boolean getEmphasizedHighlightBoldPackage() {
    return emphasizedHighlightBoldPackage;
  }



  public void setEmphasizedHighlightBoldPackage(Boolean emphasizedHighlightBoldPackage) {
    this.emphasizedHighlightBoldPackage = emphasizedHighlightBoldPackage;
  }


  public ParametersForPreviewPrice multiVariant(Boolean multiVariant) {
    
    this.multiVariant = multiVariant;
    return this;
  }

   /**
   * Get multiVariant
   * @return multiVariant
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Boolean getMultiVariant() {
    return multiVariant;
  }



  public void setMultiVariant(Boolean multiVariant) {
    this.multiVariant = multiVariant;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ParametersForPreviewPrice parametersForPreviewPrice = (ParametersForPreviewPrice) o;
    return Objects.equals(this.category, parametersForPreviewPrice.category) &&
        Objects.equals(this.condition, parametersForPreviewPrice.condition) &&
        Objects.equals(this.duration, parametersForPreviewPrice.duration) &&
        Objects.equals(this.hasAnyQuantity, parametersForPreviewPrice.hasAnyQuantity) &&
        Objects.equals(this.numberOfBigPhotos, parametersForPreviewPrice.numberOfBigPhotos) &&
        Objects.equals(this.numberOfPhotos, parametersForPreviewPrice.numberOfPhotos) &&
        Objects.equals(this.quantity, parametersForPreviewPrice.quantity) &&
        Objects.equals(this.shop, parametersForPreviewPrice.shop) &&
        Objects.equals(this.soldQuantity, parametersForPreviewPrice.soldQuantity) &&
        Objects.equals(this.type, parametersForPreviewPrice.type) &&
        Objects.equals(this.unitPrice, parametersForPreviewPrice.unitPrice) &&
        Objects.equals(this.bold, parametersForPreviewPrice.bold) &&
        Objects.equals(this.highlight, parametersForPreviewPrice.highlight) &&
        Objects.equals(this.departmentPage, parametersForPreviewPrice.departmentPage) &&
        Objects.equals(this.emphasized, parametersForPreviewPrice.emphasized) &&
        Objects.equals(this.emphasizedHighlightBoldPackage, parametersForPreviewPrice.emphasizedHighlightBoldPackage) &&
        Objects.equals(this.multiVariant, parametersForPreviewPrice.multiVariant);
  }

  @Override
  public int hashCode() {
    return Objects.hash(category, condition, duration, hasAnyQuantity, numberOfBigPhotos, numberOfPhotos, quantity, shop, soldQuantity, type, unitPrice, bold, highlight, departmentPage, emphasized, emphasizedHighlightBoldPackage, multiVariant);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ParametersForPreviewPrice {\n");
    sb.append("    category: ").append(toIndentedString(category)).append("\n");
    sb.append("    condition: ").append(toIndentedString(condition)).append("\n");
    sb.append("    duration: ").append(toIndentedString(duration)).append("\n");
    sb.append("    hasAnyQuantity: ").append(toIndentedString(hasAnyQuantity)).append("\n");
    sb.append("    numberOfBigPhotos: ").append(toIndentedString(numberOfBigPhotos)).append("\n");
    sb.append("    numberOfPhotos: ").append(toIndentedString(numberOfPhotos)).append("\n");
    sb.append("    quantity: ").append(toIndentedString(quantity)).append("\n");
    sb.append("    shop: ").append(toIndentedString(shop)).append("\n");
    sb.append("    soldQuantity: ").append(toIndentedString(soldQuantity)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    unitPrice: ").append(toIndentedString(unitPrice)).append("\n");
    sb.append("    bold: ").append(toIndentedString(bold)).append("\n");
    sb.append("    highlight: ").append(toIndentedString(highlight)).append("\n");
    sb.append("    departmentPage: ").append(toIndentedString(departmentPage)).append("\n");
    sb.append("    emphasized: ").append(toIndentedString(emphasized)).append("\n");
    sb.append("    emphasizedHighlightBoldPackage: ").append(toIndentedString(emphasizedHighlightBoldPackage)).append("\n");
    sb.append("    multiVariant: ").append(toIndentedString(multiVariant)).append("\n");
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

