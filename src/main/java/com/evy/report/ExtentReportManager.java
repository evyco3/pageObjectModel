package com.evy.report;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.awt.*;
import java.io.File;
import java.util.Objects;

public final class ExtentReportManager {
    private ExtentReportManager() {
    }

    private static ExtentReports extent;


    public static void initReport() {
        if (Objects.isNull(extent)) {
            extent = new ExtentReports();
            ExtentSparkReporter spark = new ExtentSparkReporter("output/reporter.html");
            spark.config().setTheme(Theme.DARK);
            //  spark.config().setEncoding("UTF-8");
            spark.config().setDocumentTitle("tera QA");
            spark.config().setReportName("It-eraQA reports");
            extent.attachReporter(spark);
        }
    }

    public static void flushReport() {
        if (Objects.nonNull(extent)) {
            try {
                extent.flush();
                Desktop.getDesktop().browse(new File("output/reporter.html").toURI());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void createTest(String testName) {
        ExtentTestManager.setTest(extent.createTest(testName));
    }
}
