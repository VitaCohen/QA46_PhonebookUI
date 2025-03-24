package com.phonebook.test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DeleteContactTests extends TestBase {

    // precondition
    @BeforeMethod
    public void precondition(){
        //click on Login link
        clickOnLoginLink();
        // enter email
        fillRegisterLoginForm(new User().setMail("com04@gmail.com").setPassword("1234Aa$$$"));
        // click on login button
        clicOnLoginButton();

        //add
        //click on link add
        clickOnAddLink();
        //enter mame
        fillContactForm(new Contact().setName("Victor").setLastName("Vays")
                .setPhone("1234567890").setEmail("com04@gmail.com")
                .setAddress("Rehovot").setDescription("QA"));
        //click on save button
        clickOnSaveButton();
    }

    @Test
    public void deleteContactTest(){
        int sizeBefore = sizeOfCotacts();
        // click on the cart
        deleteContact();
        pause(1000);
        int sizeAfter = sizeOfCotacts();
        Assert.assertEquals(sizeAfter, sizeBefore-1);
    }


}
