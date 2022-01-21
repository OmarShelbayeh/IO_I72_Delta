package com.example.IO.controller;

import com.example.IO.model.Component;
import com.example.IO.service.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@CrossOrigin
@RequestMapping(path = "api")
public class ApiController {

    private final TransformJSONWithoutSpecificProperties transformJSONWithoutSpecificProperties;
    private Component component;
    @Autowired
    public ApiController(TransformJSONWithoutSpecificProperties transformJSONWithoutSpecificProperties) {
        this.transformJSONWithoutSpecificProperties = transformJSONWithoutSpecificProperties;
    }

    @GetMapping("/prettyJSON")
    public String prettyJSON(@RequestBody String json){
        return new PrettyJSON(component).operation(json);
    }

    @GetMapping("/minifyJSON")
    public String minifyJSON(@RequestBody String json){
        return new MinifyJSON(component).operation(json);
    }

    @GetMapping("/compareJSONs")
    public ArrayList<Integer> compareJSONs(@RequestBody CompareJSON.CompareClass compareClass){
        return new CompareJSON(component).operation(compareClass);
    }

    @GetMapping("/transformJSONWithoutSpecificProperties")
    public String transformJSONWithoutSpecificProperties(@RequestBody String json, @RequestParam ArrayList<String> specificProperties){
        return transformJSONWithoutSpecificProperties.transformJSONWithoutSpecificProperties(json, specificProperties);
    }

    @GetMapping("/transformJSONSpecificProperties")
    public String transformJSONWSpecificProperties(@RequestParam String json, @RequestParam ArrayList<String> specificProperties){
        return "";
    }


}