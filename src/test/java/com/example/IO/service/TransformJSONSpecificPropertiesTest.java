package com.example.IO.service;

import com.example.IO.model.Component;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class TransformJSONSpecificPropertiesTest {
    Component component;
    TransformJSONSpecificProperties transformJSONSpecificProperties;

    @BeforeEach
    void setUp() {
        transformJSONSpecificProperties = new TransformJSONSpecificProperties(component);
    }
    @Test
    void transformJSONSpecificProperties() {
        ArrayList<String> specificProperties = new ArrayList<>();
        specificProperties.add("color");
        specificProperties.add("size");
        TransformJSONWithoutSpecificProperties.CompareClass compareClass =
                new TransformJSONWithoutSpecificProperties.CompareClass(
                "{\"fruit\":\"Apple\",\"size\":\"Large\",\"color\":\"Red\"}",
                specificProperties);
        assertEquals(
                "{\"size\":\"Large\",\"color\":\"Red\"}",
                transformJSONSpecificProperties.transformJSONSpecificProperties(compareClass));

    }

    @Test
    void transformJSONSpecificProperties1() {
        TransformJSONWithoutSpecificProperties.CompareClass compareClass =
                new TransformJSONWithoutSpecificProperties.CompareClass(
                        "[{\"fruit\":\"Apple\",\"size\":\"Large\",\"color\":\"Red\"}]",
                        new ArrayList<>());
        assertEquals(
                "[{}]",
                transformJSONSpecificProperties.transformJSONSpecificProperties(compareClass));
    }

    @Test
    void transformJSONSpecificProperties2() {
        ArrayList<String> specificProperties = new ArrayList<>();
        specificProperties.add("options");
        TransformJSONWithoutSpecificProperties.CompareClass compareClass =
                new TransformJSONWithoutSpecificProperties.CompareClass(
                        "{\"quiz\":{\"sport\":{\"q1\":{\"question\":\"Which one is correct team name in NBA?\",\"options\":[\"New York Bulls\",\"Los Angeles Kings\",\"Golden State Warriros\",\"Huston Rocket\"],\"answer\":\"Huston Rocket\"}},\"maths\":{\"q1\":{\"question\":\"5 + 7 = ?\",\"options\":[\"10\",\"11\",\"12\",\"13\"],\"answer\":\"12\"},\"q2\":{\"question\":\"12 - 8 = ?\",\"options\":[\"1\",\"2\",\"3\",\"4\"],\"answer\":\"4\"}}}}",
                        specificProperties);
        assertEquals(
                "{\"quiz\":{\"sport\":{\"q1\":{\"options\":[\"New York Bulls\",\"Los Angeles Kings\",\"Golden State Warriros\",\"Huston Rocket\"] }},\"maths\":{\"q1\":{\"options\":[\"10\",\"11\",\"12\",\"13\"] },\"q2\":{\"options\":[\"1\",\"2\",\"3\",\"4\"] }}}}",
                transformJSONSpecificProperties.transformJSONSpecificProperties(compareClass));

    }

    @Test
    void usuwanie() {
        assertEquals(
                "{\"size\":\"Large\",\"color\":\"Red\"}",
                TransformJSONSpecificProperties.usuwanie("{\"fruit\":\"Apple\",\"size\":\"Large\",\"color\":\"Red\"}","fruit"));

    }

    @Test
    void structure() {
        assertEquals(
                "{\"fruit\"size\"color}",
                TransformJSONSpecificProperties.structure("{\"fruit\":\"Apple\",\"size\":\"Large\",\"color\":\"Red\"}"));

    }

    @Test
    void findFeatures() {
        assertEquals(
                "fruit size color",
                TransformJSONSpecificProperties.FindFeatures("{\"fruit\":\"Apple\",\"size\":\"Large\",\"color\":\"Red\"}"));

    }

    @Test
    void findPath() {
        assertEquals(
                " maths quiz   question options answer",
                TransformJSONSpecificProperties.FindPath(TransformJSONSpecificProperties.structure("{\"quiz\":{\"sport\":{\"q1\":{\"question\":\"Which one is correct team name in NBA?\",\"options\":[\"New York Bulls\",\"Los Angeles Kings\",\"Golden State Warriros\",\"Huston Rocket\"],\"answer\":\"Huston Rocket\"}},\"maths\":{\"q1\":{\"question\":\"5 + 7 = ?\",\"options\":[\"10\",\"11\",\"12\",\"13\"],\"answer\":\"12\"},\"q2\":{\"question\":\"12 - 8 = ?\",\"options\":[\"1\",\"2\",\"3\",\"4\"],\"answer\":\"4\"}}}}"),"q2"));

    }

    @Test
    void remove_duplicates() {
        assertEquals(
                "fruit q1 color Red size ",
                TransformJSONSpecificProperties.Remove_duplicates("fruit color q1 q1 size color Red size"));

    }

    @Test
    void zachowajPodane() {
        assertEquals(
                " size color ",
                TransformJSONSpecificProperties.zachowajPodane("{\"fruit\":\"Apple\",\"size\":\"Large\",\"color\":\"Red\"}", new String[]{"fruit"}));
    }

    @Test
    void usun_wszystko_poza_podanymi() {
        ArrayList<String> specificProperties = new ArrayList<>();
        specificProperties.add("fruit");
        specificProperties.add("size");
        TransformJSONWithoutSpecificProperties.CompareClass  compareClass =
                new TransformJSONWithoutSpecificProperties.CompareClass(
                        "[{\"fruit\":\"Apple\",\"size\":\"Large\",\"color\":\"Red\" }]",
                        specificProperties);
        assertEquals("[{\"fruit\":\"Apple\",\"size\":\"Large\"}]", transformJSONSpecificProperties.operation(compareClass));

    }
}