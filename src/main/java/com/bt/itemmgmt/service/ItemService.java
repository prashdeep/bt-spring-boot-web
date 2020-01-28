package com.bt.itemmgmt.service;

import com.bt.itemmgmt.model.Item;

import java.util.List;

public interface ItemService {

    Item save(Item item);

    List<Item> listAll();

    Item findById(long itemId);

    Item update(long itemId, Item item);

    void deleteItemById(long itemId);
}