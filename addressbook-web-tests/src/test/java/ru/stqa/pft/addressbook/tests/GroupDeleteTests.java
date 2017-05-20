package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

public class GroupDeleteTests extends TestsBase {


  @Test
  public void testsGroupDeletion() {

    app.gotoGroupPage();
    app.getGroupHelper().selectGroupElement();
    app.getGroupHelper().deleteSelectedGroups();
    app.getGroupHelper().returneGroupPage();
  }




}

