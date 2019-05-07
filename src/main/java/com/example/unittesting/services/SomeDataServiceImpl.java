package com.example.unittesting.services;

public class SomeDataServiceImpl implements SomeDataService {
    @Override
    public int[] retrieveAllData() {
        return new int[]{1,2,3};
    }
}
