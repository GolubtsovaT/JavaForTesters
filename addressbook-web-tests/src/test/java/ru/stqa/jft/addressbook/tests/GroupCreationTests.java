package ru.stqa.jft.addressbook.tests;

import org.testng.annotations.*;
import ru.stqa.jft.addressbook.model.GroupData;

public class GroupCreationTests extends TestBase {

    @Test
    public void testGroupCreation() {
        app.getNavigationHelper().gotoGroupPage();
        app.getGroupHelper().createGroup(new GroupData("NewTestGroup", "test1", "test2"));
    }

}
