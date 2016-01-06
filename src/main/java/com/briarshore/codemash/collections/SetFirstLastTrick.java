package com.briarshore.codemash.collections;

import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.function.LongFunction;
import java.util.stream.Collectors;

public class SetFirstLastTrick {
    public SortedSet<Date> getUniqueSortedDates(final List<Date> dates) {
        return new TreeSet<>(dates);
    }

    public List<Date> historicalDateGenerator(final long streamSize) {
        return new Random().longs(streamSize, 0L, System.currentTimeMillis()).mapToObj(new LongFunction<Date>() {
            @Override
            public Date apply(final long value) {
                return new Date(value);
            }
        }).collect(Collectors.toList());
    }
}
