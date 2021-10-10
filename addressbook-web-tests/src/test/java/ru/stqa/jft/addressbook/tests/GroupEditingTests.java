package ru.stqa.jft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.jft.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;

public class GroupEditingTests extends TestBase{

    @Test
    public void testGroupEditing() {
        app.getNavigationHelper().gotoGroupPage();
        if (! app.getGroupHelper().isThereAGroup(null)) {
            app.getGroupHelper().createGroup(new GroupData("NewTestGroup", "test1", "test2"));
        }
        List<GroupData> before = app.getGroupHelper().getGroupList();
        app.getGroupHelper().selectGroup(before.size()- 1);
        app.getGroupHelper().initGroupEditing();
        GroupData group = new GroupData (before.get(before.size()- 1).getId(),"EditedTestGroup", "editTest1", "editTest2");
        app.getGroupHelper().fillGroupForm(group);
        app.getGroupHelper().submitGroupEditing();
        app.getGroupHelper().returnToGroupPage();
        List<GroupData> after = app.getGroupHelper().getGroupList();
        Assert.assertEquals(after.size(), before.size());

        before.remove(before.size() - 1);
        before.add(group);
        Comparator<? super GroupData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);
    }
}
