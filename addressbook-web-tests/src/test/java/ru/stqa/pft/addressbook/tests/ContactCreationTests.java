package ru.stqa.pft.addressbook.tests;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.appmanager.ApplicationManager;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.ContactsData;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestsBase {


  @DataProvider
  public Iterator<Object[]> validContactsFromCsv() throws IOException {
    List<Object[]> list = new ArrayList<Object[]>();
    BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contacts.csv")));
    String line = reader.readLine();
    while (line != null) {
      String[] split = line.split(";");
//      list.add(new Object[]{new ContactsData().withName(split[0])
//              /*.withMname(split[1])*/.withLname(split[1]).withGroup(split[2]).withPhoto(new File((split[3])))});
//      line = reader.readLine();
    }
    return list.iterator();
  }

  @DataProvider
  public Iterator<Object[]> validContactsFromJson() throws IOException {
    BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contacts.json")));
    String json = "";
    String line = reader.readLine();
    while (line != null) {
      json += line;
      line = reader.readLine();
    }
    Gson gson = new Gson();
    List<ContactsData> contacts = gson.fromJson(json, new TypeToken<List<ContactsData>>() {
    }.getType()); //List<GroupData>.class
    return contacts.stream().map((c) -> new Object[]{c}).collect(Collectors.toList()).iterator();
  }

  @Test(dataProvider = "validContactsFromJson")

  public void testContactCreation(ContactsData contact) {
    Groups groups = app.db().groups();
    File photo = new File("src/test/resources/kat.jpg");
    ContactsData newContact = new ContactsData()
            .withName("Первый").withMname("Первович").withLname("Первов").inGroup(groups.iterator().next());
    app.goTo().HomePage(app);
 //   Contacts before = app.db().contacts();
    app.searchForm();
    app.goTo().groupPage();
    if (!app.wd.getPageSource().contains("title=\"Select (name)\"")) {
      app.group().create(new GroupData().withName("name"));
    }
    app.goTo().HomePage(app);

    app.contact().create(newContact);
    app.goTo().HomePage(app);
 //   assertThat(app.contact().count(), equalTo(before.size() + 1));
    Contacts after = app.db().contacts();
  //  assertThat(after, equalTo(before.withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
    verifyContactListInUI();

  }

  @Test(enabled = false)
  public void testBadContactCreation() {
    app.goTo().HomePage(app);
    Contacts before = app.db().contacts();
    app.searchForm();
    app.goTo().groupPage();
    if (!app.wd.getPageSource().contains("title=\"Select (name)\"")) {
      app.group().create(new GroupData().withName("name"));
    }
    app.goTo().HomePage(app);
//    ContactsData contact = new ContactsData()
//            .withName("Первый'").withMname("Первович").withLname("Первов").withGroup("name");
//    app.contact().create(contact);
    app.goTo().HomePage(app);
    assertThat(app.contact().count(), equalTo(before.size()));
    Contacts after = app.db().contacts();
    assertThat(after.size(), equalTo(before.size()));
    verifyContactListInUI();
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



