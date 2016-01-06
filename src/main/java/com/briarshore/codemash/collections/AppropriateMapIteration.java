package com.briarshore.codemash.collections;

import java.util.HashMap;
import java.util.Map;

public class AppropriateMapIteration {
    public static Map<String, String> makeDigitNamesMap() {
        final Map<String, String> result = new HashMap<>();
        result.put("Zero", "0");
        result.put("One", "1");
        result.put("Two", "2");
        result.put("Three", "3");
        result.put("Four", "4");
        result.put("Five", "5");
        result.put("Six", "6");
        result.put("Seven", "7");
        result.put("Eight", "8");
        result.put("Nine", "9");
        result.put("0", "Zero");
        result.put("1", "One");
        result.put("2", "Two");
        result.put("3", "Three");
        result.put("4", "Four");
        result.put("5", "Five");
        result.put("6", "Six");
        result.put("7", "Seven");
        result.put("8", "Eight");
        result.put("9", "Nine");
        return result;
    }
}
