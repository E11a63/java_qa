package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactsData;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.Set;

public class ContactCreationTests extends TestsBase {

  @Test
  public void testContactCreation() {
    app.goTo().HomePage(app);
    Set<ContactsData> before = app.contact().all();
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
    Set<ContactsData> after = app.contact().all();
    Assert.assertEquals(after.size(), before.size() + 1);

    contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt());
    before.add(contact);
    Assert.assertEquals(before, after);
  }

}



