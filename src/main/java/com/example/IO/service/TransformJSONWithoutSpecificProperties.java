package com.example.IO.service;

import com.example.IO.model.Component;
import com.example.IO.model.Decorator;
import lombok.*;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class TransformJSONWithoutSpecificProperties extends Decorator {

    @Lazy
    public TransformJSONWithoutSpecificProperties(Component component) {
        super(component);
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @ToString
    public static class CompareClass {
        private String json;
        private ArrayList<String> specificProperties;
    }

    public String transformJSONWithoutSpecificProperties(CompareClass compareClass) {
        for (String specificProperty : compareClass.getSpecificProperties()) {
            compareClass.setJson(transformJSONWithoutSpecificProperty(compareClass.getJson(), specificProperty));
        }
        return compareClass.getJson();
    }

    public String transformJSONWithoutSpecificProperty(String json, String specificProperties) {
        int i = 0;
        int j;
        int code_size = json.length();
        int to_remove_size = specificProperties.length();
        while (i < code_size) {
            j = 0;
            while (i + j < code_size && j < to_remove_size && json.toCharArray()[i + j] == specificProperties.toCharArray()[j])
                j++;
            if (j == to_remove_size) {
                int k = i;
                int bracket = 0;
                boolean start = false;
                while (k < code_size && (bracket > 0 || !start)) {
                    if (json.toCharArray()[k] == '{' || json.toCharArray()[k] == '[') {
                        bracket++;
                        start = true;
                    }
                    if (json.toCharArray()[k] == '}' || json.toCharArray()[k] == ']') {
                        bracket--;
                        start = true;
                    }
                    if (json.toCharArray()[k] == ',' && bracket == 0)
                        break;

                    k++;
                }
                StringBuilder code2 = new StringBuilder();
                for (int l = 0; l < i - 1; l++)
                    code2.append(json.toCharArray()[l]);
                if (json.toCharArray()[k] == ',')
                    k++;
                for (int l = k; l < code_size; l++)
                    code2.append(json.toCharArray()[l]);
                json = code2.toString();
                code_size = json.length();
            }
            i++;
        }
        int brackets_only = 1;
        for (int l=0; l<json.length(); l++)
            if (json.toCharArray()[l] != '[' && json.toCharArray()[l] != ']' && json.toCharArray()[l] != '{' && json.toCharArray()[l] != '}')
                brackets_only = 0;
        if (brackets_only == 1)
            json = "[{}]";
        return json;
    }

    /**
     * @param json - json as string
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
    public ArrayList<Integer> operation(CompareJSON.CompareClass compareClass) {
        return null;
    }

    /**
     * @param compareClass - class compareClass
     * @return some string
     */
    @Override
    public String operation(CompareClass compareClass) {
        return transformJSONWithoutSpecificProperties(compareClass);
    }
}
