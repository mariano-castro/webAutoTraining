package com.automation.uitests;

import com.automation.PageData;
import com.automation.pageobjects.ArticlePage;
import com.automation.pageobjects.WikiHomePage;
import com.google.gson.JsonArray;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import org.json.simple.JSONArray;
import org.openqa.selenium.WebElement;

import java.util.Arrays;
import java.util.List;

public class WikiTests extends BaseTest {

    String expectedTitle = "Java";
    WikiHomePage home;


    @BeforeMethod
    public void loadPage(){
        home = new WikiHomePage(myDriver.getDriver());
        data = new PageData(WikiTests.class.getSimpleName());
    }

    @Test
    public void search_Correct() {
        ArticlePage articlePage = home.performSearch(expectedTitle);
        Assert.assertEquals(articlePage.getArticleTitle(), expectedTitle);
    }

    @Test
    public void leftColumnProjects_Displayed() {
        Object[] jsonTitles = ((JSONArray) data.get("expectedProjectTitles")).toArray();
        String[] projectTitles = Arrays.copyOf(jsonTitles, jsonTitles.length, String[].class);
        Assert.assertNotEquals(home.actualProjectTitles.size(), 0, "List came empty");
        for (int i=0; i < home.actualProjectTitles.size(); i++){
            Assert.assertTrue(home.actualProjectTitles.get(i).isDisplayed(), "The element at index "+i+"was not displayed");

        }
    }

    @Test
    public void pageTitle_Correct() {
        String title = data.get("pageTitle").toString();
        Assert.assertEquals(home.searchInput.getText(), title);
    }

}
