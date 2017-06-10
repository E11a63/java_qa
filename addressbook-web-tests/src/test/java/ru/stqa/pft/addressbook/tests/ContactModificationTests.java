package ru.stqa.pft.addressbook.tests;


import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactsData;

import java.util.Comparator;
import java.util.List;

public class ContactModificationTests extends TestsBase {
  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().HomePage(app);
    if (app.contact().list().size()==0) {
      app.contact().create(new ContactsData().withName("Первый").withMname("Первович").withLname("Первов").withGroup("name"));
      app.goTo().HomePage(app);
    }
  }

  @Test
  public void testContactModification() {
    List<ContactsData> before = app.contact().list();
    int index = before.size() - 1;
    ContactsData contact = new ContactsData().withId(before.get(index).getId()). withName("Первый").withMname("Первович").withLname("Первов");
    app.contact().modify(index, contact);
    app.goTo().HomePage(app); // уточнить класс помощник
    List<ContactsData> after = app.contact().list();
    Assert.assertEquals(after.size(), before.size());

    before.remove(index);
    before.add(contact);
    Comparator<? super ContactsData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);

  }
}
