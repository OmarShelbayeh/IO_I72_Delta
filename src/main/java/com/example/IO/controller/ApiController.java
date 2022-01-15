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


    private final MinifyJSON minifyJSON;
    private final PrettyJSON prettyJSON;
//    private final CompareJSON compareJSON;
    private final TransformJSONSpecificProperties transformJSONSpecificProperties;
    private final TransformJSONWithoutSpecificProperties transformJSONWithoutSpecificProperties;
    private Component component;
    @Autowired
    public ApiController(MinifyJSON minifyJSON, PrettyJSON prettyJSON, TransformJSONSpecificProperties transformJSONSpecificProperties, TransformJSONWithoutSpecificProperties transformJSONWithoutSpecificProperties) {
        this.minifyJSON = minifyJSON;
        this.prettyJSON = prettyJSON;
//        this.compareJSON = compareJSON;
        this.transformJSONSpecificProperties = transformJSONSpecificProperties;
        this.transformJSONWithoutSpecificProperties = transformJSONWithoutSpecificProperties;
    }

    @PostMapping("/prettyJSON")
    public String prettyJSON(@RequestBody String json){
        return new PrettyJSON(component).operation(json);
    }

    @PostMapping("/minifyJSON")
    public String minifyJSON(@RequestBody String json){
        return new MinifyJSON(component).operation(json);
    }

    @PostMapping("/compareJSONs")
    public ArrayList<Integer> compareJSONs(@RequestParam String firstJSON, @RequestParam String secondJSON){
        return new CompareJSON(component).operation(firstJSON, secondJSON);
    }

    @PostMapping("/transformJSONWithoutSpecificProperties")
    public String transformJSONWithoutSpecificProperties(@RequestBody String json, @RequestParam String specificProperties) throws JsonProcessingException {
        return transformJSONWithoutSpecificProperties.transformJSONWithoutSpecificProperties(json, specificProperties);
    }

    @PostMapping("/transformJSONSpecificProperties")
    public String transformJSONWSpecificProperties(@RequestParam String json, @RequestParam ArrayList<String> specificProperties){
        return "";
    }


}