package com.phonebook.test;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTests extends TestBase{


    @Test
    public void isHomeComponentPresentTest(){
        // driver.findElements(By.cssSelector("div:nth-child(2)>div>div>h1"));
        //System.out.println("Home Component "+isHomeComponentPresent());
        Assert.assertTrue(isHomeComponentPresent());

    }


}
