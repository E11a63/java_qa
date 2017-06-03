package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactsData;

public class ContactsDeleteTests extends TestsBase {

  @Test
  public void testsContactsDeletion() {
    app.navigationHelper.gotoHomePage(app);
    if (!app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactsData("Первый", "Первович", "Первов", "Нет", "1", "2", "3", "4.1", "4.2", "4.3", "4.4", "5.2", "5.3", "5.2", "6", "name"));
      app.navigationHelper.gotoHomePage(app);
    }
    int before = app.getContactHelper().getContactCount();
    app.getContactHelper().selectContactElement();
    app.getContactHelper().delitionContractElemtnt();
    app.getContactHelper().acceptAlert();
    app.getNavigationHelper().gotoHomePage(app);
    int after = app.getContactHelper().getContactCount();
    Assert.assertEquals(after, before - 1);
  }
}