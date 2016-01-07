package com.briarshore.codemash.collections;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.google.common.base.Strings;
import com.google.common.collect.Maps;

public class FunctionTranslators {
    private static final Comparator<String> nullSafeCaseInsensitiveComparator = new Comparator<String>() {
        @Override
        public int compare(final String s1, final String s2) {
            return Strings.nullToEmpty(s1).compareToIgnoreCase(Strings.nullToEmpty(s2));
        }
    };

    private static final Map<String, Object> toppingTranslator = initializeToppingTranslator();

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

    private static final ParameterTranslator<Map<String, Object>, List<String>> baconToParamCriteria = new ParameterTranslator<Map<String, Object>, List<String>>() {
        @Override
        public void apply(final Map<String, Object> m, final List<String> values) {
            if (null != values && !values.isEmpty()) {
                m.put("BACON", values.stream().map(new Function<String, Object>() {
                    @Override
                    public Object apply(final String s) {
                        return toppingTranslator.get(s);
                    }
                }).collect(Collectors.toList()));
            }
        }
    };

    private static final ParameterTranslator<Map<String, Object>, List<String>> cheeseToParamCriteria = new ParameterTranslator<Map<String, Object>, List<String>>() {
        @Override
        public void apply(final Map<String, Object> m, final List<String> values) {
            if (null != values && !values.isEmpty()) {
                m.put("CHEESE", values.stream().map(new Function<String, Object>() {
                    @Override
                    public Object apply(final String s) {
                        return toppingTranslator.get(s);
                    }
                }).collect(Collectors.toList()));
            }
        }
    };

    private static final ParameterTranslator<Map<String, Object>, List<String>> pepperoniToParamCriteria = new ParameterTranslator<Map<String, Object>, List<String>>() {
        @Override
        public void apply(final Map<String, Object> m, final List<String> values) {
            if (null != values && !values.isEmpty()) {
                m.put("pepperoni", values.stream().map(new Function<String, Object>() {
                    @Override
                    public Object apply(final String s) {
                        return toppingTranslator.get(s);
                    }
                }).collect(Collectors.toList()));
            }
        }
    };

    private static final ParameterTranslator<Map<String, Object>, List<String>> sausageToParamCriteria = new ParameterTranslator<Map<String, Object>, List<String>>() {
        @Override
        public void apply(final Map<String, Object> m, final List<String> values) {
            if (null != values && !values.isEmpty()) {
                m.put("SAUSAGE", values.stream().map(new Function<String, Object>() {
                    @Override
                    public Object apply(final String s) {
                        return toppingTranslator.get(s);
                    }
                }).collect(Collectors.toList()));
            }
        }
    };

    private static final ParameterTranslator<Map<String, Object>, List<String>> hamToParamCriteria = new ParameterTranslator<Map<String, Object>, List<String>>() {
        @Override
        public void apply(final Map<String, Object> m, final List<String> values) {
            if (null != values && !values.isEmpty()) {
                m.put("HAM", values.stream().map(new Function<String, Object>() {
                    @Override
                    public Object apply(final String s) {
                        return toppingTranslator.get(s);
                    }
                }).collect(Collectors.toList()));
            }
        }
    };

    private static final ParameterTranslator<Map<String, Object>, List<String>> canadianBaconToParamCriteria = new ParameterTranslator<Map<String, Object>, List<String>>() {
        @Override
        public void apply(final Map<String, Object> m, final List<String> values) {
            if (null != values && !values.isEmpty()) {
                m.put("CDNBACON", values.stream().map(new Function<String, Object>() {
                    @Override
                    public Object apply(final String s) {
                        return toppingTranslator.get(s);
                    }
                }).collect(Collectors.toList()));
            }
        }
    };

    private static final ParameterTranslator<Map<String, Object>, List<String>> oliveToParamCriteria = new ParameterTranslator<Map<String, Object>, List<String>>() {
        @Override
        public void apply(final Map<String, Object> m, final List<String> values) {
            if (null != values && !values.isEmpty()) {
                m.put("OLIVES", values.stream().map(new Function<String, Object>() {
                    @Override
                    public Object apply(final String s) {
                        return toppingTranslator.get(s);
                    }
                }).collect(Collectors.toList()));
            }
        }
    };

    private static final ParameterTranslator<Map<String, Object>, List<String>> onionToParamCriteria = new ParameterTranslator<Map<String, Object>, List<String>>() {
        @Override
        public void apply(final Map<String, Object> m, final List<String> values) {
            if (null != values && !values.isEmpty()) {
                m.put("ONION", values.stream().map(new Function<String, Object>() {
                    @Override
                    public Object apply(final String s) {
                        return toppingTranslator.get(s);
                    }
                }).collect(Collectors.toList()));
            }
        }
    };

    private static final ParameterTranslator<Map<String, Object>, List<String>> greenPepperToParamCriteria = new ParameterTranslator<Map<String, Object>, List<String>>() {
        @Override
        public void apply(final Map<String, Object> m, final List<String> values) {
            if (null != values && !values.isEmpty()) {
                m.put("GREENPEP", values.stream().map(new Function<String, Object>() {
                    @Override
                    public Object apply(final String s) {
                        return toppingTranslator.get(s);
                    }
                }).collect(Collectors.toList()));
            }
        }
    };

    private static final ParameterTranslator<Map<String, Object>, List<String>> pineappleToParamCriteria = new ParameterTranslator<Map<String, Object>, List<String>>() {
        @Override
        public void apply(final Map<String, Object> m, final List<String> values) {
            if (null != values && !values.isEmpty()) {
                m.put("PINAPPL", values.stream().map(new Function<String, Object>() {
                    @Override
                    public Object apply(final String s) {
                        return toppingTranslator.get(s);
                    }
                }).collect(Collectors.toList()));
            }
        }
    };

    private static final ParameterTranslator<Map<String, Object>, List<String>> mushroomToParamCriteria = new ParameterTranslator<Map<String, Object>, List<String>>() {
        @Override
        public void apply(final Map<String, Object> m, final List<String> values) {
            if (null != values && !values.isEmpty()) {
                m.put("MUSHROOM", values.stream().map(new Function<String, Object>() {
                    @Override
                    public Object apply(final String s) {
                        return toppingTranslator.get(s);
                    }
                }));
            }
        }
    };

    static final Map<String, ParameterTranslator<Map<String, Object>, List<String>>> urlParamMatcher = new TreeMap<String, ParameterTranslator<Map<String, Object>, List<String>>>(
            nullSafeCaseInsensitiveComparator) {{
        put("b", baconToParamCriteria);
        put("c", cheeseToParamCriteria);
        put("p", pepperoniToParamCriteria);
        put("s", sausageToParamCriteria);
        put("h", hamToParamCriteria);
        put("cb", canadianBaconToParamCriteria);
        put("gb", oliveToParamCriteria);
        put("o", onionToParamCriteria);
        put("gp", greenPepperToParamCriteria);
        put("a", pineappleToParamCriteria);
        put("m", mushroomToParamCriteria);
    }};

    public void processQueryParameters(final Map<String, Object> params, final Map<String, List<String>> queryParameters) {
        queryParameters.entrySet().forEach(new Consumer<Map.Entry<String, List<String>>>() {
            @Override
            public void accept(final Map.Entry<String, List<String>> e) {
                final ParameterTranslator<Map<String, Object>, List<String>> parameterTranslator = urlParamMatcher.get(e.getKey());
                parameterTranslator.apply(params, e.getValue());
            }
        });
    }
}
