package ru.stqa.jft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.jft.addressbook.model.GroupData;

import java.util.Set;

public class GroupEditingTests extends TestBase{

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().groupPage();
        if (app.group().all().size() == 0) {
            app.group().create(new GroupData().withName("NewTestGroup").withHeader("test1").withFooter("test2"));
        }
    }

    @Test
    public void testGroupEditing() {
        Set<GroupData> before = app.group().all();
        GroupData editedGroup = before.iterator().next();
        GroupData group = new GroupData()
                .withId(editedGroup.getId()).withName("EditedTestGroup").withHeader("editTest1").withFooter("editTest2");
        app.group().edit(group);
        Set<GroupData> after = app.group().all();
        Assert.assertEquals(after.size(), before.size());

        before.remove(editedGroup);
        before.add(group);
        Assert.assertEquals(before, after);
    }
}
