package ru.stqa.jft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.jft.addressbook.model.GroupData;

public class GroupEditingTests extends TestBase{

    @Test
    public void testGroupEditing() {
        app.getNavigationHelper().gotoGroupPage();
        app.getGroupHelper().selectGroupByName("NewTestGroup");
        app.getGroupHelper().initGroupEditing();
        app.getGroupHelper().fillGroupForm(new GroupData("EditedTestGroup", "editTest1", "editTest2"));
        app.getGroupHelper().submitGroupEditing();
        app.getGroupHelper().returnToGroupPage();
    }
}
