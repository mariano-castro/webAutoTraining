package com.automation.uitests;

import com.automation.MyDriver;
import com.automation.PageData;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public abstract class BaseTest {

    MyDriver myDriver;
    PageData data;


    @BeforeTest(alwaysRun = true)
    @Parameters({"browser"})
    public void beforeSuite(String browser) {
        myDriver = new MyDriver(browser);
    }

    @AfterTest(alwaysRun = true)
    public void afterSuite() {
        myDriver.disposeDriver();
    }

}
