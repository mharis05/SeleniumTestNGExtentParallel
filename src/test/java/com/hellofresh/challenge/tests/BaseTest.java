package com.hellofresh.challenge.tests;

import com.hellofresh.challenge.driverFactory.DriverFactory;
import com.hellofresh.challenge.utils.PropertyReader;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.apache.log4j.Logger;

import java.net.MalformedURLException;


/**
 * BaseTest class for setting up Thread safe Driver Factory and Test hooks
 * Also receives parameters from testng.xml
 */
public class BaseTest {
    protected static ThreadLocal<WebDriver> threadSafeDriver = new ThreadLocal<>();
    private static final Logger logger = Logger.getLogger(BaseTest.class.getName());

    @BeforeMethod
    @Parameters(value = {"browser"})
    public void setup(String browser, ITestContext context) {

        logger.info("Creating threadsafe driver instance for" + browser);
        DriverFactory driverFactory = new DriverFactory();
        WebDriver driver = driverFactory.createDriver(browser);

        //Set Browser to ThreadLocalMap
        threadSafeDriver.set(driver);
        String url = PropertyReader.getProperty("baseUrl");
        threadSafeDriver.get().get(url);

        logger.info("WebDriver saved to context.");
        context.setAttribute("webDriver", threadSafeDriver.get());
    }

    /**
     * getDriver Method: Used to retrieve threadSafe driver object
     * by Tests.
     *
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
        logger.info("Killing driver instance");
        getDriver().quit();
    }

    /**
     * Remove threadLocal driver.
     */
    @AfterClass
    public void terminate() {
        //Remove the ThreadLocalMap element
        logger.info("Removing thread.");
        threadSafeDriver.remove();
    }

}
