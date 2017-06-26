package ru.stqa.pft.addressbook.tests;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.ContactsData;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactModificationTests extends TestsBase {
  @BeforeMethod
  public void ensurePreconditions() {
    if (app.db().contacts().size() == 0){
      app.goTo().HomePage(app);
    app.contact().create(new ContactsData().withName("Первый").withMname("Первович").withLname("Первов").withGroup("name"));
    app.goTo().HomePage(app);
  }
}

  @Test
  public void testContactModification() {
    Contacts before = app.db().contacts();
    ContactsData modifiedContact = before.iterator().next();
    ContactsData contact = new ContactsData().
            withId(modifiedContact.getId()).withName("Первый").withMname("Первович").withLname("Первов");
    app.goTo().HomePage(app);
    app.contact().modify(contact);
    app.goTo().HomePage(app); // уточнить класс помощник
    assertThat(app.contact().count(), equalTo(before.size()));
    Contacts after = app.db().contacts();
    assertEquals(after.size(), before.size());

  }
}
