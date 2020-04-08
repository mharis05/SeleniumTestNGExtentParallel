package com.hellofresh.challenge.utils;

import org.testng.annotations.DataProvider;

import java.util.HashMap;
import java.util.Iterator;

public class TestDataProvider {
    @DataProvider(name = "account-data-provider")
    public static Object[][] dataProviderMethod() {
        return new Object[][]{
                // Create data from POJO
                {
                    new UserAccount()
                }
        };
    }

}
