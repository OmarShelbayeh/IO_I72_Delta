package com.example.IO.model;

import java.util.ArrayList;

public interface Component {

    String operation(String json);

    ArrayList<Integer> operation(String firstJSON, String secondJSON);

    String operation(String json, ArrayList<String> specificProperties);

}
