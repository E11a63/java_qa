package ru.stqa.pft.addressbook;

import org.testng.annotations.Test;

public class ContactsDeleteTests extends TestsBase {

  @Test
  public void testsContactsDeletion() {

    app.viewNewcreateContacts();
    app.selectContactElement();
    app.delitionContractElemtnt();
  }
}
