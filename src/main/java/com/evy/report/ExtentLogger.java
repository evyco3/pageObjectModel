package com.evy.report;

import com.evy.enums.LogType;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public final class ExtentLogger {
    private ExtentLogger() {
    }

    private static final Map<LogType, Consumer<String>> MAP = new HashMap<>();
    private static final Consumer<String> PASS = (message) -> ExtentTestManager.getTest().pass(message);
    private static final Consumer<String> FAIL = (message) -> ExtentTestManager.getTest().fail(message);
    private static final Consumer<String> SKIP = (message) -> ExtentTestManager.getTest().skip(message);
    private static final Consumer<String> INFO = (message) -> ExtentTestManager.getTest().info(message);


    static {
        MAP.put(LogType.PASS, PASS);
        MAP.put(LogType.SKIP, SKIP);
        MAP.put(LogType.FAIL, FAIL);
        MAP.put(LogType.INFO, INFO);


    }

    public static void log(LogType logtype, String message) {
        MAP.get(logtype).accept(message);
    }


}

