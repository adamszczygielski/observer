package observer.application.service.source.ebay.mapper;

import observer.application.model.Search;
import observer.application.model.Source;
import observer.application.model.Item;
import observer.application.service.source.ebay.model.Amount;
import observer.application.service.source.ebay.model.SearchItem;
import observer.application.service.source.ebay.model.SellingStatus;
import org.springframework.web.util.UriComponentsBuilder;

import java.text.DecimalFormat;
import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

public class EbayMapper {

    private static final DecimalFormat decimalFormat = new DecimalFormat("#.00");

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
                .queryParam("keywords", search.getKeyword().replaceAll(" ", "+"))
                .queryParam("sortOrder", "StartTimeNewest")
                .queryParam("paginationInput.entriesPerPage", "30");

        Integer priceFrom = search.getPriceFrom();
        if (priceFrom != null) {
            uriComponentsBuilder.queryParam("itemFilter(0).name", "MinPrice");
            uriComponentsBuilder.queryParam("itemFilter(0).value", priceFrom);
            uriComponentsBuilder.queryParam("itemFilter(0).paramName", "Currency");
            uriComponentsBuilder.queryParam("itemFilter(0).paramValue", "PLN");
        }

        Integer priceTo = search.getPriceTo();
        if (priceTo != null) {
            uriComponentsBuilder.queryParam("itemFilter(1).name", "MaxPrice");
            uriComponentsBuilder.queryParam("itemFilter(1).value", priceTo);
            uriComponentsBuilder.queryParam("itemFilter(1).paramName", "Currency");
            uriComponentsBuilder.queryParam("itemFilter(1).paramValue", "PLN");
        }

        return uriComponentsBuilder.build()
                .toUri()
                .toString();
    }

    public List<Item> toItems(List<SearchItem> searchItemList, Long searchId) {
        return searchItemList.stream().map(searchItem -> toItem(searchItem, searchId))
                .collect(Collectors.toList());
    }

    private Item toItem(SearchItem searchItem, Long searchId) {
        return Item.builder()
                .originId(searchItem.getItemId())
                .searchId(searchId)
                .createdDate(Instant.now())
                .title(searchItem.getTitle())
                .price(toPrice(searchItem.getSellingStatus()))
                .url(searchItem.getViewItemURL())
                .isDeleted(false)
                .isNotificationSent(false)
                .sourceId(Source.EBAY.getId())
                .build();
    }

    private String toPrice(SellingStatus sellingStatus) {
        Amount amount = sellingStatus.getCurrentPrice();
        return decimalFormat.format(amount.getValue()) + " " + amount.getCurrencyId();
    }
}
