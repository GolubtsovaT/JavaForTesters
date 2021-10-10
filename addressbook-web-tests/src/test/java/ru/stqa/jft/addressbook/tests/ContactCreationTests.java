package ru.stqa.jft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.jft.addressbook.model.ContactData;
import ru.stqa.jft.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;

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
        List<ContactData> before = app.contact().list();
        ContactData contact = new ContactData()
                .withFirstname("FirstTestName1").withLastname("LastTestName1").withCompany("Some Company")
                .withMobile("14801112233").withEmail("testmail@test.test").withBday("1").withBmonth("October").withByear("1991").withGroup("Golubtsova_TestGroup");
        app.contact().create(contact, true);
        List<ContactData> after = app.contact().list();
        Assert.assertEquals(after.size(), before.size() + 1);

        before.add(contact);
        Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);
    }
}
