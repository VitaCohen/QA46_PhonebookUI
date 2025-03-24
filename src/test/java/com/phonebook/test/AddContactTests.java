package com.phonebook.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddContactTests extends TestBase {

    //login

    @BeforeMethod
    public void precondition() {
        //click on Login link
        clickOnLoginLink();
        // enter email
        fillRegisterLoginForm(new User().setMail("com04@gmail.com").setPassword("1234Aa$$$"));
        // click on login button
        clicOnLoginButton();

    }

    @Test
    public void addContactPositiveTest() {
        //click on link add
        clickOnAddLink();
        //enter mame
        fillContactForm(new Contact().setName("Victor").setLastName("Vays")
                .setPhone("1234567890").setEmail("com04@gmail.com")
                .setAddress("Rehovot").setDescription("QA"));
        //click on save button
        clickOnSaveButton();
        // verify contact is added
        Assert.assertTrue(isContactAdded("Victor"));

    }

    @AfterMethod
    public void postCondition() {
        deleteContact();

    }


}
