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

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * DictionaryCategoryProductParameterAllOf
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2019-09-16T16:12:46.567+02:00[Europe/Belgrade]")
public class DictionaryCategoryProductParameterAllOf {
  public static final String SERIALIZED_NAME_TYPE = "type";
  @SerializedName(SERIALIZED_NAME_TYPE)
  private String type = "dictionary";

  public static final String SERIALIZED_NAME_RESTRICTIONS = "restrictions";
  @SerializedName(SERIALIZED_NAME_RESTRICTIONS)
  private DictionaryCategoryProductParameterAllOfRestrictions restrictions;

  public static final String SERIALIZED_NAME_DICTIONARY = "dictionary";
  @SerializedName(SERIALIZED_NAME_DICTIONARY)
  private List<DictionaryCategoryProductParameterAllOfDictionary> dictionary = null;


  public DictionaryCategoryProductParameterAllOf type(String type) {
    
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


  public DictionaryCategoryProductParameterAllOf restrictions(DictionaryCategoryProductParameterAllOfRestrictions restrictions) {
    
    this.restrictions = restrictions;
    return this;
  }

   /**
   * Get restrictions
   * @return restrictions
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public DictionaryCategoryProductParameterAllOfRestrictions getRestrictions() {
    return restrictions;
  }



  public void setRestrictions(DictionaryCategoryProductParameterAllOfRestrictions restrictions) {
    this.restrictions = restrictions;
  }


  public DictionaryCategoryProductParameterAllOf dictionary(List<DictionaryCategoryProductParameterAllOfDictionary> dictionary) {
    
    this.dictionary = dictionary;
    return this;
  }

  public DictionaryCategoryProductParameterAllOf addDictionaryItem(DictionaryCategoryProductParameterAllOfDictionary dictionaryItem) {
    if (this.dictionary == null) {
      this.dictionary = new ArrayList<DictionaryCategoryProductParameterAllOfDictionary>();
    }
    this.dictionary.add(dictionaryItem);
    return this;
  }

   /**
   * Defines the values accepted for this parameter.
   * @return dictionary
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Defines the values accepted for this parameter.")

  public List<DictionaryCategoryProductParameterAllOfDictionary> getDictionary() {
    return dictionary;
  }



  public void setDictionary(List<DictionaryCategoryProductParameterAllOfDictionary> dictionary) {
    this.dictionary = dictionary;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DictionaryCategoryProductParameterAllOf dictionaryCategoryProductParameterAllOf = (DictionaryCategoryProductParameterAllOf) o;
    return Objects.equals(this.type, dictionaryCategoryProductParameterAllOf.type) &&
        Objects.equals(this.restrictions, dictionaryCategoryProductParameterAllOf.restrictions) &&
        Objects.equals(this.dictionary, dictionaryCategoryProductParameterAllOf.dictionary);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, restrictions, dictionary);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DictionaryCategoryProductParameterAllOf {\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    restrictions: ").append(toIndentedString(restrictions)).append("\n");
    sb.append("    dictionary: ").append(toIndentedString(dictionary)).append("\n");
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
