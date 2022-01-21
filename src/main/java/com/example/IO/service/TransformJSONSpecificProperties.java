package com.example.IO.service;

import com.example.IO.model.Component;
import com.example.IO.model.Decorator;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class TransformJSONSpecificProperties extends Decorator {

    @Lazy
    public TransformJSONSpecificProperties(Component component) {
        super(component);
    }

    public String transformJSONSpecificProperties(){
        return "";
    }

    @Override
    public String operation(String json) {
        return null;
    }

    @Override
    public ArrayList<Integer> operation(CompareJSON.CompareClass compareClass) {
        return null;
    }

    @Override
    public String operation(String json, ArrayList<String> specificProperties) {
        return null;
    }
}
