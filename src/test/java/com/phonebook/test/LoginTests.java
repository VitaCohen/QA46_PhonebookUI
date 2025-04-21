package com.phonebook.test;

import com.phonebook.data.UserData;
import com.phonebook.models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {


    @BeforeMethod
    public void ensurePrecondition(){
        if(!app.getUser().isLoginLinkPresent()){
            app.getUser().clickOnSignOutButton();
        }
    }
    @Test(priority=2)
    public void loginPositiveTest() {
        logger.info("Login with data --> " +UserData.EMAIL+"****" + UserData.PASSWORD);
        app.getUser().clickOnLoginLink();
        app.getUser().fillRegisterLoginForm(new User().setMail(UserData.EMAIL).setPassword(UserData.PASSWORD));
        app.getUser().clicOnLoginButton();
        Assert.assertTrue(app.getUser().isSignButtonPresent());
    }

    @Test
    public void loginNegativeWithoutEmailTest() {
        app.getUser().clickOnLoginLink();
        app.getUser().fillRegisterLoginForm(new User().setPassword("1234Aa$$$"));
        app.getUser().clicOnLoginButton();
        Assert.assertTrue(app.getUser().isAlertDisplayed());
    }




}
