package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactsData;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;

public class ContactCreationTests extends TestsBase {

  @Test
  public void testContactCreation() {
    List<ContactsData> before = app.contact().list();
    app.goTo().HomePage(app);
    app.searchForm();
    app.goTo().groupPage();
    if (!app.wd.getPageSource().contains("title=\"Select (name)\"")) {
      app.group().create(new GroupData ().withName("name"));
    }
    app.goTo().HomePage(app);
    ContactsData contact = new ContactsData("Первый", "Первович", "Первов", "Нет", "1", "2", "3", "4.1", "4.2", "4.3", "4.4", "5.2", "5.3", "5.2", "6", "name");
    app.contact().create(contact);
    //app.getContactHelper().acceptAlert();
    app.goTo().HomePage(app);
    List<ContactsData> after = app.contact().list();
    Assert.assertEquals(after.size(), before.size() + 1);

    contact.setId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());
    before.add(contact);
    Comparator<? super ContactsData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }

}



