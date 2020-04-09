package com.hellofresh.challenge.tests;

import com.hellofresh.challenge.driverFactory.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.*;
import java.lang.reflect.Method;
import java.net.MalformedURLException;

/**
 * BaseTest class for setting up Thread safe Driver Factory and Test hooks
 * Also receives parameters from testng.xml
 */
public class BaseTest {
    protected static ThreadLocal<WebDriver> threadSafeDriver = new ThreadLocal<>();

    @BeforeMethod
    @Parameters(value={"browser"})
    public void setup (String browser, ITestContext context) throws MalformedURLException {
        DriverFactory driverFactory = new DriverFactory();
        WebDriver driver = driverFactory.createDriver(browser);

        //Set Browser to ThreadLocalMap
        threadSafeDriver.set(driver);
        threadSafeDriver.get().get("http://automationpractice.com/index.php");

        context.setAttribute("webDriver", threadSafeDriver.get());
    }

    /**
     * getDriver Method: Used to retrieve threadSafe driver object
     * by Tests.
     * @return ThreadLocal Webdriver
     */
    public WebDriver getDriver() {
        //Get driver from ThreadLocalMap
        return threadSafeDriver.get();
    }

    /**
     * Teardown to quit all open driver instances.
     */
    @AfterMethod
    public void tearDown() {
        getDriver().quit();
    }

    /**
     * Remove threadLocal driver.
     */
    @AfterClass
    public void terminate () {
        //Remove the ThreadLocalMap element
        threadSafeDriver.remove();
    }

}
