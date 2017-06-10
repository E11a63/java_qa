package ru.stqa.pft.addressbook.tests;


import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactsData;

import java.util.Set;

public class ContactModificationTests extends TestsBase {
  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().HomePage(app);
    if (app.contact().all().size() == 0) {
      app.contact().create(new ContactsData().withName("Первый").withMname("Первович").withLname("Первов").withGroup("name"));
      app.goTo().HomePage(app);
    }
  }

  @Test
  public void testContactModification() {
    Set<ContactsData> before = app.contact().all();
    ContactsData modifiedContact = before.iterator().next();
    ContactsData contact = new ContactsData().
            withId(modifiedContact.getId()).withName("Первый").withMname("Первович").withLname("Первов");
    app.contact().modify(contact);
    app.goTo().HomePage(app); // уточнить класс помощник
    Set<ContactsData> after = app.contact().all();
    Assert.assertEquals(after.size(), before.size());

    before.remove(modifiedContact);
    before.add(contact);
    Assert.assertEquals(before, after);

  }
}
