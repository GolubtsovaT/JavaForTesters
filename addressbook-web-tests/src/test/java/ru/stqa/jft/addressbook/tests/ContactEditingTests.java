package ru.stqa.jft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.jft.addressbook.model.ContactData;

public class ContactEditingTests extends TestBase{

    @Test
    public void testContactEditing() {
        if (! app.getContactHelper().isThereAContact()){
            app.getContactHelper().createContact(new ContactData("FirstTestName1", "LastTestName1", "Some Company", "14801112233", "testmail@test.test", "1", "October", "1991", null), true);
        }
        app.getContactHelper().initEditingFirstContact();
        app.getContactHelper().fillContactForm(new ContactData("EditedFirstName1", "EditedLastName1", "New Some Company", null, "newtestmail@test.test", "5", "January", "1997", null), false);
        app.getContactHelper().submitContactEditing();
        app.getContactHelper().returnToHomePage();
    }
}