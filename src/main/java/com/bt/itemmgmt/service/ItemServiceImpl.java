package com.bt.itemmgmt.service;

import com.bt.itemmgmt.dao.ItemDao;
import com.bt.itemmgmt.model.Item;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.List;

@Service("itemService")
//@Scope("singleton")
public class ItemServiceImpl implements ItemService {


    public ItemServiceImpl(){
    }


    @Override
    public Item save(Item item) {
        return null;
    }

    @Override
    public List<Item> listAll() {
        return null;
    }

    @Override
    public Item findById(long itemId) {
        return null;
    }

    @Override
    public Item update(long itemId, Item item) {
        return null;
    }

    @Override
    public void deleteItemById(long itemId) {
       
    }
}