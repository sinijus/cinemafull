package com.jaanussinivali.cinemaback.util;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class StringToDateTime {

    public static LocalTime stringToLocalTime(String time) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm");
        String formattedTime = Objects.equals(time, "24") ? "23:59" : (time + ":00");
        return LocalTime.parse(formattedTime, dateTimeFormatter);
    }

    public static LocalDate stringToLocalDate(String date) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return LocalDate.parse(date, dateTimeFormatter);
    }
}
