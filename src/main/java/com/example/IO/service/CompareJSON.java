package com.example.IO.service;


import com.example.IO.model.Component;
import com.example.IO.model.Decorator;
import lombok.*;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * class responsible for compare 2 JSONs
 * @version 1.0
 */
@Service
public class CompareJSON extends Decorator {

    /**
     * Constructor
     * @param component - component instance
     */

    @Lazy
    public CompareJSON(Component component) {
        super(component);
    }

    /**
     *  Help class including two strings firstJSON and secondJSON
     */
    @Getter @Setter @AllArgsConstructor @NoArgsConstructor @ToString
    public static class CompareClass{
        private String firstJSON;
        private String secondJSON;
    }

    /**
     *
     * @param compareClass - Help class including two strings firstJSON and secondJSON
     * @return ArrayList with numbers of difference line
     */
    public ArrayList<Integer> compareJSON(CompareClass compareClass) {
        String[] firstJSONArray = compareClass.firstJSON.split("\n");
        String[] secondJSONArray = compareClass.secondJSON.split("\n");
        int length = Math.min(firstJSONArray.length, secondJSONArray.length);
        ArrayList<Integer> returnArrayList = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            if (!firstJSONArray[i].equals(secondJSONArray[i])) returnArrayList.add(i + 1);
        }
        int temp = Math.max(firstJSONArray.length, secondJSONArray.length);
        for (int i = length; i < temp; i++) {
            returnArrayList.add(i + 1);
        }
        return returnArrayList;
    }


    /**
     * @param json JSON representation in String
     * @return some string
     */
    @Override
    public String operation(String json) {
        return null;
    }

    /**
     * @param compareClass - class compareClass
     * @return Integer ArrayList
     */
    @Override
    public ArrayList<Integer> operation(CompareClass compareClass) {
        return compareJSON(compareClass);
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
