package com.briarshore.codemash.collections;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ValueTranslatorsTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testValueTranslation() throws Exception {
        Assert.assertEquals("expected match", 12345L, ValueTranslators.toppingTranslator.get("BACON"));
        Assert.assertEquals("expected match", 12345L, ValueTranslators.toppingTranslator.get("bacon"));
        Assert.assertEquals("expected match", 12345L, ValueTranslators.toppingTranslator.get("Bacon"));

        Assert.assertEquals("expected match", 8L, ValueTranslators.toppingTranslator.get("Canadian Bacon"));

        Assert.assertEquals("expected match", "C1", ValueTranslators.toppingTranslator.get("Mozzarella"));
    }
}
