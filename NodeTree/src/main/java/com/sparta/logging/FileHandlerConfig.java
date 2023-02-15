package com.sparta.logging;

import com.sparta.BinaryTree;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class FileHandlerConfig {

    public static void getFileHandler(Logger logger) {


        try {
            FileHandler fileHandler = new FileHandler("src/main/resources/logFile.log", true);
            fileHandler.setLevel(Level.ALL);
            fileHandler.setFormatter(new CustomFormatter());
            logger.addHandler(fileHandler);
            ConsoleHandlerConfig.getConsoleHandler(logger);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}