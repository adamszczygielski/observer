package observer.application.service.source.ebay.mapper;

import observer.application.model.Item;
import observer.application.model.Search;
import observer.application.model.Source;
import observer.application.service.source.ebay.model.ConvertedCurrentPrice;
import observer.application.service.source.ebay.model.EbayItem;
import org.springframework.web.util.UriComponentsBuilder;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

public class EbayMapper {

    public String toUrl(Search search, String ebaySecurityAppname) {
        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.newInstance()
                .scheme("https")
                .host("svcs.ebay.com")
                .pathSegment("services")
                .pathSegment("search")
                .pathSegment("FindingService")
                .pathSegment("v1")
                .queryParam("OPERATION-NAME", "findItemsByKeywords")
                .queryParam("SERVICE-VERSION", "1.13.0")
                .queryParam("SECURITY-APPNAME", ebaySecurityAppname)
                .queryParam("RESPONSE-DATA-FORMAT", "XML")
                .queryParam("GLOBAL-ID", "EBAY-PL")
                .queryParam("keywords", search.getKeyword().replaceAll(" ", "+"))
                .queryParam("sortOrder", "StartTimeNewest")
                .queryParam("paginationInput.entriesPerPage", "30");

        if (search.getPriceFrom() != null) {
            uriComponentsBuilder.queryParam("itemFilter(0).name", "MinPrice");
            uriComponentsBuilder.queryParam("itemFilter(0).value", search.getPriceFrom());
            uriComponentsBuilder.queryParam("itemFilter(0).paramName", "Currency");
            uriComponentsBuilder.queryParam("itemFilter(0).paramValue", "PLN");
        }

        if (search.getPriceTo() != null) {
            uriComponentsBuilder.queryParam("itemFilter(1).name", "MaxPrice");
            uriComponentsBuilder.queryParam("itemFilter(1).value", search.getPriceTo());
            uriComponentsBuilder.queryParam("itemFilter(1).paramName", "Currency");
            uriComponentsBuilder.queryParam("itemFilter(1).paramValue", "PLN");
        }

        return uriComponentsBuilder.build()
                .toUri()
                .toString();
    }

    public List<Item> toItems(List<EbayItem> ebayItems, Long searchId) {
        return ebayItems.stream().map(ebayItem -> toItem(ebayItem, searchId))
                .collect(Collectors.toList());
    }

    private Item toItem(EbayItem ebayItem, Long searchId) {
        return Item.builder()
                .originId(ebayItem.getItemId())
                .searchId(searchId)
                .createdDate(Instant.now())
                .title(ebayItem.getTitle())
                .price(toPrice(ebayItem.getSellingStatus().getConvertedCurrentPrice()))
                .url(ebayItem.getViewItemURL())
                .isDeleted(false)
                .isNotificationSent(false)
                .sourceId(Source.EBAY.getId())
                .build();
    }

    private String toPrice(ConvertedCurrentPrice convertedCurrentPrice) {
        return convertedCurrentPrice.getPrice() + " " + convertedCurrentPrice.getCurrencyId();
    }
}
