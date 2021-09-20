package ru.stqa.jft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.jft.addressbook.model.ContactData;

public class ContactEditingTests extends TestBase{

    @Test
    public void testContactEditing() {
        if (! app.getContactHelper().isThereAContact()){
            app.getContactHelper().createContact(new ContactData("FirstTestName1", "LastTestName1", "Some Company", "14801112233", "testmail@test.test", "1", "October", "1991", null), true);
        }
        int before = app.getContactHelper().getContactCount();
        app.getContactHelper().initEditingContact(1);
        app.getContactHelper().fillContactForm(new ContactData("EditedFirstName1", "EditedLastName1", "New Some Company", null, "newtestmail@test.test", "5", "January", "1997", null), false);
        app.getContactHelper().submitContactEditing();
        app.getContactHelper().returnToHomePage();
        int after = app.getContactHelper().getContactCount();
        Assert.assertEquals(after, before);
    }
}