package observer.application.service.source.ebay.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;
import lombok.Data;

@Data
public class ConvertedCurrentPrice {

    @JacksonXmlProperty(isAttribute = true, localName = "currencyId")
    private String currencyId;

    @JacksonXmlText
    private String price;
}
