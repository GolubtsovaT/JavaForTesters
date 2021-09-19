package ru.stqa.jft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import ru.stqa.jft.addressbook.model.ContactData;

public class ContactHelper extends HelperBase{

    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void returnToHomePage() {
        click(By.linkText("home page"));
    }

    public void initContactCreation() {
        click(By.linkText("add new"));
    }

    public void fillContactForm(ContactData contactData, boolean creation) {
        type(By.name("firstname"), contactData.getFirstname());
        type(By.name("lastname"), contactData.getLastname());
        type(By.name("company"), contactData.getCompany());
        type(By.name("mobile"), contactData.getMobile());
        type(By.name("email"), contactData.getEmail());
        select(By.name("bday"), contactData.getBday());
        select(By.name("bmonth"), contactData.getBmonth());
        type(By.name("byear"), contactData.getByear());
        if (creation) {
            select(By.name("new_group"), contactData.getContactGroup());
        } else {
            Assert.assertFalse(isElementPresent(By.name("new_group")), "Field 'Group' is detected");
        }
    }

    public void submitContactCreation() {
        click(By.name("submit"));
    }

    public void selectFirstContact() {
        click(By.cssSelector(".center > input"));
    }

    public void initContactDeletion() {
        click(By.cssSelector("input[value='Delete']"));
    }

    public void submitContactDeletion() {
        wd.switchTo().alert().accept();
    }

    public void initEditingFirstContact() {
        click(By.cssSelector(".center [title=Edit]"));
    }

    public void submitContactEditing() {
        click(By.name("update"));
    }

    public void createContact(ContactData contact, boolean creation) {
        initContactCreation();
        fillContactForm(contact, creation);
        submitContactCreation();
        returnToHomePage();
    }

    public boolean isThereAContact() {
        return isElementPresent((By.cssSelector(".center > input")));
    }

    //deprecated
    public void initEditingContactByEmail(String email) {
        click(By.xpath("//td[contains(.,'"+email+"')]/..//*[@title='Edit']/.."));
    }

    public void selectContactByEmail(String email) {
        click(By.cssSelector("input[accept='"+email+"']"));
    }
}