package com.example.IO.service;

import com.example.IO.model.Component;
import com.example.IO.model.Decorator;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class TransformJSONWithoutSpecificProperties extends Decorator {

    @Lazy
    public TransformJSONWithoutSpecificProperties(Component component) {
        super(component);
    }

    public String transformJSONWithoutSpecificProperties(String json, ArrayList<String> specificProperties){
        for (String specificProperty : specificProperties) {
            json = transformJSONWithoutSpecificProperty(json, specificProperty);
        }
        return json;
    }
    public String transformJSONWithoutSpecificProperty(String json, String specificProperties){
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
                    if (json.toCharArray()[k] == '}' || json.toCharArray()[k] == ']')
                        bracket--;
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
        return json;
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
        return transformJSONWithoutSpecificProperties(json, specificProperties);
    }

    @Override
    public String operation(String json, String[] specificProperties) {
        return null;
    }
}
