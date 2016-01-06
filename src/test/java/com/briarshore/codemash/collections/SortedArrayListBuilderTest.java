package com.briarshore.codemash.collections;

import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SortedArrayListBuilderTest {

    private SortedArrayListBuilder builder;

    @Before
    public void setUp() throws Exception {
        builder = new SortedArrayListBuilder();
    }

    @Test
    public void testAddSingleItemToCollection() {
        Assert.assertNotNull("expected a valid object", builder);

        final String expected = "CodeMash 2016";
        boolean actual = builder.add(expected);

        Assert.assertTrue("expected true for successful add", actual);

        final List<String> actualItems = builder.getItems();

        Assert.assertNotNull("expected non-null collection", actualItems);

        Assert.assertFalse("expected non-empty list", actualItems.isEmpty()); // <-- notice: use isEmpty() not 0 == size().

        Assert.assertTrue("expected true", actualItems.contains(expected));

        for (final String actualItem : actualItems) {
            Assert.assertEquals("expected match", expected, actualItem);
        }
    }

    @Test
    public void testAddTwoItemsUnsorted() {
        Assert.assertNotNull("expected non-null", builder);

        final String expected2 = "Item 2";

        final String expected1 = "Item 1";

        Assert.assertTrue("expected true", builder.add(expected2));
        Assert.assertTrue("expected true", builder.add(expected1));

        final List<String> actualItems = builder.getItems();

        Assert.assertEquals("expected match", expected1 + ", " + expected2, new StringJoiner(", ").add(actualItems.get(0)).add(actualItems.get(1)).toString());

        Assert.assertNotNull("expected non-null", actualItems);
        Assert.assertEquals("expected match", 2, actualItems.size());

        final String actual0 = actualItems.get(0);
        Assert.assertEquals("expected match", expected1, actual0);

        final String actual1 = actualItems.get(1);
        Assert.assertEquals("expected match", expected2, actual1);

        final List<String> expectedItemsOrdered = Arrays.asList(expected1, expected2);
        Assert.assertEquals("expected match", expectedItemsOrdered, actualItems);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testItemsIsUnmodifiable() throws Exception {
        builder.getItems().add("Failure");
        Assert.fail("expected exception: ");

    }
}
