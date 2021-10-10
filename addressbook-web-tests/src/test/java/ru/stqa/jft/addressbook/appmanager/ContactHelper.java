package ru.stqa.jft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import ru.stqa.jft.addressbook.model.ContactData;

import java.util.ArrayList;
import java.util.List;

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

    public void selectContact(int index) {
        wd.findElements(By.cssSelector(".center > input")).get(index).click();
    }

    public void initContactDeletion() {
        click(By.cssSelector("input[value='Delete']"));
    }

    public void submitContactDeletion() {
        wd.switchTo().alert().accept();
    }

    public void initEditingContact(int index) {
        wd.findElements(By.cssSelector(".center [title=Edit]")).get(index).click();
    }

    public void submitContactEditing() {
        click(By.name("update"));
    }

    public void create(ContactData contact, boolean creation) {
        initContactCreation();
        fillContactForm(contact, creation);
        submitContactCreation();
        returnToHomePage();
    }

    public void edit(int index, ContactData contact) {
       initEditingContact(index);
        fillContactForm(contact, false);
        submitContactEditing();
        returnToHomePage();
    }

    public void delete(int index) {
        selectContact(index);
        initContactDeletion();
        submitContactDeletion();
    }

    public List<ContactData> list() {
        List<ContactData> contacts = new ArrayList<>();
        List<WebElement> elements = wd.findElements(By.name("entry"));
        for (WebElement element : elements) {
            String firstname = element.findElement(By.cssSelector("td:nth-child(3)")).getText();
            String lastname = element.findElement(By.cssSelector("td:nth-child(2)")).getText();
            int id = Integer.parseInt(element.findElement(By.cssSelector(".center > input")).getAttribute("value"));
            contacts.add(new ContactData().withId(id).withFirstname(firstname).withLastname(lastname));
        }
        return contacts;
    }

    //deprecated
    public void initEditingContactByEmail(String email) {
        click(By.xpath("//td[contains(.,'"+email+"')]/..//*[@title='Edit']/.."));
    }

    public void selectContactByEmail(String email) {
        click(By.cssSelector("input[accept='"+email+"']"));
    }

    public int getContactCount() {
        return wd.findElements(By.cssSelector(".center > input")).size();
    }

    public boolean isThereAContact() {
        return isElementPresent((By.cssSelector(".center > input")));
    }
}