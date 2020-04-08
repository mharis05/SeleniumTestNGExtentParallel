package com.hellofresh.challenge.utils;

import org.testng.annotations.DataProvider;

public class TestDataProvider {
    @DataProvider(name = "account-data-provider", parallel = true)
    public static Object[][] dataProviderMethod() {
        return new Object[][]{
                // Create data from POJO
                {
                    new UserAccount()
                }
        };
    }

}
