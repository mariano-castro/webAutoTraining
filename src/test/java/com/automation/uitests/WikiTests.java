package com.automation.uitests;

import com.automation.PageData;
import com.automation.pageobjects.ArticlePage;
import com.automation.pageobjects.WikiHomePage;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WikiTests extends BaseTest {

    String expectedTitle = "Java";
    WikiHomePage home1;


    @BeforeMethod(alwaysRun = true)
    public void loadPage(){
        home1 = new WikiHomePage(myDriver.getDriver());
        data = new PageData(WikiTests.class.getSimpleName());
    }

    @Test
    public void search_Correct() {
        ArticlePage articlePage = home1.performSearch(expectedTitle);
        Assert.assertEquals(articlePage.getArticleTitle(), expectedTitle);
    }

    @Test(enabled=false)
    public void pageTitle_Correct() {
        String title = data.get("pageTitle").toString();
        Assert.assertEquals(home1.searchInput.getText(), title);
    }

}
