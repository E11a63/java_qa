package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactsData;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * Created on 02.07.2017.
 */
public class ContactExcludeFromGroup extends TestsBase {
  @BeforeMethod
  public void ensurePreconditions() {
    if (app.db().contacts().size() == 0) {
      if (app.db().groups().size() == 0) {
        app.goTo().groupPage();
        app.group().create(new GroupData().withName("name"));
      }
      app.goTo().HomePage(app);
      Groups groups = app.db().groups();
      if (app.db().contacts().size() == 0) {
        app.contact().create(new ContactsData().withName("Первый").withMname("Первович").withLname("Первов").inGroup(groups.iterator().next()),true);
      } else {
        ContactsData contact = app.db().contacts().iterator().next();
        if (contact.getGroups().size() == 0) {
          contact.inGroup(groups.iterator().next());
        }
      }
    }
  }

  @Test
  public void ContactExcludeFromGroup() {
    ContactsData contact = app.db().contacts().iterator().next();
    Groups before = contact.getGroups();
    GroupData groupToExclude = before.iterator().next();
    app.contact().excludeFromGroup(contact, groupToExclude);
    Groups after = app.db().contactById(contact.getId()).getGroups();
    assertThat(after, equalTo(before.without(groupToExclude)));
  }
}


