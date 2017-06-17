package ru.stqa.pft.addressbook.tests;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactsData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class CheckContactFormTests extends TestsBase {
  public static String cleanedPhone(String phone) {
    return phone.replaceAll("\\s", "").replaceAll("[-()]", "");
  }

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().HomePage(app);
    if (app.contact().all().size() == 0) {
      app.contact().create(new ContactsData().withName("Первый").withMname("Первович").withLname("Первов").withGroup("name").withHomeAddress("Почтовый адрес").withEmail("111@").withEmail2("222@").withEmail3("333@").withHometel("+7 111").withMobiltel("+7-222").withWorktel("8(333)")); // добавить заполнение полей
      app.goTo().HomePage(app);
    }
  }

  @Test
  public void testContactPhones() {
    app.goTo().HomePage(app);
    ContactsData contact = app.contact().all().iterator().next();
    ContactsData contactInfoFromEditionForm = app.contact().infoFromEditionForm(contact);
    assertThat(contact.getAllPhones(), equalTo(mergePhones(contactInfoFromEditionForm)));
  }

  private String mergePhones(ContactsData contact) {
    return Arrays.asList(contact.getHometel(), contact.getMobiltel(), contact.getWorktel())
            .stream().filter((s) -> !s.equals(""))
            .map(CheckContactFormTests::cleanedPhone)
            .collect(Collectors.joining("\n"));
  }

  @Test
  public void testContactEmails() {
    app.goTo().HomePage(app);
    ContactsData contact = app.contact().all().iterator().next();
    ContactsData contactInfoFromEditionForm = app.contact().infoFromEditionForm(contact);
    assertThat(contact.getAllEmails(), equalTo(mergeEmails(contactInfoFromEditionForm)));
  }

  private String mergeEmails(ContactsData contact) {
    return Arrays.asList(contact.getEmail(), contact.getEmail2(), contact.getEmail3())
            .stream().filter((s) -> !s.equals(""))
            .collect(Collectors.joining("\n"));
  }


  @Test
  public void testContactAddress() {
    app.goTo().HomePage(app);
    ContactsData contact = app.contact().all().iterator().next();
    ContactsData contactInfoFromEditionForm = app.contact().infoFromEditionForm(contact);
    assertThat(contact.getAddress(), equalTo(contactInfoFromEditionForm.getAddress()));
  }
}
