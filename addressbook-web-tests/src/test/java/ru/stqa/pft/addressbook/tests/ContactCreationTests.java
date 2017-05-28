package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactsData;
import ru.stqa.pft.addressbook.model.GroupData;

public class ContactCreationTests extends TestsBase {

  @Test
  public void testContactCreation() {
    app.navigationHelper.gotoHomePage(app);
    app.searchForm();
    if (!app.getGroupHelper().isThereAGroup()) {
      app.getGroupHelper().createGroup(new GroupData("name", null, null));
      app.navigationHelper.gotoHomePage(app);
      app.getContactHelper().createContact(new ContactsData("Первый", "Первович", "Первов", "Нет", "1", "2", "3", "4.1", "4.2", "4.3", "4.4", "5.2", "5.3", "5.2", "6", "name"));
      //app.getContactHelper().acceptAlert();
      app.navigationHelper.gotoHomePage(app);
    }
  }
}
