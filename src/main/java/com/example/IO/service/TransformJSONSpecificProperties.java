package com.example.IO.service;

import com.example.IO.model.Component;
import com.example.IO.model.Decorator;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * Class responsible for transform JSON including specific properties
 * @version 1.0
 */
@Service
public class TransformJSONSpecificProperties extends Decorator {
    /**
     * Constructor
     * @param component component instance
     */
    @Lazy
    public TransformJSONSpecificProperties(Component component) {
        super(component);
    }

    /**
     *
     * @param compareClass Help class including representation JSON as String and ArrayList with specific properties
     * @return json with removed given features
     */
    public String transformJSONSpecificProperties(TransformJSONWithoutSpecificProperties.CompareClass compareClass){
        String[] strings = compareClass.getSpecificProperties().toArray(new String[0]);
        return keepGivenProperties(new MinifyJSON(component).minifyJSON(compareClass.getJson()), strings);
    }

    /**
     * Function removes given feature from json code
     * @param json JSON representation in String
     * @param specificProperties feature that need to be removed
     * @return json with removed given feature
     */
    public String remove(String json, String specificProperties){
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
                    {
                        bracket--;
                        start = true;
                    }
                    if (json.toCharArray()[k] == ',' && bracket == 0)
                        break;
                    if (bracket < 0){
                        k--;
                        if (json.toCharArray()[i-2] == ',')
                        {
                            json = json.substring(0,i-2)+' '+json.substring(i-1);
                        }
                    }
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
            if (json.toCharArray()[l] != '[' && json.toCharArray()[l] != ']' && json.toCharArray()[l] != '{' && json.toCharArray()[l] != '}') {
                brackets_only = 0;
                break;
            }
        if (brackets_only == 1)
            json = "[{}]";
        return json;
    }

    /**
     * Returns structure of json in string
     * @param json JSON representation in String
     * @return string with structure of features in json code
     */
    public String structure(String json)
    {
        String Structure = "";
        String Feature = "";
        int quotes = 0;
        for (int i=0; i<json.length(); i++)
        {
            if (json.toCharArray()[i] == '\"')
            {
                if (quotes == 1)
                {
                    if (i+1 < json.length() && json.toCharArray()[i+1] == ':')
                        Structure = Structure + Feature;
                }
                quotes = (quotes+1)%2;
            }
            if (json.toCharArray()[i] == '{' || json.toCharArray()[i] == '}')
                Structure = Structure + json.toCharArray()[i];
            if (quotes == 1)
                Feature = Feature + json.toCharArray()[i];
            else
                Feature = "";
        }
        return Structure;
    }

    /**
     * Returns in string all features in json, separated by space
     * @param json JSON representation in String
     * @return features in string separated by space
     */
    public String findFeatures(String json)
    {
        String[] features = json.split("\":");
        String AllFeatures = "";
        String s, reversed;
        int j;
        int size = features.length;
        for (int i=0; i<size; i++)
        {
            s = "";
            j = features[i].length() - 1;
            while (true)
            {
                if (j == 0 || features[i].toCharArray()[j] == '\"')
                    break;
                s = s + features[i].toCharArray()[j];
                j--;
            }
            reversed = "";
            for(int k = s.length()-1; k >= 0; k--)
                reversed = reversed + s.toCharArray()[k];
            if (reversed.toCharArray()[0] != '{' && reversed.toCharArray()[0] != '}')
            {
                if (AllFeatures == "")
                    AllFeatures = reversed;
                else
                    AllFeatures = AllFeatures + " " + reversed;
            }
        }
        return AllFeatures;
    }

    /**
     * Returns features that contains given feature in structure of json code
     * @param structure json code structure
     * @param feature feature
     * @return features in string, separated by space, that contains given feature
     */
    public String findPath(String structure, String feature)
    {
        int j = 0;
        int poziom = 0;
        int poziom2 = 0;
        int pomijany_poziom = 0;
        String Features_in_Path = "";
        int kopiuj;
        for (int i=0; i<structure.length(); i++)
        {
            if (structure.toCharArray()[j] == '{')
                poziom++;
            if (structure.toCharArray()[j] == '}')
                poziom--;

            j = 0;
            while (i+j < structure.length() && j < feature.length() && structure.toCharArray()[j+i] == feature.toCharArray()[j])
                j++;
            if (j == feature.length())
            {
                String Feature = "";
                pomijany_poziom = 0;
                poziom2 = poziom;
                kopiuj = 0;
                for (int k=i; k>=0; k--)
                {
                    if (structure.toCharArray()[k] == '{')
                    {
                        if (pomijany_poziom == 0)
                        {
                            kopiuj = 1;
                            poziom2--;
                        }
                        else
                            pomijany_poziom--;
                    }
                    if (structure.toCharArray()[k] == '}')
                    {
                        pomijany_poziom++;
                    }
                    if (structure.toCharArray()[k] == '\"')
                    {
                        if (kopiuj == 1)
                        {
                            if (Feature.toCharArray()[0] == '{')
                                Feature = Feature.substring(1);
                            Feature = new StringBuilder(Feature).reverse().toString();
                            Features_in_Path = Features_in_Path + " " + Feature;
                            Feature = "";
                        }
                        kopiuj = 0;
                    }
                    if (kopiuj == 1)
                        Feature = Feature + structure.toCharArray()[k];
                }
                poziom2 = 0;
                Feature = "";
                for (int k=i+j; k < structure.length(); k++)
                {
                    if (structure.toCharArray()[k] == '{' || structure.toCharArray()[k] == '[')
                        poziom2++;
                    if (structure.toCharArray()[k] == '}' || structure.toCharArray()[k] == ']')
                        poziom2--;
                    if (poziom2 == 0)
                        break;
                    if (structure.toCharArray()[k] != '{' && structure.toCharArray()[k] != '}' && structure.toCharArray()[k] != '[' && structure.toCharArray()[k] != ']' && structure.toCharArray()[k] != '\"')
                        Feature = Feature + structure.toCharArray()[k];
                    else
                        Feature = Feature + " ";
                }
                Features_in_Path = Features_in_Path + " " + Feature;
            }
        }
        return Features_in_Path;
    }


