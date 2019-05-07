package com.example.unittesting.business;

import com.example.unittesting.services.SomeDataService;

import java.util.Arrays;
import java.util.OptionalInt;

public class SomeBusinessImpl{



    private SomeDataService someDataService;

    public void setSomeDataService(SomeDataService someDataService) {
        this.someDataService = someDataService;
    }


    public int calculateSum(int[] data){
        return Arrays.stream(data).reduce(Integer::sum).orElse(0);
    }

    public int calculateSumUsingService(){
        return Arrays.stream(someDataService.retrieveAllData()).reduce(Integer::sum).orElse(0);

    }
}
