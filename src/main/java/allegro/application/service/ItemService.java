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
import allegro.application.repository.SoapRepository;
import allegro.application.wsdl.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.sql.Timestamp;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@Service
public class ItemService {

    private Assembler assembler;
    private ItemAssembler itemAssembler;
    private ItemRepository itemRepository;
    private SearchRepository searchRepository;
    private ItemsListTypeAssembler itemsListTypeAssembler;
    private SoapRepository soapRepository;

    public ItemService(Assembler assembler, ItemRepository itemRepository, SearchRepository searchRepository,
                       ItemAssembler itemAssembler, ItemsListTypeAssembler itemsListTypeAssembler, SoapRepository soapRepository) {
        this.assembler = assembler;
        this.itemRepository = itemRepository;
        this.searchRepository = searchRepository;
        this.itemAssembler = itemAssembler;
        this.itemsListTypeAssembler = itemsListTypeAssembler;
        this.soapRepository = soapRepository;
    }

    public List<ItemDto> fetchItems(Long searchId) {
        Optional<List<Item>> itemList = itemRepository.findActiveItems(searchId);

        if(itemList.isPresent()) {
            return itemAssembler.toDtoList(itemList.get());
        }

        return new ArrayList<>();
    }

    public List<ItemDto> fetchItemsPreview(Long searchId) {
        Optional<Search> search = searchRepository.findById(searchId);

        if(search.isPresent()) {
            List<ItemsListType> itemsListTypeList = soapRepository.fetchItemList(search.get(),0,100);
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
        List<ItemsListType> itemsListTypeList = soapRepository.fetchItemList(search, 0, 100);

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
}
