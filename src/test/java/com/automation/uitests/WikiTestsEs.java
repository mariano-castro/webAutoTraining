package com.automation.uitests;

import com.automation.PageData;
import com.automation.pageobjects.WikiHomePageEs;
import org.json.simple.JSONArray;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;

public class WikiTestsEs extends BaseTest {

    WikiHomePageEs home;


    @BeforeMethod
    public void loadPage(){
        home = new WikiHomePageEs(myDriver.getDriver());
        data = new PageData(WikiTests.class.getSimpleName());
        ensurePage();

    }

    private void ensurePage() {
        if (myDriver.getDriver().getCurrentUrl() != "https://es.wikipedia.org/wiki/Wikipedia:Portada") {
            myDriver.getDriver().get("https://es.wikipedia.org/wiki/Wikipedia:Portada");
        }
    }

    private void selectLanguage() {
        //home.spanishLink().click();
    }


    @Test
    public void leftColumnProjects_Displayed() {
        selectLanguage();
        Assert.assertNotEquals(home.actualProjectTitles.size(), 0, "List came empty");
        for (int i=0; i < home.actualProjectTitles.size(); i++){
            Assert.assertTrue(home.actualProjectTitles.get(i).isDisplayed(), "The element at index "+i+"was not displayed");

        }
    }


    @Test
    public void leftColumnProjects_Correct() {
        selectLanguage();
        Object[] jsonTitles = ((JSONArray) data.get("expectedProjectTitles")).toArray();
        String[] projectTitles = Arrays.copyOf(jsonTitles, jsonTitles.length, String[].class);
        Assert.assertNotEquals(home.actualProjectTitles.size(), 0, "List came empty");
        for (int i = 0; i < home.actualProjectTitles.size(); i++) {

            Assert.assertEquals(home.actualProjectTitles.get(i).getText(), projectTitles[i]);
        }
    }
}