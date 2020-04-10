package com.hellofresh.challenge.tests;

import com.hellofresh.challenge.driverFactory.DriverFactory;
import com.hellofresh.challenge.utils.PropertyReader;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;


import java.net.MalformedURLException;


/**
 * BaseTest class for setting up Thread safe Driver Factory and Test hooks
 * Also receives parameters from testng.xml
 */
public class BaseTest {
    protected static ThreadLocal<WebDriver> threadSafeDriver = new ThreadLocal<>();
    private static final Logger logger = LogManager.getLogger(BaseTest.class);

    @BeforeMethod
    @Parameters(value = {"browser"})
    public void setup(String browser, ITestContext context) {

        // When not running via mvn, use the browser from testng.xml,
        // otherwise use the browser specified in mvn argument
        if(System.getProperty("browser") != null) {
            browser = System.getProperty("browser");
        };

        logger.info("Creating threadsafe driver instance for: " + browser);
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
