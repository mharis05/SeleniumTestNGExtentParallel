package com.hellofresh.challenge.driverFactory;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

public class DriverFactory {

    private RemoteWebDriver driver;

    public RemoteWebDriver createDriver(String type) {
        DriverType browser = DriverType.valueOf(type.toUpperCase().trim());

        switch (browser) {
            case CHROME:
                System.setProperty("webdriver.chrome.driver", "src/test/resources/driverBinaries/chromedriver");
                driver = new ChromeDriver();
                System.setProperty("webdriver.chrome.silentOutput", "true");
                break;
            case FIREFOX:
                System.setProperty("webdriver.gecko.driver", "src/test/resources/driverBinaries/geckodriver");
                driver = new FirefoxDriver();
                break;
            case SAFARI:
                System.setProperty("selenium.webdriver.safari.webdriver", "/usr/bin/safaridriver");
                driver = new SafariDriver();
        }
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS );
        driver.manage().window().maximize();

        // Since the target website is horribly slow, increasing page load timeout.
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

        java.util.logging.Logger.getLogger("org.openqa.selenium").setLevel(Level.OFF);
        return driver;
    }
}