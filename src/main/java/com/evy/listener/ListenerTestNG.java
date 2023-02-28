package com.evy.listener;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.evy.enums.LogType;
import com.evy.report.ExtentLogger;
import com.evy.report.ExtentReportManager;
import com.evy.report.ExtentTestManager;
import com.evy.utils.ScreenshotUtils;
import org.testng.*;

import java.util.Arrays;

public class ListenerTestNG implements ITestListener {


    @Override
    public void onTestStart(ITestResult result) {
        ExtentReportManager.createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentLogger.log(LogType.PASS, result.getMethod().getMethodName() + " is Pass");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ExtentLogger.log(LogType.FAIL, result.getMethod().getMethodName() + " is Failed");
        ExtentLogger.log(LogType.FAIL, result.getThrowable().toString());
        ExtentLogger.log(LogType.FAIL, Arrays.toString(result.getThrowable().getStackTrace()));
        ExtentTestManager.getTest().fail(MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.get64BaseImg()).build());


    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ExtentLogger.log(LogType.SKIP, result.getMethod().getMethodName() + " is skipped");
        ExtentTestManager.getTest().skip(MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.get64BaseImg()).build());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {
        ExtentReportManager.initReport();
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        ExtentReportManager.flushReport();
    }


}
