package allegro.application.service;

import allegro.application.api.ItemDto;
import allegro.application.SOAPConnector;
import allegro.application.common.Assembler;
import allegro.application.common.ItemAssembler;
import allegro.application.common.ItemsListTypeAssembler;
import allegro.application.entity.Item;
import allegro.application.entity.Search;
import allegro.application.repository.ItemRepository;
import allegro.application.repository.SearchRepository;
import allegro.application.wsdl.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

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

    public ItemService(SOAPConnector soapConnector, Assembler assembler, ItemRepository itemRepository,
                       SearchRepository searchRepository, ItemAssembler itemAssembler, ItemsListTypeAssembler itemsListTypeAssembler) {
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
        Optional<Search> search = searchRepository.findById(searchId);

        if(search.isPresent()) {
            List<ItemsListType> itemsListTypeList = fetchItemList(search.get(),0,100);
            if(!CollectionUtils.isEmpty(itemsListTypeList)) {
                return assembler.toDtoList(itemsListTypeList);
            }
        }
        return new ArrayList<>();
    }

    public void populateDatabase() {
        searchRepository.findAll().stream()
                .filter(s -> s.getLastUpdate().before(new Timestamp(System.currentTimeMillis() - TimeUnit.MINUTES.toMillis(s.getTimeInterval()))))
                .forEach(this::populateDatabase);
    }

    private void populateDatabase(Search search) {

        List<ItemsListType> itemsListTypeList = fetchItemList(search, 0, 100);

        if(!CollectionUtils.isEmpty(itemsListTypeList)) {
            List<Long> itemIdsList = search.getItemList().stream()
                    .map(i -> i.getItemId()).collect(Collectors.toCollection(ArrayList::new));

            List<ItemsListType> newItems = itemsListTypeList
                    .stream().filter(item -> !itemIdsList.contains(item.getItemId()))
                    .collect(Collectors.toList());

            if(newItems.size()>0) {
                List<Item> itemList = itemsListTypeAssembler.toDtoList(newItems).stream()
                        .map(item -> {item.setSearchId(search.getId()); return item;})
                        .collect(Collectors.toList());

                search.getItemList().addAll(itemList);
//                if(search.getIsActive()) { NotificationService.sendEmailNotification(searchWithNewItems); }
            }
        }

        search.setLastUpdate(new Timestamp(System.currentTimeMillis()));
        searchRepository.save(search);
    }

    public void deleteItem(Long itemId) {
        itemRepository.findById(itemId).ifPresent(item -> {
            item.setIsActive(false);
            itemRepository.save(item);
        });
    }

    private List<ItemsListType> fetchItemList(Search search, int offset, int size) {
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
