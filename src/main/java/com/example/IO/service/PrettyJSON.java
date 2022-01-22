package com.example.IO.service;

import com.example.IO.model.Component;
import com.example.IO.model.Decorator;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


@Service
public class PrettyJSON extends Decorator {

    @Lazy
    public PrettyJSON(Component component) {
        super(component);
    }

    public String prettyJSON(String json){
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            JsonNode jsonNode = objectMapper.readValue(json, JsonNode.class);
            return jsonNode.toPrettyString();
        }
        catch (Exception e){
            return "0";
        }
    }

    @Override
    public String operation(String json) {
        return prettyJSON(json);
    }

    @Override
    public ArrayList<Integer> operation(CompareJSON.CompareClass compareClass) {
        return null;
    }

    @Override
    public String operation(TransformJSONWithoutSpecificProperties.CompareClass compareClass) {
        return null;
    }
}
