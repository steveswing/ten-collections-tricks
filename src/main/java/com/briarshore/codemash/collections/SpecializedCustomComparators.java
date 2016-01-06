package com.briarshore.codemash.collections;

import java.util.Collections;
import java.util.Comparator;
import java.util.Map;

import com.google.common.base.Strings;
import com.google.common.collect.Maps;

public class SpecializedCustomComparators {
    public static final Comparator<String> nullSafeCaseInsensitiveComparator = new Comparator<String>() {

        @Override
        public int compare(final String s1, final String s2) {

            return Strings.nullToEmpty(s1).compareToIgnoreCase(Strings.nullToEmpty(s2));
        }
    };

    public static final Comparator<String> nullSafeCaseInsensitiveDescendingComparator = Collections.reverseOrder(nullSafeCaseInsensitiveComparator);
            // java 1.8 nullSafeCaseInsensitiveComparator.reverse()
    // This how Java 8 provides default implementations for Interface methods.
    public Comparator<String> nullSafeCaseInsensitiveComparatorReversed = nullSafeCaseInsensitiveComparator.reversed();

    public static final Comparator<String> clockwiseRoomComparator = new Comparator<String>() {
        final Map<String, Integer> order = initializeOrder();

        private Map<String, Integer> initializeOrder() {
            final Map<String, Integer> result = Maps.newTreeMap(nullSafeCaseInsensitiveComparator);
            result.put("Indigo Bay", 0);
            result.put("Orange", 1);
            result.put("Nile", 2);
            result.put("Zambezi", 3);
            result.put("Aloeswood/Leopardwood", 4);
            result.put("Rosewood", 5);
            result.put("Sagewood/Zebrawood", 6);
            result.put("Salon E", 7);
            result.put("Cypress", 8);
            result.put("Salon D", 9);
            result.put("Guava/Tamarind", 10);
            result.put("Mangrove", 11);
            result.put("Portia/Wisteria", 12);
            result.put("Salon A", 13);
            result.put("Salon H", 14);
            return result;
        }

        @Override
        public int compare(final String s1, final String s2) {
            final Integer s1Index = order.getOrDefault(s1, Integer.MAX_VALUE);
            final Integer s2Index = order.getOrDefault(s2, Integer.MAX_VALUE);
            return Integer.compare(s1Index, s2Index);
        }
    };
    public static final Comparator<String> counterClockwiseRoomComparator = clockwiseRoomComparator.reversed();
}
