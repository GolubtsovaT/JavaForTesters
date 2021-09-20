package ru.stqa.jft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.jft.addressbook.model.ContactData;
import ru.stqa.jft.addressbook.model.GroupData;

public class ContactCreationTests extends TestBase{

    @Test
    public void testContactCreation() {
        app.getNavigationHelper().gotoGroupPage();
        if (! app.getGroupHelper().isThereAGroup("Golubtsova_TestGroup")) {
            app.getGroupHelper().createGroup(new GroupData("Golubtsova_TestGroup", null, null));
        }
        app.getNavigationHelper().gotoHomePage();
        int before = app.getContactHelper().getContactCount();
        app.getContactHelper().createContact(new ContactData("FirstTestName1", "LastTestName1", "Some Company", "14801112233", "testmail@test.test", "1", "October", "1991", "Golubtsova_TestGroup"), true);
        int after = app.getContactHelper().getContactCount();
        Assert.assertEquals(after, before + 1);
    }
}
