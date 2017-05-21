package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

public class GroupModificationTests extends TestsBase{
  @Test

  public void testGroupModification () {
    app.getNavigationHelper().gotoGroupPage();
    app.getGroupHelper().selectGroupElement();
    app.getGroupHelper().initGroupModification ();
    app.getGroupHelper().fillGroupForm(new GroupData("name", "test_qa", "test_qa"));
    app.getGroupHelper().submitGroupModification ();
    app.getGroupHelper().returnGroupPage();
  }
}
