package ru.stqa.jft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.jft.addressbook.model.ContactData;
import ru.stqa.jft.addressbook.model.GroupData;

import java.util.Set;

public class ContactCreationTests extends TestBase{

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().groupPage();
        if (! app.group().isThereAGroup("Golubtsova_TestGroup")) {
            app.group().create(new GroupData().withName("Golubtsova_TestGroup"));
        }
    }

    @Test
    public void testContactCreation() {
        app.goTo().homePage();
        Set<ContactData> before = app.contact().all();
        ContactData contact = new ContactData()
                .withFirstname("FirstTestName1").withLastname("LastTestName1").withCompany("Some Company")
                .withMobile("14801112233").withEmail("testmail@test.test").withBday("1").withBmonth("October").withByear("1991").withGroup("Golubtsova_TestGroup");
        app.contact().create(contact, true);
        Set<ContactData> after = app.contact().all();
        Assert.assertEquals(after.size(), before.size() + 1);

        contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt());
        before.add(contact);
        Assert.assertEquals(before, after);
    }
}
