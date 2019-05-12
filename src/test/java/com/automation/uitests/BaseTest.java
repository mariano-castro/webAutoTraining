package com.automation.uitests;

import com.automation.MyDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

public abstract class BaseTest {

    MyDriver myDriver;

    @BeforeSuite(alwaysRun = true)
    @Parameters({"browser"})
    public void beforeSuite(String browser) {
        myDriver = new MyDriver(browser);
    }

    @AfterSuite(alwaysRun = true)
    public void afterSuite() {
        myDriver.disposeDriver();
    }

}
