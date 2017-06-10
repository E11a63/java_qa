package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactsData;

import java.util.Set;

public class ContactsDeleteTests extends TestsBase {
  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().HomePage(app);
    if (app.contact().all().size() == 0) {
      app.contact().create(new ContactsData().withName("Первый").withMname("Первович").withLname("Первов").withGroup("name"));
      app.goTo().HomePage(app);
    }
  }

  @Test
  public void testsContactsDeletion() {
    Set<ContactsData> before = app.contact().all();
    ContactsData deletedContact = before.iterator().next();
    app.contact().delete(deletedContact);
    app.contact().acceptAlert();
    app.goTo().HomePage(app);// уточнить класс помощник
    Set<ContactsData> after = app.contact().all();
    Assert.assertEquals(after.size(), before.size() - 1);

    before.remove(deletedContact);
    Assert.assertEquals(before, after);
  }


}