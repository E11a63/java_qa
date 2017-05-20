package ru.stqa.pft.addressbook;

import org.testng.annotations.Test;

import static org.openqa.selenium.By.xpath;

public class GroupDeleteTests extends TestsBase {


  @Test
  public void testsGroupDeletion() {

    app.gotoGroupPage();
    app.selectGroupElement();
    app.deleteSelectedGroups();
    app.returneGroupPage();
  }




}

