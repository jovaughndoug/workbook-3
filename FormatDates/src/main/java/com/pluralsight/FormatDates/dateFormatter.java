package com.pluralsight.FormatDates;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class dateFormatter {
    public static void main(String[] args) {
        LocalDateTime today = LocalDateTime.now(ZoneId.of("UTC"));
        System.out.println(" Today's Date & Time is: " + today);
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern(" EEEE, MMM dd, yyyy KK:mm");
        System.out.println(today.format(fmt));

    }

}
