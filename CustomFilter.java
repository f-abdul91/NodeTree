package com.sparta.logging;

import javax.xml.crypto.dsig.spec.XPathType;
import java.util.logging.Filter;
import java.util.logging.LogRecord;

public class CustomFilter implements Filter {

    @Override
    public boolean isLoggable(LogRecord record) {
        return false;
    }
}