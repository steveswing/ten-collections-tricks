package com.briarshore.codemash.collections;

import java.time.LocalDate;
import java.time.Month;
import java.util.SortedSet;
import java.util.TreeSet;

public class CorporateCalendarManager {

    private static SortedSet<LocalDate> companyHolidays;

    public static SortedSet<LocalDate> getCompanyHolidays() {
        if (null == companyHolidays) {
            companyHolidays = initializeCompanyHolidays();
        }
        return companyHolidays;
    }

    public static SortedSet<LocalDate> initializeCompanyHolidays() {
        final SortedSet<LocalDate> holidays = new TreeSet<>();

        holidays.add(LocalDate.of(2014, Month.DECEMBER, 24));
        holidays.add(LocalDate.of(2014, Month.DECEMBER, 25));
        holidays.add(LocalDate.of(2015, Month.JANUARY, 1));
        holidays.add(LocalDate.of(2015, Month.MAY, 25));
        holidays.add(LocalDate.of(2015, Month.JULY, 3));
        holidays.add(LocalDate.of(2015, Month.SEPTEMBER, 7));
        holidays.add(LocalDate.of(2015, Month.NOVEMBER, 26));
        holidays.add(LocalDate.of(2015, Month.NOVEMBER, 27));
        holidays.add(LocalDate.of(2015, Month.DECEMBER, 24));
        holidays.add(LocalDate.of(2015, Month.DECEMBER, 25));
        holidays.add(LocalDate.of(2016, Month.JANUARY, 1));
        return holidays;
    }

    public static LocalDate getHolidayBefore(final LocalDate date) {
        return getCompanyHolidays().headSet(date).last();
    }

    public static LocalDate getHolidayAfter(final LocalDate date) {
        return getCompanyHolidays().tailSet(date).first();
    }
}
