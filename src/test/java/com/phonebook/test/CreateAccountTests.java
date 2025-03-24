package com.phonebook.test;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase{


    @Test(enabled = false)
    public void newUserRegistrationPositiveTest(){
        int i =(int)((System.currentTimeMillis()/1000)%3600);
        clickOnLoginLink();
        fillRegisterLoginForm(new User().setMail("com04@gmail.com").setPassword("1234Aa$$$"));
        clickOnRegistrationButton();
       // Assert.assertTrue(isAlertDisplayed());
        //verify SignOut button is displayd
       Assert.assertTrue(isSignButtonPresent());


    }

    @Test
    public void existedUserRegistrationNegativeTest(){
        clickOnLoginLink();
        fillRegisterLoginForm(new User().setMail("com04@gmail.com").setPassword("1234Aa$$$"));
        clickOnRegistrationButton();
        Assert.assertTrue(isAlertDisplayed());


    }


}









