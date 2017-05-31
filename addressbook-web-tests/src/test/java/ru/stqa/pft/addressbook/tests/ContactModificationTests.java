package ru.stqa.pft.addressbook.tests;


import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactsData;

public class ContactModificationTests extends TestsBase {
  @Test
  public void testContactModification() {
    app.navigationHelper.gotoHomePage(app);
    if (!app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactsData("Первый", "Первович", "Первов", "Нет", "1", "2", "3", "4.1", "4.2", "4.3", "4.4", "5.2", "5.3", "5.2", "6", "name"));
      app.navigationHelper.gotoHomePage(app);
    }
    app.getContactHelper().selectContactElement();
    app.getContactHelper().initContactModification();
    app.getContactHelper().fillContactsForm(new ContactsData("Первый", "Первович", "Первов", "Нет", "1", "2", "3", "4.1", "4.2", "4.3", "4.4", "5.2", "5.3", "5.2", "6", null), false);
    app.getContactHelper().submitContactModification();
    app.navigationHelper.gotoHomePage(app);

  }
}
