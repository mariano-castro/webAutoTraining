package com.automation.uitests;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

@Test
public class AutomationTest {

    public String a;
    public String b;
    public String actualResult;
    public String expectedResult = "I hate bugs";


    public void string_Correct(){
        a = "I hate";
        b = " bugs";
        actualResult = a.concat(b);
        Assert.assertEquals(actualResult, expectedResult);
    }



    @Parameters({"stringA", "stringB"})
    public void paramString_Correct(String a, String b){
        actualResult = a.concat(b);
        Assert.assertEquals(actualResult, expectedResult);
    }
}
