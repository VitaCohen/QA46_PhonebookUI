package com.phonebook.test;

import com.phonebook.data.ContactData;
import com.phonebook.data.UserData;
import com.phonebook.models.Contact;
import com.phonebook.models.User;
import com.phonebook.utils.DataProviders;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AddContactTests extends TestBase {

    //login

    @BeforeMethod
    public void precondition() {
        if(!app.getUser().isLoginLinkPresent()){
            app.getUser().clickOnSignOutButton();
        }
        //click on Login link
        app.getUser().clickOnLoginLink();
        // enter email
        app.getUser().fillRegisterLoginForm(new User().setMail(UserData.EMAIL).setPassword(UserData.PASSWORD));
        // click on login button
        app.getUser().clicOnLoginButton();

    }

    @Test
    public void addContactPositiveTest() {
        //click on link add
        app.getContact().clickOnAddLink();
        //enter mame
        app.getContact().fillContactForm(new Contact().setName(ContactData.NAME).setLastName(ContactData.LAST_NAME)
                .setPhone(ContactData.PHONE).setEmail(ContactData.EMAIL)
                .setAddress(ContactData.ADDRESS).setDescription(ContactData.DESCRIPTION));
        //click on save button
        app.getContact().clickOnSaveButton();
        // verify contact is added
        Assert.assertTrue(app.getContact().isContactAdded(ContactData.NAME));

    }


    @Test(dataProvider = "addNewContact",dataProviderClass = DataProviders.class)
    public void addContactPositiveFromDataProviderTest(String name,String lastName,
                                                       String phone,String email,
                                                       String address,String description){
        app.getContact().clickOnAddLink();
        app.getContact().fillContactForm(new Contact()
                .setName(name)
                .setLastName(lastName)
                .setPhone(phone)
                .setEmail(email)
                .setAddress(address)
                .setDescription(description));
        app.getContact().clickOnSaveButton();
        Assert.assertTrue(app.getContact().isContactAdded(name));
    }


    @Test(dataProvider = "addNewContactWithCsv", dataProviderClass = DataProviders.class)
    public void addContactPositiveFromDataProviderWithCsvFileTest(Contact contact){
        app.getContact().clickOnAddLink();
        app.getContact().fillContactForm(contact);
        app.getContact().clickOnSaveButton();
        Assert.assertTrue(app.getContact().isContactAdded(contact.getName()));
    }


    @AfterMethod
    public void postCondition() {
        app.getContact().deleteContact();

    }


}
