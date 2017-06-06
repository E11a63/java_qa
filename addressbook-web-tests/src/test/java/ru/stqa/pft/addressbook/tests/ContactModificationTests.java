package ru.stqa.pft.addressbook.tests;


import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactsData;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class ContactModificationTests extends TestsBase {
  @Test
  public void testContactModification() {
    app.navigationHelper.gotoHomePage(app);
    if (!app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactsData("Первый", "Первович", "Первов", "Нет", "1", "2", "3", "4.1", "4.2", "4.3", "4.4", "5.2", "5.3", "5.2", "6", "name"));
      app.navigationHelper.gotoHomePage(app);
    }
    List<ContactsData> before = app.getContactHelper().getContactslist();
    app.getContactHelper().selectContactElement(before.size() -1);
    app.getContactHelper().initContactModification();
    ContactsData contact = new ContactsData(before.get(before.size() -1).getId(),"Первый", "Первович", "Первов", "Нет", "1", "2", "3", "4.1", "4.2", "4.3", "4.4", "5.2", "5.3", "5.2", "6", null);
    app.getContactHelper().fillContactsForm(contact, false);
    app.getContactHelper().submitContactModification();
    app.navigationHelper.gotoHomePage(app);
    List<ContactsData> after = app.getContactHelper().getContactslist();
    Assert.assertEquals(after.size(), before.size());

    before.remove(before.size()-1);
    before.add(contact);
    Comparator<? super ContactsData> byId = (c1, c2) -> Integer.compare(c1.getId(),c2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals (before,after);

  }
}
