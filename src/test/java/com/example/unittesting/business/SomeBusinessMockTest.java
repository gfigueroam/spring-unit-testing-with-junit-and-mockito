package com.example.unittesting.business;

import com.example.unittesting.services.SomeDataService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class SomeBusinessMockTest {

    @InjectMocks
    SomeBusinessImpl business = new SomeBusinessImpl();

    @Mock
    SomeDataService mock;

    @Test
    public void calculateSum_basic(){

        Mockito.when(mock.retrieveAllData()).thenReturn(new int[] {1,2,3});
        Assert.assertEquals(6, business.calculateSumUsingService());
    }

    @Test
    public void calculateEmpty_basic(){
        Mockito.when(mock.retrieveAllData()).thenReturn(new int[] {});
        Assert.assertEquals(0, business.calculateSumUsingService());
    }

    @Test
    public void calculateOneValue_basic(){
        Mockito.when(mock.retrieveAllData()).thenReturn(new int[] {5});
        Assert.assertEquals(5, business.calculateSumUsingService());
    }
}
