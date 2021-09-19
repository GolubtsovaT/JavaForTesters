package ru.stqa.jft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.jft.addressbook.model.ContactData;

public class ContactEditingTests extends TestBase{

    @Test
    public void testContactEditing() {
        app.getContactHelper().initEditingFirstContact();
        app.getContactHelper().fillContactForm(new ContactData("EditedFirstName1", "EditedLastName1", "New Some Company", null, "newtestmail@test.test", "5", "January", "1997", null), false);
        app.getContactHelper().submitContactEditing();
        app.getNavigationHelper().returnToHomePage();
    }
}