package ru.stqa.pft.addressbook;

import org.testng.annotations.Test;

public class GroupCreationTests extends TestsBase {

  @Test
  public void testGroupCreation() {
    app.gotoGroupPage();
    app.initGroupCreation();
    app.fillGroupForm(new GroupData("name", "test_qa", "test_qa"));
    app.submitGroupCreation();
    app.returnGroupPage();
  }


}
