package ru.stqa.jft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.jft.addressbook.model.ContactData;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactAddressTests extends TestBase{
    @BeforeMethod
    public void ensurePreconditions() {
        if (app.contact().all().size() == 0) {
            app.contact().create(new ContactData()
                    .withFirstname("FirstTestName1").withLastname("LastTestName1").withCompany("Some Company").withAddress("My Address, street N, app. 9/2")
                    .withHome("1(555)11-23").withMobile("14801112233").withWork("+17771112233")
                    .withEmail("testmail@test.test").withEmail2("testmail2@test.test").withEmail3("3testmail@test.test")
                    .withBday("1").withBmonth("October").withByear("1991"), true);
        }
    }

    @Test
    public void testContactAddresses(){
        app.goTo().homePage();
        ContactData contact = app.contact().all().iterator().next();
        ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);

        assertThat(contact.getAddress(), equalTo(contactInfoFromEditForm.getAddress()));
    }
}
