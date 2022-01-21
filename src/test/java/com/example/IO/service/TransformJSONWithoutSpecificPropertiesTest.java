package com.example.IO.service;

import com.example.IO.model.Component;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class TransformJSONWithoutSpecificPropertiesTest {
    Component component;
    TransformJSONWithoutSpecificProperties transformJSONWithoutSpecificProperties;
    String json;
    ArrayList<String> specificProperties = new ArrayList<>();

    @BeforeEach
    void setUp() {
        transformJSONWithoutSpecificProperties = new TransformJSONWithoutSpecificProperties(component);
        json = "[{\"fruit\":\"Apple\",\"size\":\"Large\",\"color\":\"Red\"}]";
    }

    @Test
    void transformJSONWithoutSpecificProperties1() {
        specificProperties.add("fruit");
        assertEquals("[{\"size\":\"Large\",\"color\":\"Red\"}]", transformJSONWithoutSpecificProperties.transformJSONWithoutSpecificProperties(json, specificProperties));
    }

    @Test
    void transformJSONWithoutSpecificProperty() {
    }

}