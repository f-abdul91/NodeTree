package com.sparta.logging;

import com.sparta.BinaryTree;

import java.io.IOException;
import java.util.logging.*;

public class ConsoleHandlerConfig {

    public static void getConsoleHandler(Logger logger) {
        try {
            var consoleHandler = new ConsoleHandler();
            consoleHandler.setLevel(Level.ALL);
          //  consoleHandler.setFilter(new CustomFilter());
            logger.addHandler(consoleHandler);

        } catch (Throwable e) {
            e.printStackTrace();
        }
    }
}
