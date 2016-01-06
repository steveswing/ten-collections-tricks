package com.briarshore.codemash.collections;

import java.time.LocalDate;
import java.time.Month;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MapHeadTailTest {

    private MapHeadTail subject;

    @Before
    public void setUp() throws Exception {
        subject = new MapHeadTail();
    }

    @Test
    public void testGetCorporateHolidayNameBeforeDate() throws Exception {
        final String actual = subject.getCorporateHolidayNameBefore(LocalDate.of(2015, Month.JULY, 1));
        Assert.assertEquals("expected match", "Memorial Day", actual);
    }

    @Test
    public void testGetCorporateHolidayNameAfterDate() throws Exception {
        final String actual = subject.getCorporateHolidayNameAfter(LocalDate.of(2015, Month.JULY, 1));
        Assert.assertEquals("expected match", "Independence Day", actual);
    }
}
