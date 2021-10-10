package ru.stqa.jft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.jft.addressbook.model.GroupData;

import java.util.ArrayList;
import java.util.List;

public class GroupHelper extends HelperBase {

    public GroupHelper(WebDriver wd) {
        super(wd);
    }

    public void returnToGroupPage() {
        click(By.linkText("group page"));
    }

    public void submitGroupCreation() {
        click(By.name("submit"));
    }

    public void fillGroupForm(GroupData groupData) {
        type(By.name("group_name"), groupData.getName());
        type(By.name("group_header"), groupData.getHeader());
        type(By.name("group_footer"), groupData.getFooter());
    }

    public void initGroupCreation() {
        click(By.name("new"));
    }

    public void selectGroup(int index) {
        wd.findElements(By.name("selected[]")).get(index).click();
    }

    public void initGroupDeletion() {
        click(By.name("delete"));
    }

    public void initGroupEditing() {
        click(By.name("edit"));
    }

    public void submitGroupEditing() {
        click(By.name("update"));
    }

    public void create(GroupData group) {
        initGroupCreation();
        fillGroupForm(group);
        submitGroupCreation();
        returnToGroupPage();
    }

    public void edit(int index, GroupData group) {
        selectGroup(index);
        initGroupEditing();
        fillGroupForm(group);
        submitGroupEditing();
        returnToGroupPage();
    }

    public void delete(int index) {
        selectGroup(index);
        initGroupDeletion();
        returnToGroupPage();
    }

    public boolean isThereAGroup(String name) {
        if (name != null) {
            return isElementPresent((By.xpath("//input[@title='Select ("+name+")']")));
        } else {
            return isElementPresent((By.name("selected[]")));
        }
    }

    public List<GroupData> list() {
        List<GroupData> groups = new ArrayList<>();
        List<WebElement> elements = wd.findElements(By.cssSelector("span.group"));
        for (WebElement element : elements) {
            String name = element.getText();
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            GroupData group = new GroupData (id, name, null, null);
            groups.add(group);
        }
        return groups;
    }


    //deprecated
    public void selectGroupByName(String groupName) {
        click(By.xpath("//span[(text()='" + groupName + "')]/input[@type='checkbox']"));
    }

    public int getGroupCount() {
        return wd.findElements(By.name("selected[]")).size();
    }
}