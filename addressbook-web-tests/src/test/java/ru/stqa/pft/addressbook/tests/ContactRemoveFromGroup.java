package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactsData;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

/**
 * Created on 02.07.2017.
 */
public class ContactRemoveFromGroup extends TestsBase {
  @BeforeMethod
  public void ensurePreconditions() {

    if (app.db().contacts().size() == 0) {
      if (app.db().groups().size() == 0) {
        app.goTo().groupPage();
        app.group().create(new GroupData().withName("name"));
      }
      Groups groups = app.db().groups();
      app.goTo().HomePage(app);
      app.contact().create(new ContactsData().withName("Первый").withMname("Первович").withLname("Первов").inGroup(groups.iterator().next()));
      app.goTo().HomePage(app);
    }
  }

  @Test
  public void ContactRemoveFromGroup() {

//    app.contact().selectContact();
  }
}


