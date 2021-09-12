package ru.stqa.jft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.jft.addressbook.model.ContactData;

public class ContactEditingTests extends TestBase{

    @Test
    public void testContactEditing() {
        app.getContactHelper().initContactEditingByEmail("testmail@test.test");
        app.getContactHelper().fillContactForm(new ContactData("EditedFirstName1", "EditedLastName1", "New Some Company", "12051112233", "newtestmail@test.test", "5", "January", "1997", "Golubtsova_TestGroup"));
        app.getContactHelper().submitContactEditing();
        app.getNavigationHelper().returnToHomePage();
    }
}