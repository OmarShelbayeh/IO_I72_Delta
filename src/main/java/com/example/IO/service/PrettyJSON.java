package com.example.IO.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class PrettyJSON {

    public PrettyJSON() {
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
}
