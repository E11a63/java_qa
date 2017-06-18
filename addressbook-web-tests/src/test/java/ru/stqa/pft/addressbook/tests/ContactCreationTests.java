package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.ContactsData;
import ru.stqa.pft.addressbook.model.GroupData;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestsBase {

  @DataProvider
  public Iterator<Object[]> validContacts() throws IOException {
    List<Object[]> list = new ArrayList<Object[]>();
    BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contacts.csv")));
    String line  = reader.readLine();
    while (line != null){
      String[] split = line.split(";");
      list.add(new Object[]{new ContactsData().withName(split[0])
              /*.withMname(split[1])*/.withLname(split[1]).withGroup(split[2]).withPhoto(new File((split[3])))});
      line = reader.readLine();
    }
    return list.iterator();

  }

  @Test(dataProvider = "validContacts")
  public void testContactCreation(ContactsData contact) {
    app.goTo().HomePage(app);
    Contacts before = app.contact().all();
    app.searchForm();
//    app.goTo().groupPage();
//    if (!app.wd.getPageSource().contains("title=\"Select (name)\"")) {
//      app.group().create(new GroupData().withName("name"));
//    }
    app.goTo().HomePage(app);
    File photo = new File("src/test/resources/kat.jpg");
    app.contact().create(contact);
    app.goTo().HomePage(app);
    Contacts after = app.contact().all();
    assertThat(app.contact().count(), equalTo(before.size()+1));
    assertThat(after, equalTo(before.withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));

  }
  @Test (enabled = false)
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
//  @Test
//  public void testCurrentDir ()
//  {
//    File currentDir = new File(".");
//    System.out.println(currentDir.getAbsolutePath());
//    File photo = new File("src/test/resources/kat.jpg");
//    System.out.println(photo.getAbsolutePath());
//    System.out.println(photo.exists());
//  }

}



