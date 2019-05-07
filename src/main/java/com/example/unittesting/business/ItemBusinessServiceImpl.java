package com.example.unittesting.business;

import com.example.unittesting.model.Item;
import com.example.unittesting.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ItemBusinessServiceImpl implements ItemBusinessService {
    @Autowired
    ItemRepository itemRepository;

    @Override
    public Item retrieveHardcodedItem() {
        return new Item(1,"Ball",10,100);
    }

    @Override
    public List<Item> findAll() {
        List<Item> all = itemRepository.findAll();
        all.forEach(item->item.setValue(item.getPrice() * item.getQuantity()));
        return all;

    }
}
