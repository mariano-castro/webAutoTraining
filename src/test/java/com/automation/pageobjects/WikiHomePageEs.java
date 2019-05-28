package com.automation.pageobjects;

import com.automation.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class WikiHomePageEs extends BasePage {

    public WikiHomePageEs(WebDriver driver){
        super(driver);
        driver.get("https://es.wikipedia.org/wiki/Wikipedia:Portada");
    }

    @FindBy(id = "searchInput")
    public WebElement searchInput;

    @FindBy(xpath = "//button[@class='pure-button pure-button-primary-progressive']")
    private WebElement searchButton;

    @FindBy(css = ".wb-otherproject-link")
    public List<WebElement> actualProjectTitles;

    public ArticlePage performSearch(String keyword){
        searchInput.sendKeys(keyword);
        //getWait().until(ExpectedConditions.elementToBeClickable(searchButton));
        searchButton.click();
        return new ArticlePage(getDriver());
    }

}
