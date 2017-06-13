package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.ContactsData;
import ru.stqa.pft.addressbook.model.GroupData;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestsBase {

  @Test
  public void testContactCreation() {
    app.goTo().HomePage(app);
    Contacts before = app.contact().all();
    app.searchForm();
    app.goTo().groupPage();
    if (!app.wd.getPageSource().contains("title=\"Select (name)\"")) {
      app.group().create(new GroupData().withName("name"));
    }
    app.goTo().HomePage(app);
    ContactsData contact = new ContactsData()
            .withName("Первый").withMname("Первович").withLname("Первов").withGroup("name");
    app.contact().create(contact);
    app.goTo().HomePage(app);
    assertThat(app.group().count(), equalTo(before.size()+1 ));
    Contacts after = app.contact().all();
    assertThat(app.contact().count(), equalTo(before.size()+1));
    //assertThat(before, equalTo(after.withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));

  }
  @Test
  public void testBadContactCreation() {
    app.goTo().HomePage(app);
    Contacts before = app.contact().all();
    app.searchForm();
    app.goTo().groupPage();
    if (!app.wd.getPageSource().contains("title=\"Select (name)\"")) {
      app.group().create(new GroupData().withName("name"));
    }
    app.goTo().HomePage(app);
    ContactsData contact = new ContactsData()
            .withName("Первый'").withMname("Первович").withLname("Первов").withGroup("name");
    app.contact().create(contact);
    app.goTo().HomePage(app);
    assertThat(app.contact().count(), equalTo(before.size()));
    Contacts after = app.contact().all();
    assertThat(after.size(), equalTo(before.size()));



  }
}



