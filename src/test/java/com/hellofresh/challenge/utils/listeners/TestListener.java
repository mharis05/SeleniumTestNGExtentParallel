package com.hellofresh.challenge.utils.listeners;

import com.hellofresh.challenge.utils.extentReports.ExtentManager;
import com.hellofresh.challenge.utils.extentReports.ExtentTestManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.Status;

import java.io.File;
import java.io.IOException;
import java.time.LocalTime;


/**
 * TestNG Listener class to trigger actions on Test Events.
 */
public class TestListener implements ITestListener {

    // Path to store screenshots in case of failure
    String filePath = "./FailureScreenshots/";

    /**
     * Event listener for onFinish event, flushes the ExtentManager instance.
     *
     * @param context context set in @BeforeMethod
     */
    public void onFinish(ITestContext context) {
        ExtentTestManager.endTest();
        ExtentManager.getInstance().flush();
    }

    /**
     * Set test name in the report as its description instead of Method name.
     *
     * @param result captured test result
     */
    public void onTestStart(ITestResult result) {
        ExtentTestManager.startTest(result.getMethod().getDescription());
    }

    public void onTestSuccess(ITestResult result) {
        ExtentTestManager.getTest().log(Status.PASS, "Test passed");
    }

    /**
     * Failure screenshot implementation.
     * Retrieve driver from context set in @BeforeMethod hook,
     * use this driver to take screenshot of the current page.
     *
     * @param result captured test result
     */
    public void onTestFailure(ITestResult result) {
        String methodName = result.getName().trim();
        ITestContext context = result.getTestContext();
        WebDriver driver = (WebDriver) context.getAttribute("webDriver");
        takeScreenShot(methodName, driver);
        ExtentTestManager.getTest().log(Status.FAIL, "Test Failed");

    }

    public void onTestSkipped(ITestResult result) {
        ExtentTestManager.getTest().log(Status.SKIP, "Test Skipped");
    }


    /**
     * Screenshot saving logic.
     * Saves screenshot using Selenium getScreenshotAs(File f) API.
     * Naming uses current timestamp.
     * @param methodName test method name
     * @param driver Threadsafe Driver
     */
    public void takeScreenShot(String methodName, WebDriver driver) {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, new File(filePath + methodName + "_" + LocalTime.now().toString() + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}