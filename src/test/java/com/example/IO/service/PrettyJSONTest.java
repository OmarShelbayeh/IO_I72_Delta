package com.example.IO.service;

import com.example.IO.model.Component;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PrettyJSONTest {
    Component component;
    PrettyJSON prettyJSON;

    @BeforeEach
    void setUp() {
        prettyJSON = new PrettyJSON(component);
    }

    @Test
    void prettyJSON() {
        assertEquals(
                "{ }",
                prettyJSON.prettyJSON("{}"));
    }

//    @Test
//    void prettyJSON2() {assertEquals(
//            "{\n" +
//                    "  \"fruit\" : \"Apple\",\n" +
//                    "  \"size\" : \"Large\",\n" +
//                    "  \"color\" : \"Red\"\n" +
//                    "}",
//            prettyJSON.prettyJSON("{\n" +
//                    "    \"fruit\": \"Apple\",\n" +
//                    "    \"size\": \"Large\",\n" +
//                    "    \"color\": \"Red\"\n" +
//                    "}"));
//    }
}