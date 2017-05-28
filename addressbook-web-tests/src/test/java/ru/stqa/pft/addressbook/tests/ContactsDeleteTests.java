package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

public class ContactsDeleteTests extends TestsBase {

  @Test
  public void testsContactsDeletion() {

    app.navigationHelper.gotoHomePage(app);
    app.getContactHelper().selectContactElement();
    app.getContactHelper().delitionContractElemtnt();
    app.getContactHelper().acceptAlert();
    app.navigationHelper.gotoHomePage(app);
  }

}
