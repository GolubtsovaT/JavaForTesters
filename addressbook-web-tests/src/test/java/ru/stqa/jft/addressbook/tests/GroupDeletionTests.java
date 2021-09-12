package ru.stqa.jft.addressbook.tests;

import org.testng.annotations.Test;

public class GroupDeletionTests extends TestBase {

    @Test
    public void testGroupDeletion() {
        app.getNavigationHelper().gotoGroupPage();
        app.getGroupHelper().selectGroupByName("NewTestGroup");
        app.getGroupHelper().initGroupDeletion();
        app.getGroupHelper().returnToGroupPage();
    }
}
