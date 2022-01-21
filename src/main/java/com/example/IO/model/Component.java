package com.example.IO.model;

import com.example.IO.service.CompareJSON;

import java.util.ArrayList;

public interface Component {

    String operation(String json);

    ArrayList<Integer> operation(CompareJSON.CompareClass compareClass);

    String operation(String json, ArrayList<String> specificProperties);

}
