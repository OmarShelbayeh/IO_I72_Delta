package com.example.IO.service;

import com.example.IO.model.Component;
import org.checkerframework.checker.units.qual.C;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class TransformJSONWithoutSpecificPropertiesTest {
    Component component;
    TransformJSONWithoutSpecificProperties transformJSONWithoutSpecificProperties;

    @BeforeEach
    void setUp() {
        transformJSONWithoutSpecificProperties = new TransformJSONWithoutSpecificProperties(component);
    }

    @Test
    void transformJSONWithoutSpecificProperties1() {
        ArrayList<String> specificProperties = new ArrayList<>();
        specificProperties.add("fruit");
        TransformJSONWithoutSpecificProperties.CompareClass  compareClass =
                new TransformJSONWithoutSpecificProperties.CompareClass(
                        "[{\"fruit\":\"Apple\",\"size\":\"Large\",\"color\":\"Red\"}]",
                        specificProperties);
        assertEquals("[{\"size\":\"Large\",\"color\":\"Red\"}]", transformJSONWithoutSpecificProperties.transformJSONWithoutSpecificProperties(compareClass));
    }

    @Test
    void transformJSONWithoutSpecificProperties2() {
        ArrayList<String> specificProperties = new ArrayList<>();
        specificProperties.add("fruit");
        specificProperties.add("size");
        TransformJSONWithoutSpecificProperties.CompareClass  compareClass =
                new TransformJSONWithoutSpecificProperties.CompareClass(
                        "[{\"fruit\":\"Apple\",\"size\":\"Large\",\"color\":\"Red\"}]",
                        specificProperties);
        assertEquals("[{\"color\":\"Red\"}]", transformJSONWithoutSpecificProperties.transformJSONWithoutSpecificProperties(compareClass));
    }

    @Test
    void transformJSONWithoutSpecificProperties3() {
        ArrayList<String> specificProperties = new ArrayList<>();
        specificProperties.add("fruit");
        specificProperties.add("size");
        specificProperties.add("color");
        TransformJSONWithoutSpecificProperties.CompareClass  compareClass =
                new TransformJSONWithoutSpecificProperties.CompareClass(
                        "[{\"fruit\":\"Apple\",\"size\":\"Large\",\"color\":\"Red\"}]",
                        specificProperties);
        assertEquals("[{}]", transformJSONWithoutSpecificProperties.transformJSONWithoutSpecificProperties(compareClass));
    }

    @Test
    void transformJSONWithoutSpecificProperties4() {
        ArrayList<String> specificProperties = new ArrayList<>();
        specificProperties.add("type");
        TransformJSONWithoutSpecificProperties.CompareClass  compareClass =
                new TransformJSONWithoutSpecificProperties.CompareClass(
                        "{\"id\":\"0001\",\"type\":\"donut\",\"name\":\"Cake\",\"ppu\":0.55,\"batters\":{\"batter\":[{\"id\":\"1001\",\"type\":\"Regular\"},{\"id\":\"1002\",\"type\":\"Chocolate\"},{\"id\":\"1003\",\"type\":\"Blueberry\"},{\"id\":\"1004\",\"type\":\"Devil's Food\"}]},\"topping\":[{\"id\":\"5001\",\"type\":\"None\"},{\"id\":\"5002\",\"type\":\"Glazed\"},{\"id\":\"5005\",\"type\":\"Sugar\"},{\"id\":\"5007\",\"type\":\"Powdered Sugar\"},{\"id\":\"5006\",\"type\":\"Chocolate with Sprinkles\"},{\"id\":\"5003\",\"type\":\"Chocolate\"},{\"id\":\"5004\",\"type\":\"Maple\"}]}",
                        specificProperties);
        assertEquals("{\"id\":\"0001\",\"name\":\"Cake\",\"ppu\":0.55,\"batters\":{\"batter\":[{\"id\":\"1001\",{\"id\":\"1002\",{\"id\":\"1003\",{\"id\":\"1004\",]},\"topping\":[{\"id\":\"5001\",{\"id\":\"5002\",{\"id\":\"5005\",{\"id\":\"5007\",{\"id\":\"5006\",{\"id\":\"5003\",{\"id\":\"5004\",]}", transformJSONWithoutSpecificProperties.transformJSONWithoutSpecificProperties(compareClass));
    }

    @Test
    void transformJSONWithoutSpecificProperties5() {
        ArrayList<String> specificProperties = new ArrayList<>();
        specificProperties.add("fruit");
        specificProperties.add("size");
        specificProperties.add("color");
        TransformJSONWithoutSpecificProperties.CompareClass  compareClass =
                new TransformJSONWithoutSpecificProperties.CompareClass(
                        "[{}]",
                        specificProperties);
        assertEquals("[{}]", transformJSONWithoutSpecificProperties.transformJSONWithoutSpecificProperties(compareClass));
    }
}