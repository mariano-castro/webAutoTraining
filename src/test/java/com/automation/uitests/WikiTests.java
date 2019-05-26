package com.automation.uitests;

import com.automation.PageData;
import com.automation.pageobjects.ArticlePage;
import com.automation.pageobjects.WikiHomePage;
import com.google.gson.JsonArray;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import org.json.simple.JSONArray;

import java.util.Arrays;

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
    public void leftColumnProjects_Correct() {
        Object[] jsonHeaders = ((JSONArray) data.get("includedGroups")).toArray();
        String[] expectedHeaders = Arrays.copyOf(jsonHeaders, jsonHeaders.length, String[].class);
        System.out.println(expectedHeaders[1]);
    }


}
