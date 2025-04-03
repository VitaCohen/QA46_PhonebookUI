package com.phonebook.test;

import com.phonebook.models.Contact;
import com.phonebook.models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DeleteContactTests extends TestBase {

    // precondition
    @BeforeMethod
    public void precondition(){
        if(!app.getUser().isLoginLinkPresent()){
            app.getUser().clickOnSignOutButton();
        }
        //click on Login link
        app.getUser().clickOnLoginLink();
        // enter email
        app.getUser().fillRegisterLoginForm(new User().setMail("com04@gmail.com").setPassword("1234Aa$$$"));
        // click on login button
        app.getUser().clicOnLoginButton();

        //add
        //click on link add
        app.getContact().clickOnAddLink();
        //enter mame
        app.getContact().fillContactForm(new Contact().setName("Victor").setLastName("Vays")
                .setPhone("1234567890").setEmail("com04@gmail.com")
                .setAddress("Rehovot").setDescription("QA"));
        //click on save button
        app.getContact().clickOnSaveButton();
    }

    @Test
    public void deleteContactTest(){
        int sizeBefore = app.getContact().sizeOfCotacts();
        // click on the cart
        app.getContact().deleteContact();
        app.getContact().pause(1000);
        int sizeAfter = app.getContact().sizeOfCotacts();
        Assert.assertEquals(sizeAfter, sizeBefore-1);
    }


}
