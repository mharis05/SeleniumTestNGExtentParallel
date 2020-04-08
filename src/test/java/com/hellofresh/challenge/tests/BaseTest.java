package com.hellofresh.challenge.tests;

import com.hellofresh.challenge.driverFactory.DriverFactory;
import com.hellofresh.challenge.driverFactory.DriverType;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.net.MalformedURLException;

public class BaseTest {
    protected WebDriverWait wait;
    protected static ThreadLocal<WebDriver> threadSafeDriver = new ThreadLocal<>();
    SoftAssertions softly;

    @BeforeMethod
    @Parameters(value={"browser"})
    public void setup (String browser) throws MalformedURLException {
        DriverFactory driverFactory = new DriverFactory();
        WebDriver driver = driverFactory.createDriver(DriverType.CHROME);

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
