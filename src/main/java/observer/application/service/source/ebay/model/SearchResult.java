package observer.application.service.source.ebay.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class SearchResult {

	@JacksonXmlProperty(localName = "item")
	@JacksonXmlElementWrapper(useWrapping = false)
	private List<EbayItem> ebayItems = new ArrayList<>();

	public void setEbayItems(EbayItem ebayItem) {
		ebayItems.add(ebayItem);
	}
}
