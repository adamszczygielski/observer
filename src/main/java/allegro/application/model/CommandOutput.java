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
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * The output of the command.
 */
@ApiModel(description = "The output of the command.")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2019-09-16T16:12:46.567+02:00[Europe/Belgrade]")
public class CommandOutput {
  public static final String SERIALIZED_NAME_STATUS = "status";
  @SerializedName(SERIALIZED_NAME_STATUS)
  private ProcessingStatus status;

  public static final String SERIALIZED_NAME_ERRORS = "errors";
  @SerializedName(SERIALIZED_NAME_ERRORS)
  private List<Error> errors = null;


  public CommandOutput status(ProcessingStatus status) {
    
    this.status = status;
    return this;
  }

   /**
   * Get status
   * @return status
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public ProcessingStatus getStatus() {
    return status;
  }



  public void setStatus(ProcessingStatus status) {
    this.status = status;
  }


  public CommandOutput errors(List<Error> errors) {
    
    this.errors = errors;
    return this;
  }

  public CommandOutput addErrorsItem(Error errorsItem) {
    if (this.errors == null) {
      this.errors = new ArrayList<Error>();
    }
    this.errors.add(errorsItem);
    return this;
  }

   /**
   * Get errors
   * @return errors
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public List<Error> getErrors() {
    return errors;
  }



  public void setErrors(List<Error> errors) {
    this.errors = errors;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CommandOutput commandOutput = (CommandOutput) o;
    return Objects.equals(this.status, commandOutput.status) &&
        Objects.equals(this.errors, commandOutput.errors);
  }

  @Override
  public int hashCode() {
    return Objects.hash(status, errors);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CommandOutput {\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    errors: ").append(toIndentedString(errors)).append("\n");
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

