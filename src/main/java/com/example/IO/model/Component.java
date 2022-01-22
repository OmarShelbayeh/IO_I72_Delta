package com.example.IO.model;

import com.example.IO.service.CompareJSON;

import java.util.ArrayList;

public interface Component {

    /**
     *
     * @param json
     * @return
     */
    String operation(String json);

    ArrayList<Integer> operation(CompareJSON.CompareClass compareClass);

    String operation(String json, ArrayList<String> specificProperties);

    String operation(String json, String[] specificProperties);

}
