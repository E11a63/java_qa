package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactsData;

import java.util.List;

public class ContactsDeleteTests extends TestsBase {
  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().HomePage(app);
    if (app.contact().list().size() == 0) {
      app.contact().create(new ContactsData().withName("Первый").withMname("Первович").withLname("Первов").withGroup("name"));
      app.goTo().HomePage(app);
    }
  }

  @Test
  public void testsContactsDeletion() {
    List<ContactsData> before = app.contact().list();
    int index = before.size() - 1;
    app.contact().delete(index);
    app.goTo().HomePage(app);// уточнить класс помощник
    List<ContactsData> after = app.contact().list();
    Assert.assertEquals(after.size(), before.size() - 1);

    before.remove(index);
    Assert.assertEquals(before, after);
  }


}