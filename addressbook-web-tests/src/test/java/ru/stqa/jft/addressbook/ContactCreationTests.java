package ru.stqa.jft.addressbook;

import org.testng.annotations.*;

public class ContactCreationTests extends TestBase{

    @Test
    public void testContactCreation() {
        initContactCreation();
        fillContactForm(new ContactData("FirstTestName1", "LastTestName1", "Some Company", "14801112233", "testmail@test.test", "1", "October", "1991"));
        selectContactGroup();
        submitContactCreation();
        gotoHomePage();
    }
}
