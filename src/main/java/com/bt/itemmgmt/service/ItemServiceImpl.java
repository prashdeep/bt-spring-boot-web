package com.bt.itemmgmt.service;

import com.bt.itemmgmt.model.Item;
import com.bt.itemmgmt.repository.ItemRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import java.util.List;

@Service("itemService")
public class ItemServiceImpl implements ItemService {

    //LoggerFactory.getLogger(ItemServiceImpl.class);
    private final ItemRepository itemRepository;

    public ItemServiceImpl(ItemRepository itemRepository){
        this.itemRepository = itemRepository;
    }


    @Override
    public Item save(Item item) {
      //  log.info("Came inside the service method with argument - price - {}, desc - {} ", item.getPrice(), item.getDescription());
        Item savedItem = this.itemRepository.save(item);
        return savedItem;

    }

    @Override
    public List<Item> listAll() {
        return this.itemRepository.findAll();
    }

    @Override
    public Item findById(long itemId) {
        return this.itemRepository.findById(itemId).orElseThrow(()-> new IllegalArgumentException("Invalid Item Id"));
    }

    @Override
    public Item update(long itemId, Item item) {
         return this.itemRepository.save(item);
    }

    @Override
    public void deleteItemById(long itemId) {
        this.itemRepository.deleteById(itemId);
    }
}