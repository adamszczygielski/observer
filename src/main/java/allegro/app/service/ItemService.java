package allegro.app.service;

import allegro.app.api.ItemDto;
import allegro.app.SOAPConnector;
import allegro.app.common.Assembler;
import allegro.app.common.ItemAssembler;
import allegro.app.common.ItemsListTypeAssembler;
import allegro.app.entity.Item;
import allegro.app.entity.Search;
import allegro.app.notification.NotificationService;
import allegro.app.repository.ItemRepository;
import allegro.app.repository.SearchRepository;
import allegro.app.wsdl.*;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.thymeleaf.util.StringUtils;

import java.sql.Timestamp;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@Service
@ComponentScan(basePackageClasses = SOAPConnector.class)
@ComponentScan(basePackageClasses = Assembler.class)
@ComponentScan(basePackageClasses = ItemAssembler.class)
@ComponentScan(basePackageClasses = ItemRepository.class)
@ComponentScan(basePackageClasses = SearchRepository.class)
@ComponentScan(basePackageClasses = ItemsListTypeAssembler.class)
public class ItemService {

    @Value("${allegro.webapi.key}")
    private String webapiKey;

    @Value("${allegro.webapi.url}")
    private String webServiceUrl;

    private SOAPConnector soapConnector;
    private Assembler assembler;
    private ItemAssembler itemAssembler;
    private ItemRepository itemRepository;
    private SearchRepository searchRepository;
    private ItemsListTypeAssembler itemsListTypeAssembler;

    public ItemService(SOAPConnector soapConnector, Assembler assembler, ItemRepository itemRepository, SearchRepository searchRepository, ItemAssembler itemAssembler, ItemsListTypeAssembler itemsListTypeAssembler) {
        this.soapConnector = soapConnector;
        this.assembler = assembler;
        this.itemRepository = itemRepository;
        this.searchRepository = searchRepository;
        this.itemAssembler = itemAssembler;
        this.itemsListTypeAssembler = itemsListTypeAssembler;
    }

    public List<ItemDto> fetchItems(Long searchId) {
        List<Item> itemList = itemRepository.findActiveItems(searchId);
        return itemAssembler.toDtoList(itemList);
    }

    public List<ItemDto> fetchItemsPreview(Long searchId) {
        Search search = searchRepository.findBySearchId(searchId);

        if(search == null) {
            return new ArrayList<>();
        }
        List<ItemsListType> itemsListTypeList = fetchItemList(search);

        if(CollectionUtils.isEmpty(itemsListTypeList)) {
            return new ArrayList<>();
        }

        return assembler.toDtoList(itemsListTypeList);
    }

    public void populateDatabase() {

        List<Search> searchList = searchRepository.findAll().stream().filter(s -> s.getLastUpdate()
                .before(new Timestamp(System.currentTimeMillis() - TimeUnit.MINUTES.toMillis(s.getTimeInterval()))))
                .collect(Collectors.toList());

        if(searchList.size()>0) {
            for(Search search : searchList) {
                populateDatabaseBySearch(search);
            }
        }
    }

    private void populateDatabaseBySearch(Search search) {

        List<ItemsListType> itemsListTypeList = fetchItemList(search);

        if(!CollectionUtils.isEmpty(itemsListTypeList)) {
            List<Long> itemIdsList = itemRepository.fetchItemIds();

            List<ItemsListType> newItems = itemsListTypeList
                    .stream().filter(item -> !itemIdsList.contains(item.getItemId()))
                    .collect(Collectors.toList());

            if(newItems.size()>0) {
                List<Item> itemList = itemsListTypeAssembler.toDtoList(newItems);

                for(Item i : itemList) {
                    i.setSearchId(search.getId());
                }

                Search searchWithNewItems = search;
                searchWithNewItems.getItemList().addAll(itemList);
                searchWithNewItems.setLastUpdate(new Timestamp(System.currentTimeMillis()));
                searchRepository.save(searchWithNewItems);

                if(search.getIsActive()) {
                    NotificationService.sendEmailNotification(searchWithNewItems);
                }


                return;
            }
        }
        search.setLastUpdate(new Timestamp(System.currentTimeMillis()));
        searchRepository.save(search);
    }

    public void deleteItem(Long itemId) {
        itemRepository.switchIsActive(itemId);
    }

    private List<ItemsListType> fetchItemList(Search search) {
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

        if(!org.springframework.util.StringUtils.isEmpty(search.getCategory())) {
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
