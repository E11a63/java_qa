package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactsData;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

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
      app.contact().create(new ContactsData().withName("Первый").withMname("Первович").withLname("Первов").inGroup(groups.iterator().next()));
      app.goTo().HomePage(app);
    }
  }

  @Test(enabled = false)
  public void ContactToGroup() {
 /*   ContactsData contact = app.db().contacts().iterator().next();
    Groups contactGroups = contact.getGroups();
    Groups allGroups = app.db().groups();
    // if (equals(contactGroups,allGroups)){
    app.goTo().groupPage();
    Groups extendedGroups =allGroups.withAdded(app.group().create(new GroupData().withName("name")));
    GroupData group = extendedGroups.stream().max((g1, g2) -> Integer.compare(g1.getId(), g2.getId()));

   System.out.println(newGroup.getId());
    System.out.println(newGroup);
    System.out.println(allGroups);

  }*/
    System.out.println("exit");
  }

}
