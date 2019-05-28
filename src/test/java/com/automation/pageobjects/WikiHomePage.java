package com.automation.pageobjects;

import com.automation.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WikiHomePage extends BasePage {

    public WikiHomePage(WebDriver driver){
        super(driver);
        driver.get("https://www.wikipedia.org/");
    }

    @FindBy(id = "searchInput")
    public WebElement searchInput;

    @FindBy(xpath = "//button[@class='pure-button pure-button-primary-progressive']")
    private WebElement searchButton;

    public ArticlePage performSearch(String keyword){
        searchInput.sendKeys(keyword);
        //getWait().until(ExpectedConditions.elementToBeClickable(searchButton));
        searchButton.click();
        return new ArticlePage(getDriver());
    }

}
