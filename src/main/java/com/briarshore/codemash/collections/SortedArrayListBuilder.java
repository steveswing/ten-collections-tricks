package com.briarshore.codemash.collections;

import java.util.List;

/**
 * This is an example of how *NOT* to build a sorted array list
 */
public class SortedArrayListBuilder {
    private List<String> items;

    public boolean add(final String s) {
        return false;
    }

    public List<String> getItems() {
        return items;
    }

    public void setItems(final List<String> items) {
        this.items = items;
    }
}
