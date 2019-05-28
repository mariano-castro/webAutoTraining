package com.automation.uitests;

import com.automation.MyDriver;
import com.automation.PageData;
import com.automation.pageobjects.WikiHomePage;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Set;

public abstract class BaseTest {

    MyDriver myDriver;
    PageData data;


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
