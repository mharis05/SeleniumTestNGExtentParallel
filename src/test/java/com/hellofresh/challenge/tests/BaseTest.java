package com.hellofresh.challenge.tests;

import com.hellofresh.challenge.driverFactory.DriverFactory;
import com.hellofresh.challenge.driverFactory.DriverType;

import org.openqa.selenium.WebDriver;

import org.testng.annotations.*;


import java.net.MalformedURLException;

public class BaseTest {
    protected static ThreadLocal<WebDriver> threadSafeDriver = new ThreadLocal<>();

    @BeforeMethod
    @Parameters(value={"browser"})
    public void setup (String browser) throws MalformedURLException {
        DriverFactory driverFactory = new DriverFactory();
        WebDriver driver = driverFactory.createDriver(browser);

        //Set Browser to ThreadLocalMap
        threadSafeDriver.set(driver);
        threadSafeDriver.get().get("http://automationpractice.com/index.php");
    }

    public WebDriver getDriver() {
        //Get driver from ThreadLocalMap
        return threadSafeDriver.get();
    }

    @AfterMethod
    public void tearDown() {
        getDriver().quit();
    }

    @AfterClass
    public void terminate () {
        //Remove the ThreadLocalMap element
        threadSafeDriver.remove();
    }

}
