package ru.stqa.pft.addressbook;

import org.testng.annotations.Test;

public class ContactCreationTests extends TestsBase {

  @Test
  public void testContactCreation() {
    app.searchForm();
    app.addNewContacts();
    app.fillContactsForm(new ContactsData("Первый", "Первович", "Первов", "Нет", "1", "2", "3", "4.1", "4.2", "4.3", "4.4", "5.2", "5.3", "5.2", "6"));
    app.creationNewContacts();
    app.viewNewcreateContacts();
  }


}
