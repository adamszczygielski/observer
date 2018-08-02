package allegro.application.repository;

import allegro.application.SOAPConnector;
import allegro.application.entity.Search;
import allegro.application.wsdl.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Component
public class SoapRepository {

    @Value("${allegro.webapi.key}")
    private String webapiKey;

    @Value("${allegro.webapi.url}")
    private String webServiceUrl;

    private SOAPConnector soapConnector;

    public SoapRepository(SOAPConnector soapConnector) {
        this.soapConnector = soapConnector;
    }

    public List<ItemsListType> fetchItemList(Search search, int offset, int size) {
        DoGetItemsListRequest doGetItemsListRequest = new DoGetItemsListRequest();
        doGetItemsListRequest.setWebapiKey(webapiKey);
        doGetItemsListRequest.setCountryId(1);
        doGetItemsListRequest.setResultSize(100);
        doGetItemsListRequest.setResultOffset(0);

        ArrayOfFilteroptionstype arrayOfFilteroptionstype = new ArrayOfFilteroptionstype();

        FilterOptionsType searchFilter = new FilterOptionsType();
        searchFilter.setFilterId("search");
        ArrayOfString arrayOfString = new ArrayOfString();
        arrayOfString.getItem().add(search.getKeyword());
        searchFilter.setFilterValueId(arrayOfString);
        arrayOfFilteroptionstype.getItem().add(searchFilter);

        if(!StringUtils.isEmpty(search.getCategory())) {
            FilterOptionsType categoryFilter = new FilterOptionsType();
            categoryFilter.setFilterId("category");
            ArrayOfString categories = new ArrayOfString();
            categories.getItem().add(search.getCategory());
            categoryFilter.setFilterValueId(categories);
            arrayOfFilteroptionstype.getItem().add(categoryFilter);
        }

        doGetItemsListRequest.setFilterOptions(arrayOfFilteroptionstype);

        SortOptionsType sortOptionsType = new SortOptionsType();
        sortOptionsType.setSortType("startingTime");
        sortOptionsType.setSortOrder("desc");
        doGetItemsListRequest.setSortOptions(sortOptionsType);

        DoGetItemsListResponse doGetItemsListResponse = (DoGetItemsListResponse) soapConnector.callWebService(webServiceUrl, doGetItemsListRequest);

        List<ItemsListType> itemsListTypeList = new ArrayList<>();

        if(doGetItemsListResponse != null && doGetItemsListResponse.getItemsCount() > 0) {
            itemsListTypeList = doGetItemsListResponse.getItemsList().getItem();
        }

        return itemsListTypeList;
    }
}
