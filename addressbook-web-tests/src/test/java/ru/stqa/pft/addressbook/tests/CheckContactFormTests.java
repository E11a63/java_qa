package ru.stqa.pft.addressbook.tests;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactsData;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class CheckContactFormTests extends TestsBase {
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
    assertThat(contact.getHometel(), equalTo(cleanedPhone (contactInfoFromEditionForm.getHometel())));
    assertThat(contact.getMobiltel(), equalTo(cleanedPhone (contactInfoFromEditionForm.getMobiltel())));
    assertThat(contact.getWorktel(), equalTo(cleanedPhone (contactInfoFromEditionForm.getWorktel())));
  }

  public String cleanedPhone (String phone) {
  return phone.replaceAll("\\s","").replaceAll("[-()]","");
  }


  @Test
  public void testContactEmails() {
    app.goTo().HomePage(app);
    ContactsData contact = app.contact().all().iterator().next();
    ContactsData contactInfoFromEditionForm = app.contact().infoFromEditionForm(contact);
    assertThat(contact.getEmail(), equalTo(cleanedEmail (contactInfoFromEditionForm.getEmail())));
    assertThat(contact.getEmail2(), equalTo(cleanedEmail (contactInfoFromEditionForm.getEmail2())));
    assertThat(contact.getEmail3(), equalTo(cleanedEmail (contactInfoFromEditionForm.getEmail3())));
  }
  public String cleanedEmail (String email) {
    return email.replaceAll("\\s","").replaceAll("[-()]","");
  }

  @Test
  public void testContactAddress() {
    app.goTo().HomePage(app);
    ContactsData contact = app.contact().all().iterator().next();
    ContactsData contactInfoFromEditionForm = app.contact().infoFromEditionForm(contact);
    assertThat(contact.getAddress(), equalTo(cleanedAddress (contactInfoFromEditionForm.getAddress())));
  }
  public String cleanedAddress (String address) {
    return address.replaceAll("[-()]","");
  }
}
