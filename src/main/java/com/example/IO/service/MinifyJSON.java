package com.example.IO.service;

import com.example.IO.model.Component;
import com.example.IO.model.Decorator;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * Class responsible for make minify JSON
 * @version 1.0
 */
@Service
public class MinifyJSON extends Decorator {

    /**
     * Constructor
     * @param component component instance
     */
    @Lazy
    public MinifyJSON(Component component) {
        super(component);
    }

    /**
     * Make unminify JSON to minify XD
     * @param json JSON representation in String
     * @return minify JSON
     */
    public String minifyJSON(String json) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            JsonNode jsonNode = objectMapper.readValue(json, JsonNode.class);
            return jsonNode.toString();
        }
        catch (Exception e){
            return "0";
        }
    }

    /**
     * @param json JSON representation in String
     * @return some string
     */
    @Override
    public String operation(String json) {
        return minifyJSON(json);
    }

    /**
     * @param compareClass - class compareClass
     * @return Integer ArrayList
     */
    @Override
    public ArrayList<Integer> operation(CompareJSON.CompareClass compareClass) {
        return null;
    }

    /**
     * @param compareClass - class compareClass
     * @return some string
     */
    @Override
    public String operation(TransformJSONWithoutSpecificProperties.CompareClass compareClass) {
        return null;
    }
}
