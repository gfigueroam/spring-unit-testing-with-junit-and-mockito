package com.example.unittesting.business;

import com.example.unittesting.model.Item;

import java.util.List;

public interface ItemBusinessService {

    public Item retrieveHardcodedItem();

    public List<Item> findAll();
}
