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
    if (app.db().contacts().size() == 0) {
      app.goTo().HomePage(app);
      app.contact().create(new ContactsData().withName("Первый").withMname("Первович").withLname("Первов").withGroup("name"));
    }
  }

  @Test
  public void testsContactsDeletion() {
    Contacts before = app.db().contacts();
    ContactsData deletedContact = before.iterator().next();
    app.contact().delete(deletedContact);
    app.contact().acceptAlert();
    app.goTo().HomePage(app);// уточнить класс помощник
    assertThat(before.size() - 1, equalTo(app.contact().count()));
    Contacts after = app.db().contacts();
    before.remove(deletedContact);
    assertEquals(before, after);
    assertThat(after, equalTo(before.without(deletedContact)));
  }


}