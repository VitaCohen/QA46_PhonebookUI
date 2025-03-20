package com.phonebook.test;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

    @Test
    public void loginPositiveTest() {
       //click on Login link
        click(By.cssSelector("[href='/login']"));

        // enter email
        type(By.name("email"), "com04@gmail.com");

        // enter password
        type(By.name("password"), "1234Aa$$$");

        // click on login button
        click(By.name("login"));

        // verify SignOut button is displayed
        Assert.assertTrue(isElementPresent(By.xpath("//button[.='Sign Out']")));
    }


}
