package com.example.IO.service;


import com.example.IO.model.Component;
import com.example.IO.model.Decorator;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.ArrayList;

@Service
public class CompareJSON extends Decorator {


    @Lazy
    public CompareJSON(Component component) {
        super(component);
    }

    public ArrayList<Integer> compareJSON(String firstJSON, String secondJSON) {
        String[] firstJSONArray = firstJSON.split("\n");
        String[] secondJSONArray = secondJSON.split("\n");
        int length = firstJSON.length() > secondJSONArray.length ? secondJSONArray.length : firstJSONArray.length;
        ArrayList<Integer> returnArrayList = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            if (!firstJSONArray[i].equals(secondJSONArray[i])) returnArrayList.add(i + 1);
        }
        int temp = firstJSON.length() < secondJSONArray.length ? secondJSONArray.length : firstJSONArray.length - length;
        for (int i = length; i < temp + length; i++) {
            returnArrayList.add(length + 1);
        }
        return returnArrayList;
    }


    @Override
    public String operation(String json) {
        return null;
    }

    @Override
    public ArrayList<Integer> operation(String firstJSON, String secondJSON) {
        return compareJSON(firstJSON, secondJSON);
    }

    @Override
    public String operation(String json, ArrayList<String> specificProperties) {
        return null;
    }
}
