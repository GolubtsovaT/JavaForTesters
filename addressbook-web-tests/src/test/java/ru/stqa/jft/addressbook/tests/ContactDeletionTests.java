package ru.stqa.jft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.jft.addressbook.model.ContactData;

public class ContactDeletionTests extends TestBase {

    @Test
    public void testContactDeletion() {
        if (! app.getContactHelper().isThereAContact()){
            app.getContactHelper().createContact(new ContactData("FirstTestName1", "LastTestName1", "Some Company", "14801112233", "testmail@test.test", "1", "October", "1991", null), true);
        }
        int before = app.getContactHelper().getContactCount();
        app.getContactHelper().selectContact(before - 1);
        app.getContactHelper().initContactDeletion();
        app.getContactHelper().submitContactDeletion();
        app.getNavigationHelper().gotoHomePage();
        int after = app.getContactHelper().getContactCount();
        Assert.assertEquals(after, before - 1);
    }
}