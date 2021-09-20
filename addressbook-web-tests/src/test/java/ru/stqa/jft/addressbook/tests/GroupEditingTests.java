package ru.stqa.jft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.jft.addressbook.model.GroupData;

public class GroupEditingTests extends TestBase{

    @Test
    public void testGroupEditing() {
        app.getNavigationHelper().gotoGroupPage();
        if (! app.getGroupHelper().isThereAGroup(null)) {
            app.getGroupHelper().createGroup(new GroupData("NewTestGroup", "test1", "test2"));
        }
        int before = app.getGroupHelper().getGroupCount();
        app.getGroupHelper().selectGroup(1);
        app.getGroupHelper().initGroupEditing();
        app.getGroupHelper().fillGroupForm(new GroupData("EditedTestGroup", "editTest1", "editTest2"));
        app.getGroupHelper().submitGroupEditing();
        app.getGroupHelper().returnToGroupPage();
        int after = app.getGroupHelper().getGroupCount();
        Assert.assertEquals(after, before);
    }
}
