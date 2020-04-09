package com.hellofresh.challenge.utils;

import org.testng.annotations.DataProvider;
import java.util.HashMap;

/**
 * Data Provider class
 * Generates/ Initializes named test data for TestNG tests.
 */
public class TestDataProvider {

    private static HashMap<String, String> userData = new HashMap<String, String>() {
        {
            put("email", "hf_challenge_123456@hf123456.com");
            put("password", "12345678");
            put("fullName", "Joe Black");
        }
    };

    /**
     * Data provider that generates Fake data at run time for
     * User Registration
     * @return UserAccount object.
     */
    @DataProvider(name = "account-data-provider", parallel = true)
    public static Object[][] dataProviderMethod() {
        return new Object[][]{
                // Create data from POJO
                {
                        new UserAccount()
                }
        };
    }

    /**
     * Data provider that returns existing user data
     * @return HashMap userData
     */
    @DataProvider(name = "existing-user-provider", parallel = true)
    public static Object[][] existingUserProvider() {
        return new Object[][]{
                {userData}
        };
    }

    /**
     * Data provider that returns product name
     * @return product name String
     */
    @DataProvider(name = "product-data-provider", parallel = true)
    public static Object[][] productDataProvider() {
        return new Object[][]{
                {userData, "Faded Short Sleeve T-shirts"}
        };
    }
}


