package allegro.application.service;

import allegro.application.api.ItemDto;
import allegro.application.common.Assembler;
import allegro.application.common.ItemAssembler;
import allegro.application.common.ItemsListTypeAssembler;
import allegro.application.entity.Item;
import allegro.application.entity.Search;
import allegro.application.repository.ItemRepository;
import allegro.application.repository.SearchRepository;
import allegro.application.repository.SoapRepository;
import allegro.application.wsdl.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.sql.Timestamp;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ItemService {

    private Assembler assembler;
    private ItemAssembler itemAssembler;
    private ItemRepository itemRepository;
    private SearchRepository searchRepository;
    private ItemsListTypeAssembler itemsListTypeAssembler;
    private SoapRepository soapRepository;

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

        List<ItemsListType> fetchedItemList = soapRepository.fetchItemList(search, 0, 1);
        List<Long> oldItemIds = search.getItemList().stream().map(Item::getItemId).collect(Collectors.toList());
        List<Long> fetchedItemIdList = fetchedItemList.stream().map(ItemsListType::getItemId).collect(Collectors.toList());

        if(CollectionUtils.isEmpty(fetchedItemList) || oldItemIds.containsAll(fetchedItemIdList)) {
            removeNonExistingItems(search, fetchedItemIdList);
            updateSearch(search);
            return;
        }

        fetchedItemList = soapRepository.fetchItemList(search, 0, 50);
        fetchedItemIdList = fetchedItemList.stream().map(ItemsListType::getItemId).collect(Collectors.toList());

        List<ItemsListType> ItemsListTypeList = fetchedItemList
                .stream().filter(item -> !oldItemIds.contains(item.getItemId()))
                .collect(Collectors.toList());

        if(ItemsListTypeList.size()>0) {
            List<Item> newItemList = itemsListTypeAssembler.toDtoList(ItemsListTypeList).stream()
                    .map(item -> {item.setSearchId(search.getId()); return item;})
                    .collect(Collectors.toList());

            search.getItemList().addAll(newItemList);
        }

        removeNonExistingItems(search, fetchedItemIdList);
        updateSearch(search);
    }

    private void removeNonExistingItems(Search search, List<Long> fetchedItemIds) {
        search.getItemList()
                .removeIf(item -> !item.getIsActive() && !fetchedItemIds.contains(item.getItemId()));
    }

    private void updateSearch(Search search) {
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
