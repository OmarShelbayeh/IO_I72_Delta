package com.example.IO.model;

import com.example.IO.service.CompareJSON;
import com.example.IO.service.TransformJSONWithoutSpecificProperties;

import java.util.ArrayList;

public interface Component {

    /**
     *
     * @param json - json as string
     * @return some string
     */
    String operation(String json);

    /**
     *
     * @param compareClass - class compareClass
     * @return Integer ArrayList
     */
    ArrayList<Integer> operation(CompareJSON.CompareClass compareClass);

    /**
     *
     * @param compareClass - class compareClass
     * @return some string
     */
    String operation(TransformJSONWithoutSpecificProperties.CompareClass compareClass);


}
