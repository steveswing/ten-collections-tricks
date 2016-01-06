package com.briarshore.codemash.collections;

import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AppropriateMapIterationTest {

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void testMapIterationByKeySet() throws Exception {
        final Map<String, String> m = AppropriateMapIteration.makeDigitNamesMap();
        System.out.println("KeySet Iteration");
        for (final String key : m.keySet()) {
            final String value = m.get(key);
            System.out.printf("key = %s, value = %s%n", key, value);
        }
    }

    @Test
    public void testMapIterationByValues() throws Exception {
        System.out.println("Value Iteration");
        final Map<String, String> m = AppropriateMapIteration.makeDigitNamesMap();
        for (final String value : m.values()) {
            System.out.printf("key = ?, value = %s%n", value);
        }
    }

    @Test
    public void testMapIterationByEntrySet() throws Exception {
        System.out.println("EntrySet Iteration");
        final Map<String, String> m = AppropriateMapIteration.makeDigitNamesMap();
        for (final Map.Entry<String, String> e : m.entrySet()) {
            System.out.printf("e.getKey() = %s, e.getValue() = %s%n", e.getKey(), e.getValue());
            Assert.assertEquals("expected match", m.get(e.getValue()), e.getKey());
        }
    }
}
