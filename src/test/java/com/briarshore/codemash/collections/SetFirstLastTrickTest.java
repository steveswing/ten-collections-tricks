package com.briarshore.codemash.collections;

import java.util.Date;
import java.util.List;
import java.util.SortedSet;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SetFirstLastTrickTest {

    private SetFirstLastTrick subject;

    @Before
    public void setUp() throws Exception {
        subject = new SetFirstLastTrick();
    }

    @Test
    public void testSortedSetFirstLastTrick() throws Exception {
        final long streamSize = 10L;
        final List<Date> dates = subject.historicalDateGenerator(streamSize);
        final SortedSet<Date> uniqueSortedDates = subject.getUniqueSortedDates(dates);
        if (dates.size() == uniqueSortedDates.size()) {
            System.out.println("The stream did not produce any duplicates.");
        }

        Assert.assertFalse("expected false", dates.isEmpty());
        Assert.assertFalse("expected false", uniqueSortedDates.isEmpty());

        System.out.printf("The historicalDateGenerator produced the oldest date of %1$tb %1$td, %1$tY%n", uniqueSortedDates.first());
        System.out.printf("The historicalDateGenerator produced the newest date of %1$tb %1$td, %1$tY%n", uniqueSortedDates.last());

        Assert.assertNotEquals("expected difference", uniqueSortedDates.first(), uniqueSortedDates.last());
    }
}
