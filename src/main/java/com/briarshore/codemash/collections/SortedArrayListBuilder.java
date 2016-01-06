package com.briarshore.codemash.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This is an example of how *NOT* to build a sorted array list
 */
public class SortedArrayListBuilder {
    // Note: List and not ArrayList: principle -> Code to interfaces.
    // Note: 'final' does not make the list immutable/unmodifiable... I just can't reassign the field items.
    private final List<String> items;

    public SortedArrayListBuilder() {
        this.items = new ArrayList<String>();
    }

    public boolean add(final String s) {
        final boolean result = items.add(s);
        Collections.sort(items);
        return result;
    }

    public List<String> getItems() {
        return items;
    }
}
