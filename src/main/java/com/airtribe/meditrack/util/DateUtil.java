package com.airtribe.meditrack.util;

import java.time.LocalDate;

public class DateUtil {

    private DateUtil(){}

    public static LocalDate today(){
        return LocalDate.now();
    }
}