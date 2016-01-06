package com.briarshore.codemash.collections;

import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.Lists;

public class SpecializedCustomComparatorsTest {

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void testNullSafeCaseInsenstiveComparatorWithNulls() throws Exception {
        Assert.assertEquals("expected match", 0, SpecializedCustomComparators.nullSafeCaseInsensitiveComparator.compare(null, null));
        Assert.assertEquals("expected match", -1, SpecializedCustomComparators.nullSafeCaseInsensitiveComparator.compare(null, "a"));
        Assert.assertEquals("expected match", 1, SpecializedCustomComparators.nullSafeCaseInsensitiveComparator.compare("a", null));
    }

    @Test
    public void testWithUpperLowerAscending() throws Exception {
        Assert.assertEquals("expected match", 0, SpecializedCustomComparators.nullSafeCaseInsensitiveComparator.compare("a", "A"));
        Assert.assertEquals("expected match", 0, SpecializedCustomComparators.nullSafeCaseInsensitiveComparator.compare("A", "a"));
        Assert.assertEquals("expected match", -1, SpecializedCustomComparators.nullSafeCaseInsensitiveComparator.compare("A", "b"));
        Assert.assertEquals("expected match", -1, SpecializedCustomComparators.nullSafeCaseInsensitiveComparator.compare("a", "B"));
        Assert.assertEquals("expected match", 1, SpecializedCustomComparators.nullSafeCaseInsensitiveComparator.compare("b", "A"));
        Assert.assertEquals("expected match", 1, SpecializedCustomComparators.nullSafeCaseInsensitiveComparator.compare("B", "a"));
    }

    @Test
    public void testWithUpperLowerDescending() throws Exception {
        Assert.assertEquals("expected match", 0, SpecializedCustomComparators.nullSafeCaseInsensitiveDescendingComparator.compare("a", "A"));
        Assert.assertEquals("expected match", 0, SpecializedCustomComparators.nullSafeCaseInsensitiveDescendingComparator.compare("A", "a"));
        Assert.assertEquals("expected match", 1, SpecializedCustomComparators.nullSafeCaseInsensitiveDescendingComparator.compare("A", "b"));
        Assert.assertEquals("expected match", 1, SpecializedCustomComparators.nullSafeCaseInsensitiveDescendingComparator.compare("a", "B"));
        Assert.assertEquals("expected match", -1, SpecializedCustomComparators.nullSafeCaseInsensitiveDescendingComparator.compare("b", "A"));
        Assert.assertEquals("expected match", -1, SpecializedCustomComparators.nullSafeCaseInsensitiveDescendingComparator.compare("B", "a"));
    }

    @Test
    public void testSpecializeRoomOrderClockwise() throws Exception {
        final List<String> sessionRoomNames = Lists.newArrayList("Aloeswood/Leopardwood", "Cypress", "Guava/Tamarind", "Indigo Bay", "Mangrove", "Nile", "Orange", "Portia/Wisteria", "Rosewood",
                "Sagewood/Zebrawood", "Salon A", "Salon D", "Salon E", "Salon H", "Zambezi");
        Collections.sort(sessionRoomNames, SpecializedCustomComparators.clockwiseRoomComparator);
        System.out.println("Clockwise:");
        sessionRoomNames.forEach(new Consumer<String>() {
            @Override
            public void accept(final String s) {
                System.out.printf("Room: %s%n", s);
            }
        });
    }

    @Test
    public void testSpecializeRoomOrderCounterClockwise() throws Exception {
        final List<String> sessionRoomNames = Lists.newArrayList("Aloeswood/Leopardwood", "Cypress", "Guava/Tamarind", "Indigo Bay", "Mangrove", "Nile", "Orange", "Portia/Wisteria", "Rosewood",
                "Sagewood/Zebrawood", "Salon A", "Salon D", "Salon E", "Salon H", "Zambezi");
        Collections.sort(sessionRoomNames, SpecializedCustomComparators.counterClockwiseRoomComparator);
        System.out.println("CounterClockwise:");
        sessionRoomNames.forEach(new Consumer<String>() {
            @Override
            public void accept(final String s) {
                System.out.printf("Room: %s%n", s);
            }
        });
    }
}
