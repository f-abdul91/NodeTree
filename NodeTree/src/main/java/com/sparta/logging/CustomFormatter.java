package com.sparta.logging;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

public class CustomFormatter extends Formatter {
    @Override
    public String format(LogRecord record) {
        return "\n" + LocalDate.now().format(DateTimeFormatter.BASIC_ISO_DATE)
                + " " +   record.getSourceClassName()
                +" "+  record.getLevel()
                +" "+ record.getMessage()+" \n";
    }
}