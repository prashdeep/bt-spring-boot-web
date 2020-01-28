package com.bt.itemmgmt.dao;

import com.bt.itemmgmt.model.Item;

import java.util.List;
import java.util.Optional;

public interface ItemDao {

    Item save(Item item);

    List<Item> listAll();

    Optional<Item> findById(long itemId);

    Item update(long itemId, Item item);

    void deleteItemById(long itemId);
}