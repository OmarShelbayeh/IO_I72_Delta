package com.example.IO.service;

import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;

@Service
public class CompareJSON {

    public CompareJSON() {
    }

    public ArrayList<Integer> compareJSON(String firstJSON, String secondJSON){
        String[] firstJSONArray = firstJSON.split("\n");
        String[] secondJSONArray = secondJSON.split("\n");
        int length = firstJSON.length() > secondJSONArray.length ? secondJSONArray.length : firstJSONArray.length;
        ArrayList<Integer> returnArrayList = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            if(!firstJSONArray[i].equals(secondJSONArray[i])) returnArrayList.add(i + 1);
        }
        int temp = firstJSON.length() < secondJSONArray.length ? secondJSONArray.length : firstJSONArray.length - length;
        for (int i = length; i < temp + length; i++) {
            returnArrayList.add(length + 1);
        }
        return returnArrayList;
    }
}
