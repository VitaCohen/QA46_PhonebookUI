package com.phonebook.test;

import com.phonebook.models.User;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CreateAccountTests extends TestBase{

SoftAssert softAssert = new SoftAssert();
    @Test(enabled = false)
    public void newUserRegistrationPositiveTest(){
        int i =(int)((System.currentTimeMillis()/1000)%3600);
        app.getUser().clickOnLoginLink();
        app.getUser().fillRegisterLoginForm(new User().setMail("com04@gmail.com").setPassword("1234Aa$$$"));
        app.getUser().clickOnRegistrationButton();
       // Assert.assertTrue(isAlertDisplayed());
        //verify SignOut button is displayd
       Assert.assertTrue(app.getUser().isSignButtonPresent());


    }

    @Test
    public void existedUserRegistrationNegativeTest(){
        app.getUser().clickOnLoginLink();
        app.getUser().fillRegisterLoginForm(new User().setMail("com04@gmail.com").setPassword("1234Aa$$$"));
        app.getUser().clickOnRegistrationButton();
        softAssert.assertTrue(app.getUser().isAlertDisplayed());
        softAssert.assertTrue(app.getUser().isErrorMessagePresent());
        softAssert.assertAll();
    }


}









