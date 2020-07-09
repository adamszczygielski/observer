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


package allegro.application.service.source.allegro.model;

import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModelProperty;

import java.util.Objects;
import java.util.UUID;

/**
 * ChangePriceWithoutOutput
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2019-09-16T16:12:46.567+02:00[Europe/Belgrade]")
public class ChangePriceWithoutOutput {
  public static final String SERIALIZED_NAME_ID = "id";
  @SerializedName(SERIALIZED_NAME_ID)
  private UUID id;

  public static final String SERIALIZED_NAME_INPUT = "input";
  @SerializedName(SERIALIZED_NAME_INPUT)
  private ChangePriceInput input;


  public ChangePriceWithoutOutput id(UUID id) {
    
    this.id = id;
    return this;
  }

   /**
   * The unique command id generated by you. This should be the same UUID as used in the path.
   * @return id
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "6365996a-6cae-11e9-a923-1681be663d3e", value = "The unique command id generated by you. This should be the same UUID as used in the path.")

  public UUID getId() {
    return id;
  }



  public void setId(UUID id) {
    this.id = id;
  }


  public ChangePriceWithoutOutput input(ChangePriceInput input) {
    
    this.input = input;
    return this;
  }

   /**
   * Get input
   * @return input
  **/
  @ApiModelProperty(required = true, value = "")

  public ChangePriceInput getInput() {
    return input;
  }



  public void setInput(ChangePriceInput input) {
    this.input = input;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ChangePriceWithoutOutput changePriceWithoutOutput = (ChangePriceWithoutOutput) o;
    return Objects.equals(this.id, changePriceWithoutOutput.id) &&
        Objects.equals(this.input, changePriceWithoutOutput.input);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, input);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ChangePriceWithoutOutput {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    input: ").append(toIndentedString(input)).append("\n");
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
