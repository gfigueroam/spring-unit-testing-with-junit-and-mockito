package com.example.unittesting.controller;

import com.example.unittesting.business.ItemBusinessService;
import com.example.unittesting.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ItemController {

    @Autowired
    private ItemBusinessService businessService;

    public void setBusinessService(ItemBusinessService businessService) {
        this.businessService = businessService;
    }

    @GetMapping("/dummy-item")
    public Item helloWorld(){
        return new Item(1, "Ball",10, 100);
    }

    @GetMapping("/item-from-business-service")
    public Item itemFromBusinessService(){
        return businessService.retrieveHardcodedItem();
    }

    @GetMapping("/all-items")
    public List<Item> allItemsFromBusinessSevice(){
        return businessService.findAll();
    }
}
