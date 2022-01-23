package com.example.IO.service;

import com.example.IO.model.Component;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class MockTests {
    Component component;
    TransformJSONSpecificProperties transformJSONSpecificProperties = new TransformJSONSpecificProperties(component);

//    @Test
//    public void testCompareBothEmpty1() {
//        MinifyJSON mockObject = mock(MinifyJSON.class);
//        String json = "{\n" +
//                "    \"fruit\": \"Apple\",\n" +
//                "    \"size\": \"Large\",\n" +
//                "    \"color\": \"Red\"\n" +
//                "}";
//        when(mockObject.operation(json)).thenReturn("xddd");
//        String result = minifyJSON.minifyJSONTest(json, mockObject);
//        verify(mockObject).operation(json);
//        assertEquals(result, "xddd");
//    }


}
