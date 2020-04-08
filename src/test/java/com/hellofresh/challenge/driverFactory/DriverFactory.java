package com.hellofresh.challenge.driverFactory;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.concurrent.TimeUnit;

import static com.hellofresh.challenge.driverFactory.DriverType.CHROME;
import static com.hellofresh.challenge.driverFactory.DriverType.FIREFOX;

public class DriverFactory {

    private RemoteWebDriver driver;

    public RemoteWebDriver createDriver(DriverType type) {
        switch (type) {
            case CHROME:
                System.setProperty("webdriver.chrome.driver", "src/test/resources/driverBinaries/chromedriver");
                driver = new ChromeDriver();
                break;
            case FIREFOX:
                System.setProperty("webdriver.gecko.driver", "src/test/resources/driverBinaries/geckodriver");
                driver = new FirefoxDriver();
        }
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS );
        driver.manage().window().maximize();

        // Since the target website is horribly slow, increasing page load timeout.
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

        return driver;

    }
}