package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.ContactsData;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class ContactToGroupTests extends TestsBase {
  @BeforeMethod
  public void ensurePreconditions() {

    if (app.db().contacts().size() == 0) {
      if (app.db().groups().size() == 0) {
        app.goTo().groupPage();
        app.group().create(new GroupData().withName("name"));
      }
      Groups groups = app.db().groups();
      app.goTo().HomePage(app);
      app.contact().create(new ContactsData().withName("Первый").withMname("Первович").withLname("Первов").inGroup(groups.iterator().next()),true);
      app.goTo().HomePage(app);
    }
  }

  @Test(enabled = true)
  public void testContactToGroup() {
    Groups groups = app.db().groups();
    Contacts before = app.db().contacts();
    ContactsData modifiedContact = before.iterator().next();
    ContactsData contact = new ContactsData().withId(modifiedContact.getId()).inGroup(groups.iterator().next());
    app.goTo().HomePage(app);
    app.contact().groupToAdd(contact);
    app.goTo().HomePage(app);
    assertThat(app.contact().count(), equalTo(before.size()));
    Contacts after = app.db().contacts();
    assertThat(after, equalTo(before.without(contact)));
    verifyContactListInUI();
  }

}
