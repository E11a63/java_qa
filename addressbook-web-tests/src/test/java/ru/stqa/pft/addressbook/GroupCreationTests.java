package ru.stqa.pft.addressbook;

import org.testng.annotations.Test;


public class GroupCreationTests extends TestsBase{


  @Test
  public void testGroupCreation() {
    gotoGroupPage();
    initGroupCreation();
    fillGroupForm(new GroupData("name", "test_qa", "test_qa"));
    submitGroupCreation();
    returnGroupPage();
  }

}
