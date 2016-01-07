package com.briarshore.codemash.collections;

import java.util.Comparator;
import java.util.Map;

import com.google.common.base.Strings;
import com.google.common.collect.Maps;

public class ValueTranslators {
    private static final Comparator<String> nullSafeCaseInsensitiveComparator = new Comparator<String>() {
        @Override
        public int compare(final String s1, final String s2) {
            return Strings.nullToEmpty(s1).compareToIgnoreCase(Strings.nullToEmpty(s2));
        }
    };

    public static final Map<String, Object> toppingTranslator = initializeToppingTranslator();

    private static Map<String, Object> initializeToppingTranslator() {
        final Map<String, Object> result = Maps.newTreeMap(nullSafeCaseInsensitiveComparator);
        result.put("Bacon", 12345L);
        result.put("Mozzarella", "C1");
        result.put("Provolone", "C2");
        result.put("Parmesan", "C3");
        result.put("Pepperoni", 4L);
        result.put("Sausage", 5L);
        result.put("Italian Sausage", 6L);
        result.put("Ham", 7L);
        result.put("Canadian Bacon", 8L);
        result.put("Black Olives", 9L);
        result.put("Green Olives", 10L);
        result.put("Onion", 11L);
        result.put("Green Pepper", 12L);
        result.put("Pineapple", 13L);
        result.put("Mushrooms", 14L);
        return result;
    }
}
