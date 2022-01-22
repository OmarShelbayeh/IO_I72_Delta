package com.example.IO.service;

import com.example.IO.model.Component;
import com.example.IO.model.Decorator;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MinifyJSON extends Decorator {

    @Lazy
    public MinifyJSON(Component component) {
        super(component);
    }

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

    @Override
    public String operation(String jsonString) {
        return minifyJSON(jsonString);
    }

    @Override
    public ArrayList<Integer> operation(CompareJSON.CompareClass compareClass) {
        return null;
    }

    @Override
    public String operation(String json, ArrayList<String> specificProperties) {
        return null;
    }

    @Override
    public String operation(String json, String[] specificProperties) {
        return null;
    }
}