    /**
     * Removes words in string that appears more than once time
     * @param s string consists of words separated by space
     * @return string with words that appears once
     */
    public String removeDuplicates(String s)
    {
        String Return = "";
        String[] arr = s.split(" ");
        int coutner = 0;
        for (int i=0; i<arr.length; i++)
        {
            coutner = 0;
            for (int j=i+1; j<arr.length; j++)
            {
                if (arr[i].equals(arr[j]))
                {
                    coutner++;
                    break;
                }
            }
            if (coutner == 0)
                Return = Return + arr[i] + " ";
        }
        return Return;
    }

    /**
     * From all features in json code, function removes given features and features that contains given features
     * @param json JSON representation in String
     * @param specificProperties features that need to be removed from all features
     * @return all features separated by space without given features and features that contains them
     */
    public String removeGivenProperties(String json, String[] specificProperties)
    {
        String Structure = structure(json);
        String Cechy_ktore_musza_zostac = "";
        for (int i=0; i<specificProperties.length; i++)
            Cechy_ktore_musza_zostac = Cechy_ktore_musza_zostac + removeDuplicates(findPath(Structure, specificProperties[i])) + specificProperties[i] + " ";
        Cechy_ktore_musza_zostac = removeDuplicates(Cechy_ktore_musza_zostac);
        specificProperties = Cechy_ktore_musza_zostac.split(" ");
        String AllFeatures = findFeatures(json);
        for (int i=0; i<specificProperties.length; i++)
            AllFeatures = AllFeatures.replace(specificProperties[i], "");
        AllFeatures = removeDuplicates(AllFeatures);
        return AllFeatures;
    }

    /**
     * Removes all features form json code except given features and features that contains given features
     * @param json JSON representation in String
     * @param specificProperties features that need to be left in code
     * @return json code with removed redundant features
     */
    public String keepGivenProperties(String json, String[] specificProperties)
    {
        String To_Remove_string = removeGivenProperties(json, specificProperties);
        String[] To_Remove = To_Remove_string.split(" ");
        for (int i=0; i<To_Remove.length; i++) if (To_Remove[i].length() > 0)
            json = remove(json, To_Remove[i]);
        return json;
    }

    /**
     * @param json JSON representation in String
     * @return some string
     */

    public String zachowajPodaneTest(String json, String[] specificProperties, TransformJSONSpecificProperties transformJSONSpecificProperties){
        return "Test: " + transformJSONSpecificProperties.removeGivenProperties(json,specificProperties);
    }

    /**
     *
     * @param json JSON representation in String
     * @param transformJSONSpecificProperties instance of TransformJSONSpecificProperties class
     * @return test string
     */
    public String structureTest(String json, TransformJSONSpecificProperties transformJSONSpecificProperties){
        return "Test: " + transformJSONSpecificProperties.structure(json);
    }

    /**
     *
     * @param json JSON representation in String
     * @param transformJSONSpecificProperties instance of TransformJSONSpecificProperties class
     * @return test string
     */
    public String removeTest(String json, String specificProperties, TransformJSONSpecificProperties transformJSONSpecificProperties){
        return "Test: " + transformJSONSpecificProperties.remove(json,specificProperties);
    }

    /**
     *
     * @param json JSON representation in String
     * @param transformJSONSpecificProperties instance of TransformJSONSpecificProperties class
     * @return test string
     */
    public String findPathTest(String json, String specificProperties, TransformJSONSpecificProperties transformJSONSpecificProperties){
        return "Test: " + transformJSONSpecificProperties.findPath(json,specificProperties);
    }

    /**
     *
     * @param json JSON representation in String
     * @param transformJSONSpecificProperties instance of TransformJSONSpecificProperties class
     * @return test string
     */
    public String removeDuplicatesTest(String json, TransformJSONSpecificProperties transformJSONSpecificProperties){
        return "Test: " + transformJSONSpecificProperties.removeDuplicates(json);
    }

    /**
     * @param json JSON representation in String
     * @return Integer ArrayList
     */
    @Override
    public String operation(String json) {
        return null;
    }

    /**
     * @param compareClass instance of class CompareClass
     * @return Integer ArrayList
     */
    @Override
    public ArrayList<Integer> operation(CompareJSON.CompareClass compareClass) {
        return null;
    }

    /**
     * @param compareClass instance of class CompareClass
     * @return some string
     */
    @Override
    public String operation(TransformJSONWithoutSpecificProperties.CompareClass compareClass) {
        return transformJSONSpecificProperties(compareClass);
    }
}