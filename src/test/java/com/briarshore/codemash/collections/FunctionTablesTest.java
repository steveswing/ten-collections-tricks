package com.briarshore.codemash.collections;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FunctionTablesTest {

    private FunctionTables subject;

    @Before
    public void setUp() throws Exception {
        subject = new FunctionTables();
    }

    @Test
    public void testFunctionTableValueTranslation() throws Exception {
        // Jersey can provide queryParameters this way
        // final MultivaluedMap<String, String> queryParameters = uriInfo.getQueryParameters(true);

        final Map<String, Object> params = new HashMap<>();

        // we're treating queryParameters like MultivaluedMap<String, String>
        Map<String, List<String>> queryParameters = makeQueryParameters();

        subject.processQueryParameters(params, queryParameters);

        Assert.assertNotNull("expected non-null", params);
        Assert.assertFalse("expected false", params.isEmpty());
        Assert.assertTrue("expected true", params.containsKey("BACON"));
        Assert.assertEquals("expected match", Collections.singletonList(12345L), params.get("BACON"));

        Assert.assertTrue("expected true", params.containsKey("CDNBACON"));
        Assert.assertEquals("expected match", Collections.singletonList(8L), params.get("CDNBACON"));

        Assert.assertTrue("expected true", params.containsKey("CHEESE"));
        Assert.assertEquals("expected match", Arrays.asList("C1", "C2", "C3"), params.get("CHEESE"));
    }

    private Map<String, List<String>> makeQueryParameters() {
        final Map<String, List<String>> result = new LinkedHashMap<>();

        result.put("b", Collections.singletonList("Bacon"));
        result.put("c", Arrays.asList("Mozzarella", "Provolone", "Parmesan"));
        result.put("p", Collections.singletonList("Pepperoni"));
        result.put("s", Arrays.asList("Sausage", "Italian Sausage"));
        result.put("h", Collections.singletonList("Ham"));
        result.put("cb", Collections.singletonList("Canadian Bacon"));
        result.put("gb", Arrays.asList("Black Olives", "Green Olives"));
        result.put("o", Collections.singletonList("Onion"));
        result.put("gp", Collections.singletonList("Green Pepper"));
        result.put("a", Collections.singletonList("Pineapple"));
        result.put("m", Collections.singletonList("Mushrooms"));

        return result;
    }
}
