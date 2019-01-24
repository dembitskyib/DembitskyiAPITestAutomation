package com.goodreads.utils.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GoodReadsTestListener implements ITestListener {
    private Map<String, String> methodDescriptions = new HashMap<>();

    @Override
    public void onTestStart(ITestResult result) {
        changeDescription(result);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
    }

    @Override
    public void onTestFailure(ITestResult result) {
    }

    @Override
    public void onTestSkipped(ITestResult result) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {
        methodDescriptions = Stream.of(context.getAllTestMethods())
                .collect(Collectors.toMap(ITestNGMethod::getMethodName,ITestNGMethod::getDescription));
    }

    @Override
    public void onFinish(ITestContext result) {
    }

    private void changeDescription(ITestResult testResult) {
        ITestNGMethod method = testResult.getMethod();
        methodDescriptions.entrySet().stream()
                .filter(entry -> entry.getKey().equals(method.getMethodName())).findAny()
                .ifPresent(entry ->
                        method.setDescription(String.format(entry.getValue(), testResult.getParameters())));
    }
}
