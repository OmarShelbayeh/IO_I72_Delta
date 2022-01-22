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
    void transformJSONWithoutSpecificProperty() {
    }

}