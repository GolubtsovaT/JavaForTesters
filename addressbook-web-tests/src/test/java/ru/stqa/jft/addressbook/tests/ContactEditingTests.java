package ru.stqa.jft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.jft.addressbook.model.ContactData;
import ru.stqa.jft.addressbook.model.Contacts;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactEditingTests extends TestBase{

    @BeforeMethod
    public void ensurePreconditions() {
        if (app.contact().all().size() == 0) {
            app.contact().create(new ContactData()
                    .withFirstname("FirstTestName1").withLastname("LastTestName1").withCompany("Some Company")
                    .withMobile("14801112233").withEmail("testmail@test.test").withBday("1").withBmonth("October").withByear("1991"), true);
        }
    }

    @Test
    public void testContactEditing() {
        Contacts before = app.contact().all();
        ContactData editedContact = before.iterator().next();
        ContactData contact = new ContactData()
                .withId(editedContact.getId()).withFirstname("EditedFirstName1").withLastname("EditedLastName1").withCompany("New Some Company")
                .withEmail("newtestmail@test.test").withBday("5").withBmonth("January").withByear("1997");
        app.contact().edit(contact);
        Contacts after = app.contact().all();
        assertEquals(after.size(), before.size());
        assertThat(after, CoreMatchers.equalTo(before.without(editedContact).withAdded(contact)));
    }
}