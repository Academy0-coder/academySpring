package com.vlc2.academy.library.utility;

import java.time.LocalDate;

public class DateUtility {

    public static Integer extractMonth (LocalDate date) {
        return date.getMonthValue();
    }

    public static Integer extractWeek (LocalDate date) {
        return (int) Math.ceil((date.getDayOfYear() - date.getDayOfWeek().getValue())/7.0) + 1;
    }

    public static LocalDate firstDateOfMonth(LocalDate date) {
        return date.withDayOfMonth(1);
    }

    public static LocalDate lastDateOfMonth(LocalDate date) {
        return date.withDayOfMonth(date.getMonth().length(date.isLeapYear()));
    }

    public static LocalDate firstDateOfWeek(LocalDate date) {
        return date.minusDays(date.getDayOfWeek().getValue()-1);
    }

    public static LocalDate lastDateOfWeek(LocalDate date) {
        return date.plusDays(7-date.getDayOfWeek().getValue());
    }
}
