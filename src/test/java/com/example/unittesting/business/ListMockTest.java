package com.example.unittesting.business;

import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

public class ListMockTest {

    @Mock
    List<String> mock = mock(List.class);

    @Test
    public void test(){

        when(mock.size()).thenReturn(5)
        .thenReturn(10);
        assertEquals(5,mock.size());
        assertEquals(10,mock.size());
    }

    @Test
    public void returnWithGenericParameters(){

        when(mock.get(0)).thenReturn("in28Min");

//        assertEquals(5,mock.size());
//        assertEquals(10,mock.size());
    }

    @Test
    public void returnWithGenericParametersAnyInt(){

        when(mock.get(anyInt())).thenReturn("in28Min");

        assertEquals("in28Min",mock.get(0));
        //assertEqu(null,mock.get(1));
    }

    @Test
    public void verificationBasic(){
        String value = mock.get(0);
        String value2 = mock.get(1);

        //verify(mock).get(1);
        verify(mock).get(0);
        verify(mock,times(2)).get(anyInt());
        verify(mock,atLeast(1)).get(anyInt());
        verify(mock,atLeastOnce()).get(anyInt());
        verify(mock, atMost(2)).get(anyInt());
        verify(mock,never()).get(2);



    }

    @Test
    public void argumentCapturing(){
        mock.add("SomeString");

        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(mock).add( captor.capture());

        assertEquals("SomeString",captor.getValue());

    }

    @Test
    public void argumentCapturingMultipleArguments(){
        mock.add("SomeString");
        mock.add("SomeString2");

        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(mock, times(2)).add( captor.capture());

        List<String> values = captor .getAllValues();
        assertEquals("SomeString",values.get(0));
        assertEquals("SomeString2",values.get(1));


    }

    @Test
    public void spying(){
        ArrayList mockList = spy(ArrayList.class);
        //mockList.get(0);
        System.out.println(mockList.size());
        mockList.add(1);
        mockList.add(2);
        System.out.println(mockList.size());
        when(mockList.size()).thenReturn(5);
        System.out.println(mockList.size());


        mockList.add(2);
        mockList.add(3);
        System.out.println(mockList.size());

        verify(mockList).add(3);

//        verify(mockList).add(4);







    }

}
