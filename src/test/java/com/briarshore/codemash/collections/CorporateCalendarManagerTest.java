package com.briarshore.codemash.collections;

import java.time.LocalDate;
import java.time.Month;
import java.util.SortedSet;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CorporateCalendarManagerTest {

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void testSortedSetHeadSetTailSet() throws Exception {
        final SortedSet<LocalDate> holidays = CorporateCalendarManager.getCompanyHolidays();

        Assert.assertNotNull("expected non-null", holidays);

        Assert.assertEquals("expected match", LocalDate.of(2015, Month.MAY, 25), CorporateCalendarManager.getHolidayBefore(LocalDate.of(2015, Month.JULY, 1)));
        Assert.assertEquals("expected match", LocalDate.of(2015, Month.JULY, 3), CorporateCalendarManager.getHolidayAfter(LocalDate.of(2015, Month.JULY, 1)));
    }
}
