package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactsData;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.HashSet;
import java.util.List;

public class ContactCreationTests extends TestsBase {

  @Test
  public void testContactCreation() {
    List<ContactsData> before = app.getContactHelper().getContactslist();
    app.navigationHelper.gotoHomePage(app);
    app.searchForm();
    app.getNavigationHelper().gotoGroupPage();
    if (!app.wd.getPageSource().contains("title=\"Select (name)\"")) {
      app.getGroupHelper().createGroup(new GroupData("name", null, null));
    }
    app.navigationHelper.gotoHomePage(app);
    ContactsData contact = new ContactsData("Первый", "Первович", "Первов", "Нет", "1", "2", "3", "4.1", "4.2", "4.3", "4.4", "5.2", "5.3", "5.2", "6", "name");
    app.getContactHelper().createContact(contact);
    //app.getContactHelper().acceptAlert();
    app.navigationHelper.gotoHomePage(app);
    List<ContactsData> after = app.getContactHelper().getContactslist();
    Assert.assertEquals(after.size(), before.size() + 1);

    contact.setId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());
    before.add(contact);
    Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
  }

}



