package com.example.unittesting.spike;


import org.json.JSONException;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;

public class JsonAsserTest {

    String str = "{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}";
    @Test
    public void jsonAssertStrictTrue_ExactMatchExceptForSpaces() throws JSONException {
//        String expectedResponse =  "{\"id\":1,\"name\":\"Ball\"}";
//        JSONAssert.assertEquals(expectedResponse, str, true);

        String expectedResponse = "{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}";
        JSONAssert.assertEquals(expectedResponse, str, true);

    }
    @Test
    public void jsonAssertStrictFalse_ExactMatchExceptForSpaces() throws JSONException {
//        String expectedResponse =  "{\"id\":1,\"name\":\"Ball\"}";
//        JSONAssert.assertEquals(expectedResponse, str, true);

        String expectedResponse = "{id:1,name:Ball}";
        JSONAssert.assertEquals(expectedResponse, str, false);

    }


}
