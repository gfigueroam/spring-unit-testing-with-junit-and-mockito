package com.example.unittesting.business;

import com.example.unittesting.model.Item;
import com.example.unittesting.repository.ItemRepository;
import com.example.unittesting.services.SomeDataService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.context.TestPropertySource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
//@TestPropertySource(locations = {"classpath:test-configuration.properties"})
public class ItemBusinessServiceTest {

    @InjectMocks
    private ItemBusinessService business = new ItemBusinessServiceImpl();

    @Mock
    ItemRepository mock;

    @Test
    public void retrieveAllItems_basic(){

        Mockito.when(mock.findAll()).thenReturn(Arrays.asList(new Item(1,"Ball",10,100),
                new Item(2,"Test",10,5)));
        List<Item> all = business.findAll();
        Assert.assertEquals(1000,all.get(0).getValue());
        Assert.assertEquals(50,all.get(1).getValue());
    }


}
