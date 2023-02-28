package com.evy.report;

import com.aventstack.extentreports.ExtentTest;

public final class ExtentTestManager {
    private ExtentTestManager() {
    }

    private static final ThreadLocal<ExtentTest> TEST_THREAD_LOCAL = new ThreadLocal<>();

    public static void setTest(ExtentTest test) {
        TEST_THREAD_LOCAL.set(test);
    }

    public static ExtentTest getTest() {
        return TEST_THREAD_LOCAL.get();
    }

    public static void removeTest() {
        TEST_THREAD_LOCAL.remove();
    }
}
