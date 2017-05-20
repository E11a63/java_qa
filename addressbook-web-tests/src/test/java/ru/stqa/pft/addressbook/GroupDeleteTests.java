package ru.stqa.pft.addressbook;

import org.testng.annotations.Test;

import static org.openqa.selenium.By.xpath;

public class GroupDeleteTests extends TestsBase {


  @Test
  public void testsGroupDeliteon() {

    gotoGroupPage();
    selectGroupElement();
    deleteSelectedGroups();
    returneGroupPage();
  }

  private void submitDeletSelectedGroupElement() {
    wd.findElement(xpath("//div[@id='content']/form/span[2]/input")).click();
  }

  private void selectGroupElement() {
    selectContactElement();
  }
}

