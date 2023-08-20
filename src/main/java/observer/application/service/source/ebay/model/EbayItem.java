package observer.application.service.source.ebay.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Data;

@Data
public class EbayItem {

	@JacksonXmlProperty(localName = "itemId")
	private String itemId;

	@JacksonXmlProperty(localName = "title")
	private String title;

	@JacksonXmlProperty(localName = "viewItemURL")
	private String viewItemURL;

	@JacksonXmlProperty(localName = "sellingStatus")
	private SellingStatus sellingStatus;
}
