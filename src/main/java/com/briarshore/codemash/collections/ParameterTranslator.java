package com.briarshore.codemash.collections;

public interface ParameterTranslator<P, V> {
    void apply(final P p, final V v);
}

