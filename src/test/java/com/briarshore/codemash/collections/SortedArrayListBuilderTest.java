package com.briarshore.codemash.collections;

import java.util.List;

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
    }
}
