package com.example.unittesting.spike;


import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import org.json.JSONException;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class JSONPathTest {

    String str = "{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}";
    @Test
    public void jsonAssertStrictTrue_ExactMatchExceptForSpaces() throws JSONException {
        String responseFromService = "[" +
                "  {\"id\":1000, \"name\":\"pencil\", \"quantity\":5}," +
                "  {\"id\":1001, \"name\":\"sharpener\", \"quantity\":10}," +
                "  {\"id\":1002, \"name\":\"eraser\", \"quantity\":15}" +
                "]";

        DocumentContext context = JsonPath.parse(responseFromService);

        int lenght = context.read("$.length()");

        assertThat(lenght).isEqualTo(3);

        List<Integer> ids = context.read("$..id");

        assertThat(ids).containsExactly(1000,1001,1002);
        System.out.println(ids);
        System.out.println(context.read("$.[1]").toString());
        System.out.println(context.read("$.[0:2]").toString());
        System.out.println(context.read("$.[?(@.name=='eraser')]").toString());
        System.out.println(context.read("$.[?(@.quantity==10)]").toString());



    }


}
