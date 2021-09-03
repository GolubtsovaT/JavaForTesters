package ru.stqa.jft.addressbook;

import org.testng.annotations.*;

public class GroupCreationTests extends TestBase {

    @Test
    public void testGroupCreation() {
        gotoGroupPage();
        initGroupCreation();
        fillGroupForm(new GroupData("NewTestGroup", "test1", "test2"));
        submitGroupCreation();
        returnToGroupPage();
    }

}
