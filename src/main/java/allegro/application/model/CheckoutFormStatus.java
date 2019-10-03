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
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

/**
 * Describes status of the form delivery and purchase options based on payment and purchase status. * &#x60;BOUGHT&#x60; - purchase without checkout form filled in * &#x60;FILLED_IN&#x60; - checkout form filled in but payment is not completed yet so data could still change * &#x60;READY_FOR_PROCESSING&#x60; - payment completed. Purchase is ready for processing. 
 */
@JsonAdapter(CheckoutFormStatus.Adapter.class)
public enum CheckoutFormStatus {
  
  BOUGHT("BOUGHT"),
  
  FILLED_IN("FILLED_IN"),
  
  READY_FOR_PROCESSING("READY_FOR_PROCESSING");

  private String value;

  CheckoutFormStatus(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }

  public static CheckoutFormStatus fromValue(String value) {
    for (CheckoutFormStatus b : CheckoutFormStatus.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }

  public static class Adapter extends TypeAdapter<CheckoutFormStatus> {
    @Override
    public void write(final JsonWriter jsonWriter, final CheckoutFormStatus enumeration) throws IOException {
      jsonWriter.value(enumeration.getValue());
    }

    @Override
    public CheckoutFormStatus read(final JsonReader jsonReader) throws IOException {
      String value = jsonReader.nextString();
      return CheckoutFormStatus.fromValue(value);
    }
  }
}

