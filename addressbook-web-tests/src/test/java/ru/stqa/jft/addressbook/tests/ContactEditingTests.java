package ru.stqa.jft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.jft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactEditingTests extends TestBase{

    @BeforeMethod
    public void ensurePreconditions() {
        if (app.contact().list().size() == 0) {
            app.contact().create(new ContactData("FirstTestName1", "LastTestName1", "Some Company", "14801112233", "testmail@test.test", "1", "October", "1991", null), true);
        }
    }

    @Test
    public void testContactEditing() {
        List<ContactData> before = app.contact().list();
        int index = before.size()- 1;
        ContactData contact = new ContactData("EditedFirstName1", "EditedLastName1", "New Some Company", null, "newtestmail@test.test", "5", "January", "1997", null);
        app.contact().edit(index, contact);
        List<ContactData> after = app.contact().list();
        Assert.assertEquals(after.size(), before.size());

        before.remove(index);
        before.add(contact);
        Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);
    }

}