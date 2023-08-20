package observer.application.service.source.ebay.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Data;

@Data
public class SellingStatus {

    @JacksonXmlProperty(localName = "convertedCurrentPrice")
	private ConvertedCurrentPrice convertedCurrentPrice;
}
