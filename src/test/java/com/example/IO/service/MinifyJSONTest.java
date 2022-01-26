package com.example.IO.service;

import com.example.IO.model.Component;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinifyJSONTest {
    //test
    Component component;
    MinifyJSON minifyJSON;

    @BeforeEach
    void setUp() {
        minifyJSON = new MinifyJSON(component);
    }
    @Test
    void minifyJSON() {
        assertEquals(
                "{\"fruit\":\"Apple\",\"size\":\"Large\",\"color\":\"Red\"}",
                minifyJSON.minifyJSON(
                        "{\n" +
                                "    \"fruit\": \"Apple\",\n" +
                                "    \"size\": \"Large\",\n" +
                                "    \"color\": \"Red\"\n" +
                                "}"));
    }

    @Test
    void minifyJSON2() {
        assertEquals(
                "{\"fruit\":\"Apple\",\"size\":\"Large\",\"color\":\"Red\"}",
                minifyJSON.minifyJSON("{\"fruit\":\"Apple\",\"size\":\"Large\",\"color\":\"Red\"}"));
    }
}