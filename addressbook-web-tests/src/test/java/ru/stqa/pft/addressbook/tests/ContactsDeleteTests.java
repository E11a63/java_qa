package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.ContactsData;

import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.*;
import static org.testng.Assert.assertEquals;

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
    Contacts before = app.contact().all();
    ContactsData deletedContact = before.iterator().next();
    app.contact().delete(deletedContact);
    app.contact().acceptAlert();
    app.goTo().HomePage(app);// уточнить класс помощник
    Contacts after = app.contact().all();
    assertEquals(after.size(), before.size() - 1);

    before.remove(deletedContact);
    assertThat(after, equalTo(before.without(deletedContact)));
    assertEquals(before, after);
  }


}