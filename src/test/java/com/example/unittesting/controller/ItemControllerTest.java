package com.example.unittesting.controller;


import com.example.unittesting.business.ItemBusinessService;
import com.example.unittesting.model.Item;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//spring unit test
@RunWith(SpringRunner.class)
@WebMvcTest(ItemController.class)
public class ItemControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ItemBusinessService itemBusinessService;

    @Test
    public void itemcontroller_basic()throws Exception{
        //call /hello-world
        RequestBuilder request = MockMvcRequestBuilders
                .get("/dummy-item")
                .accept(MediaType.APPLICATION_JSON);
        MvcResult mvcResult = mockMvc.perform(request)
                .andExpect(status().isOk())
//                .andExpect(content().json("{\"id\" :1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}"))
                .andExpect(content().json("{id :1,name:Ball,price:10}"))
                .andReturn();

        //assertEquals("Hello World", mvcResult.getResponse().getContentAsString());

        //verify "hello world"

    }

    @Test
    public void itemFromBusinessService()throws Exception{

       when(itemBusinessService.retrieveHardcodedItem()).thenReturn(new Item(1,"Ball",10,100));

       RequestBuilder request = MockMvcRequestBuilders
               .get("/item-from-business-service")
               .accept(MediaType.APPLICATION_JSON);

       MvcResult mvcResult = mockMvc.perform(request)
               .andExpect(status().isOk())
               .andExpect(content().json("{id :1,name:Ball,price:10}"))
               .andReturn();

    }


    @Test
    public void retrieveAllItems() throws Exception{

        when(itemBusinessService.findAll()).thenReturn(Arrays.asList(new Item(1,"Ball",10,100),
                new Item(2,"Test",10,100)));

        RequestBuilder request = MockMvcRequestBuilders
                .get("/all-items")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult mvcResult = mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json("[{id :2,name:Test},{id :1,name:Ball,price:10}]"))
                .andReturn();

    }

    /*@Test
    public void postExample_failing() throws Exception{

        when(itemBusinessService.findAll()).thenReturn(Arrays.asList(new Item(1,"Ball",10,100),
                new Item(2,"Test",10,100)));

        RequestBuilder request = MockMvcRequestBuilders
                .post("/all-items")
                .accept(MediaType.APPLICATION_JSON)
                .content("{id :2,name:Test},{id :1,name:Ball,price:10}")
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult mvcResult = mockMvc.perform(request)
                .andExpect(status().isCreated())
                .andExpect(header().string("location",containsString("/item/")))
                .andReturn();

    }*/


}
