package com.vlc2.academy.library.utility;

import java.time.LocalDate;

public class DateUtility {

    // Get the integer that represents the Month of a specific date
    // e.g. 2026-10-17 would result in 10 which represents October
    public static Integer extractMonth (LocalDate date) {
        return date.getMonthValue();
    }


    // Get the integer that represents the Week of a specific date
    // The week goes from Monday to Sunday and January 1st is always in the week n°1
    // Week n°1 ends on the first Sunday of the year and not on January 7th therefore it could last less than 7 days
    // The following week would be week n°2 and so on
    public static Integer extractWeek (LocalDate date) {
        return (int) Math.ceil((date.getDayOfYear() - date.getDayOfWeek().getValue())/7.0) + 1;
    }


    // Get the date representing the first day of the month of the date passed as parameter
    public static LocalDate firstDateOfMonth(LocalDate date) {
        return date.withDayOfMonth(1);
    }

    // Get the date representing the last day of the month of the date passed as parameter
    public static LocalDate lastDateOfMonth(LocalDate date) {
        return date.withDayOfMonth(date.getMonth().length(date.isLeapYear()));
    }

    // Get the date representing the Monday of the week of the date passed as parameter
    public static LocalDate firstDateOfWeek(LocalDate date) {
        return date.minusDays(date.getDayOfWeek().getValue()-1);
    }

    // Get the date representing the Sunday of the week of the date passed as parameter
    public static LocalDate lastDateOfWeek(LocalDate date) {
        return date.plusDays(7-date.getDayOfWeek().getValue());
    }
}
