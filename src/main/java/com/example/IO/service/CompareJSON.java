package com.example.IO.service;


import com.example.IO.model.Component;
import com.example.IO.model.Decorator;
import lombok.*;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * Java class that's responsible for comparing 2 JSONS
 *
 * @version 1.0
 */
@Service
public class CompareJSON extends Decorator {

    /**
     * Constructor
     *
     * @param component - component instance
     */

    @Lazy
    public CompareJSON(Component component) {
        super(component);
    }

    /**
     * Helper class that has two variables
     * firstJSON (String) indicating the first JSON to compare
     * secondJSON (String) indication the second JSON to compare
     */
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @ToString
    public static class CompareClass {
        private String firstJSON;
        private String secondJSON;
    }

    /**
     * A Java function that finds all the differences between two JSON objects.
     *
     * @param compareClass - Helper class that includes two variables, firstJSON and secondJSON.
     * @return ArrayList including the numbers of the lines where differences were found.
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
