package ru.stqa.jft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.jft.addressbook.model.GroupData;

import java.util.List;

public class GroupEditingTests extends TestBase{

    @Test
    public void testGroupEditing() {
        app.getNavigationHelper().gotoGroupPage();
        if (! app.getGroupHelper().isThereAGroup(null)) {
            app.getGroupHelper().createGroup(new GroupData("NewTestGroup", "test1", "test2"));
        }
        List<GroupData> before = app.getGroupHelper().getGroupList();
        app.getGroupHelper().selectGroup(1);
        app.getGroupHelper().initGroupEditing();
        app.getGroupHelper().fillGroupForm(new GroupData("EditedTestGroup", "editTest1", "editTest2"));
        app.getGroupHelper().submitGroupEditing();
        app.getGroupHelper().returnToGroupPage();
        List<GroupData> after = app.getGroupHelper().getGroupList();
        Assert.assertEquals(after.size(), before.size());
    }
}
