package com.example.IO.service;

import com.example.IO.model.Component;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CompareJSONTest {

    Component component;
    CompareJSON compareJSON;

    @BeforeEach
    void setUp() {
        compareJSON = new CompareJSON(component);
    }

    @Test
    void compareJSON() {
        CompareJSON.CompareClass compareClass = new CompareJSON.CompareClass("[{\"fruit\":\"Apple\",\"size\":\"Large\",\"color\":\"Red\"}]","[{\"fruit\":\"Apple\",\"size\":\"Large\",\"color\":\"Red\"}]");
        assertEquals(new ArrayList<>(),compareJSON.compareJSON(compareClass));
    }
    @Test
    void compareJSON2() {
        CompareJSON.CompareClass compareClass = new CompareJSON.CompareClass("[{\"fruitt\":\"Apple\",\"size\":\"Large\",\"color\":\"Red\"}]","[{\"fruit\":\"Apple\",\"size\":\"Large\",\"color\":\"Red\"}]");
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        assertEquals(arrayList,compareJSON.compareJSON(compareClass));
    }
    @Test
    void compareJSON3() {
        CompareJSON.CompareClass compareClass = new CompareJSON.CompareClass("{\n" +
                "    \"fruitt\": \"Apple\",\n" +
                "    \"sizee\": \"Large\",\n" +
                "    \"color\": \"Red\"\n" +
                "}",
                "{\n" +
                        "    \"fruit\": \"Apple\",\n" +
                        "    \"size\": \"Large\",\n" +
                        "    \"colory\": \"Red\"\n" +
                        "}");
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        assertEquals(arrayList,compareJSON.compareJSON(compareClass));
    }
}