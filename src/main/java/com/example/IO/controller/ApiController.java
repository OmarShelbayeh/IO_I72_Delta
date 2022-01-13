package com.example.IO.controller;

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
    private final CompareJSON compareJSON;
    private final TransformJSONSpecificProperties transformJSONSpecificProperties;
    private final TransformJSONWithoutSpecificProperties transformJSONWithoutSpecificProperties;

    @Autowired
    public ApiController(MinifyJSON minifyJSON, PrettyJSON prettyJSON, CompareJSON compareJSON, TransformJSONSpecificProperties transformJSONSpecificProperties, TransformJSONWithoutSpecificProperties transformJSONWithoutSpecificProperties) {
        this.minifyJSON = minifyJSON;
        this.prettyJSON = prettyJSON;
        this.compareJSON = compareJSON;
        this.transformJSONSpecificProperties = transformJSONSpecificProperties;
        this.transformJSONWithoutSpecificProperties = transformJSONWithoutSpecificProperties;
    }

    @GetMapping("/prettyJSON")
    public String prettyJSON(@RequestBody String json){
        return prettyJSON.prettyJSON(json);
    }

    @GetMapping("/minifyJSON")
    public String minifyJSON(@RequestBody String json){
        return minifyJSON.minifyJSON(json);
    }

    @GetMapping("/compareJSONs")
    public ArrayList<Integer> compareJSONs(@RequestParam String firstJSON, @RequestParam String secondJSON){
        return compareJSON.compareJSON(firstJSON, secondJSON);
    }

    @GetMapping("/transformJSONWithoutSpecificProperties")
    public String transformJSON(@RequestBody String json, @RequestParam String specificProperties) throws JsonProcessingException {
        return transformJSONWithoutSpecificProperties.transformJSONWithoutSpecificProperties(json, specificProperties);
    }

    @GetMapping("/transformJSONWithoutSpecificProperties")
    public String transformJSONWithoutSpecificProperties(@RequestParam String json, @RequestParam ArrayList<String> specificProperties){
        return "";
    }


}
