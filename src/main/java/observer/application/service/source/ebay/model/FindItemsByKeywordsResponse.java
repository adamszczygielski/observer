package observer.application.service.source.ebay.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Data;

@Data
@JacksonXmlRootElement(localName = "findItemsByKeywordsResponse")
public class FindItemsByKeywordsResponse {

    @JacksonXmlProperty(localName = "searchResult")
    private SearchResult searchResult;
}
