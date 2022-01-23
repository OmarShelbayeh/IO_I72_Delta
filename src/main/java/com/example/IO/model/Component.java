package com.example.IO.model;

import com.example.IO.service.CompareJSON;
import com.example.IO.service.TransformJSONWithoutSpecificProperties;

import java.util.ArrayList;

/**
 * Interface to component
 * @version 1.0
 */
public interface Component {

    /**
     *
     * @param json JSON representation in String
     * @return some string
     */
    String operation(String json);

    /**
     *
     * @param compareClass JSON representation in String
     * @return Integer ArrayList
     */
    ArrayList<Integer> operation(CompareJSON.CompareClass compareClass);

    /**
     *
     * @param compareClass JSON representation in String
     * @return some string
     */
    String operation(TransformJSONWithoutSpecificProperties.CompareClass compareClass);


}
