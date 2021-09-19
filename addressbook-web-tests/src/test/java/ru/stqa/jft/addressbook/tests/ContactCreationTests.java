package ru.stqa.jft.addressbook.tests;

import org.testng.annotations.*;
import ru.stqa.jft.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase{

    @Test
    public void testContactCreation() {
        app.getContactHelper().initContactCreation();
        app.getContactHelper().fillContactForm(new ContactData("FirstTestName1", "LastTestName1", "Some Company", "14801112233", "testmail@test.test", "1", "October", "1991", "Golubtsova_TestGroup"), true);
        app.getContactHelper().submitContactCreation();
        app.getNavigationHelper().returnToHomePage();
    }
}
