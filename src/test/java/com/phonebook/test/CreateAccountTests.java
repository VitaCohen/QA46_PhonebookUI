package com.phonebook.test;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase{


    @Test(enabled = false)
    public void newUserRegistrationPositiveTest(){
        //click on Login link
        click(By.cssSelector("[href='/login']"));

        // enter email
        type(By.name("email"), "com04@gmail.com");

        // enter password
        type(By.name("password"), "1234Aa$$$");

        // click on Registration button
        click(By.name("registration"));

        // verify SignOut button is displayed
        Assert.assertTrue(isElementPresent(By.xpath("//button[.='Sign Out']")));


    }

    @Test
    public void existedUserRegistrationNegativeTest(){
        //click on Login link
        click(By.cssSelector("[href='/login']"));

        // enter email
        type(By.name("email"), "com04@gmail.com");

        // enter password
        type(By.name("password"), "1234Aa$$$");

        // clickm Registration button
        click(By.name("registration"));

        // verify Alert is displayed
        Assert.assertTrue(isAlertDisplayed());


    }


}









