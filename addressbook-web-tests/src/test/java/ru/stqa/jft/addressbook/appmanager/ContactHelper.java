package ru.stqa.jft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.stqa.jft.addressbook.model.ContactData;

public class ContactHelper extends HelperBase{

    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void initContactCreation() {
        click(By.linkText("add new"));
    }

    public void fillContactForm(ContactData contactData) {
        type(By.name("firstname"), contactData.getFirstname());
        type(By.name("lastname"), contactData.getLastname());
        type(By.name("company"), contactData.getCompany());
        type(By.name("mobile"), contactData.getMobile());
        type(By.name("email"), contactData.getEmail());
        select(By.name("bday"), contactData.getBday());
        select(By.name("bmonth"), contactData.getBmonth());
        type(By.name("byear"), contactData.getByear());
    }

    public void selectContactGroup(ContactData contactData) {
        select(By.name("new_group"), contactData.getContactGroup());
    }

    public void submitContactCreation() {
        click(By.name("submit"));
    }

    public void selectContactByEmail(String email) {
        click(By.cssSelector("input[accept='"+email+"']"));
    }

    public void initContactDeletion() {
        click(By.cssSelector("input[value='Delete']"));
    }

    public void submitContactDeletion() {
        wd.switchTo().alert().accept();
    }
}