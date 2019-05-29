package com.automation;

import org.testng.annotations.AfterSuite;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.nio.file.Paths;

public class MyDriver {

    private WebDriver driver;

    public MyDriver(String browser) {
        switch (browser) {
            case "firefox":
                System.setProperty("webdriver.gecko.driver", Paths.get("src\\test\\Resources\\drivers\\geckodriver.exe").toAbsolutePath().toString());
                driver = new FirefoxDriver();
                break;
            case "chrome":
                System.setProperty("webdriver.chrome.driver", Paths.get("src\\test\\Resources\\drivers\\chromedriver.exe").toAbsolutePath().toString());
                driver = new ChromeDriver();
                break;
            default:
                break;
        }
    }

    public WebDriver getDriver() {
        return this.driver;
    }

    @AfterSuite(alwaysRun = true)
    public void disposeDriver(){
        if (driver != null)
            driver.quit();
    }
}
