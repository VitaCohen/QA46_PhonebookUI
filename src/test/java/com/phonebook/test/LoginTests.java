package com.phonebook.test;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

    @Test
    public void loginPositiveTest() {
        clickOnLoginLink();
        fillRegisterLoginForm(new User().setMail("com04@gmail.com").setPassword("1234Aa$$$"));
        clicOnLoginButton();
        Assert.assertTrue(isSignButtonPresent());
    }

    @Test
    public void loginNegativeWithoutEmailTest() {
        clickOnLoginLink();
        fillRegisterLoginForm(new User().setPassword("1234Aa$$$"));
        clicOnLoginButton();
        Assert.assertTrue(isAlertDisplayed());
    }




}
