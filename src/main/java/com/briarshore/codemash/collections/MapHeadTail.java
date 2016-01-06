package com.briarshore.codemash.collections;

import java.time.LocalDate;
import java.time.Month;
import java.util.SortedMap;
import java.util.TreeMap;

public class MapHeadTail {
    private static SortedMap<LocalDate, String> companyHolidayNames;

    public SortedMap<LocalDate, String> getCompanyHolidayNames() {
        if (null == companyHolidayNames) {
            companyHolidayNames = initializeCompanyHolidayNames();
        }
        return companyHolidayNames;
    }

    private static SortedMap<LocalDate, String> initializeCompanyHolidayNames() {
        final SortedMap<LocalDate, String> holidays = new TreeMap<>();

        holidays.put(LocalDate.of(2014, Month.DECEMBER, 24), "Christmas Eve");
        holidays.put(LocalDate.of(2014, Month.DECEMBER, 25), "Christmas Day");
        holidays.put(LocalDate.of(2015, Month.JANUARY, 1), "New Year's Day");
        holidays.put(LocalDate.of(2015, Month.MAY, 25), "Memorial Day");
        holidays.put(LocalDate.of(2015, Month.JULY, 3), "Independence Day");
        holidays.put(LocalDate.of(2015, Month.SEPTEMBER, 7), "Labor Day");
        holidays.put(LocalDate.of(2015, Month.NOVEMBER, 26), "Thanksgiving Day");
        holidays.put(LocalDate.of(2015, Month.NOVEMBER, 27), "Thanksgiving Friday");
        holidays.put(LocalDate.of(2015, Month.DECEMBER, 24), "Christmas Eve");
        holidays.put(LocalDate.of(2015, Month.DECEMBER, 25), "Christmas Day");
        holidays.put(LocalDate.of(2016, Month.JANUARY, 1), "New Year's Day");
        return holidays;
    }

    public String getCorporateHolidayNameBefore(final LocalDate date) {
        final SortedMap<LocalDate, String> holidaysBeforeDate = getCompanyHolidayNames().headMap(date);
        return holidaysBeforeDate.get(holidaysBeforeDate.lastKey());
    }

    public String getCorporateHolidayNameAfter(final LocalDate date) {
        final SortedMap<LocalDate, String> holidaysAfterDate = getCompanyHolidayNames().tailMap(date);
        return holidaysAfterDate.get(holidaysAfterDate.firstKey());
    }
}
