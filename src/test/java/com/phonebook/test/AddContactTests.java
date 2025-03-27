package com.phonebook.test;

import com.phonebook.models.Contact;
import com.phonebook.models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddContactTests extends TestBase {

    //login

    @BeforeMethod
    public void precondition() {
        //click on Login link
        app.getUser().clickOnLoginLink();
        // enter email
        app.getUser().fillRegisterLoginForm(new User().setMail("com04@gmail.com").setPassword("1234Aa$$$"));
        // click on login button
        app.getUser().clicOnLoginButton();

    }

    @Test
    public void addContactPositiveTest() {
        //click on link add
        app.getContact().clickOnAddLink();
        //enter mame
        app.getContact().fillContactForm(new Contact().setName("Victor").setLastName("Vays")
                .setPhone("1234567890").setEmail("com04@gmail.com")
                .setAddress("Rehovot").setDescription("QA"));
        //click on save button
        app.getContact().clickOnSaveButton();
        // verify contact is added
        Assert.assertTrue(app.getContact().isContactAdded("Victor"));

    }

    @AfterMethod
    public void postCondition() {
        app.getContact().deleteContact();

    }


}
