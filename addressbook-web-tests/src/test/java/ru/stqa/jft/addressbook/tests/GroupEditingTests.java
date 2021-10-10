package ru.stqa.jft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.jft.addressbook.model.GroupData;
import ru.stqa.jft.addressbook.model.Groups;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

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
        Groups before = app.group().all();
        GroupData editedGroup = before.iterator().next();
        GroupData group = new GroupData()
                .withId(editedGroup.getId()).withName("EditedTestGroup").withHeader("editTest1").withFooter("editTest2");
        app.group().edit(group);
        Groups after = app.group().all();
        assertEquals(after.size(), before.size());
        assertThat(after, CoreMatchers.equalTo(before.without(editedGroup).withAdded(group)));
    }
}
