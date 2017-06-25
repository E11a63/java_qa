package ru.stqa.pft.addressbook.appmanager;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.ContactsData;

import java.util.List;

public class ContactHelper extends HelperBase {

  private Contacts contactCache = null;

  public ContactHelper(WebDriver wd) {
    super(wd);

  }

  public void creationNewContacts() {
    wd.findElement(By.xpath("//div[@id='content']/form/input[21]")).click();
  }

  public void fillContactsForm(ContactsData contactsData, boolean creation) {
    type(By.name("firstname"), contactsData.getName());
    type(By.name("middlename"), contactsData.getMname());
    type(By.name("lastname"), contactsData.getLname());
    type(By.name("nickname"), contactsData.getNickname());
    type(By.name("title"), contactsData.getTitle());
    type(By.name("company"), contactsData.getCompany());
    type(By.name("address"), contactsData.getAddress());
    type(By.name("home"), contactsData.getHometel());
    type(By.name("mobile"), contactsData.getMobiltel());
    type(By.name("work"), contactsData.getWorktel());
    type(By.name("fax"), contactsData.getFax());
    type(By.name("email"), contactsData.getEmail());
    type(By.name("email3"), contactsData.getEmail3());
    type(By.name("email2"), contactsData.getEmail2());
//    attach(By.name("photo"), contactsData.getPhoto());

    if (!wd.findElement(By.xpath("//div[@id='content']/form/select[1]//option[1]")).isSelected()) {
      wd.findElement(By.xpath("//div[@id='content']/form/select[1]//option[1]")).click();
    }

    if (creation) {
      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactsData.getGroup());
    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }
  }

  public void addNewContacts() {
    click(By.linkText("add new"));
  }

  public void delitionContact() {
    wd.findElement(By.xpath("//div[@id='content']/form[2]/div[2]/input")).click();
  }

  public void selectContact(int index) {
    wd.findElements(By.name("selected[]")).get(index).click();
  }

  public void selectContactByID(int id) {
    wd.findElement(By.cssSelector("input[value='" + id + "']")).click();
  }

  public void initContactModification(int index) {
    wd.findElements(By.xpath(".//td[8]")).get(index).click();
  }

  public void initContactModificationByID(int id) {
    wd.findElement(By.cssSelector("a[href='edit.php?id=" + id + "']")).click();
  }

  public void submitContactModification() {
    wd.findElement(By.xpath("//div[@id='content']/form[1]/input[22]")).click();
  }

  public void acceptAlert() {

    wd.switchTo().alert().accept();
  }

  public void create(ContactsData contact) {
    addNewContacts();
    fillContactsForm(contact, true);
    creationNewContacts();

    contactCache = null;
  }

  public void modify(ContactsData contact) {
    initContactModificationByID(contact.getId());
    fillContactsForm(contact, false);
    submitContactModification();
    contactCache = null;
  }

  public void delete(ContactsData contact) {
    selectContactByID(contact.getId());
    delitionContact();
    contactCache = null;
  }

  public boolean isThereAContact() {
    return isElementPresent(By.name("selected[]"));
  }

  public int count() {
    return wd.findElements(By.name("selected[]")).size();
  }

  public Contacts all() {
    if (contactCache != null) {
      return new Contacts(contactCache);
    }
    contactCache = new Contacts();
    List<WebElement> elements = wd.findElements(By.xpath("//tr[contains(@name,\"entry\")]"));
    for (WebElement element : elements) {
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("id"));
      String lname = element.findElement(By.xpath("./td[2]")).getText();
      String name = element.findElement(By.xpath("./td[3]")).getText();
      String allPhones = element.findElement(By.xpath("./td[6]")).getText();
      String allEmails = element.findElement(By.xpath("./td[5]")).getText();
      String addresses = element.findElement(By.xpath("./td[4]")).getText();
      contactCache.add(new ContactsData().withId(id).withName(name).withLname(lname).withHomeAddress(addresses)
              .withAllPhones(allPhones).withAllEmails(allEmails));
    }
    return new Contacts(contactCache);
  }

  public ContactsData infoFromEditionForm(ContactsData contact) {
    initContactModificationByID(contact.getId());
    String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
    String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
    String home = wd.findElement(By.name("home")).getAttribute("value");
    String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
    String work = wd.findElement(By.name("work")).getAttribute("value");
    String address = wd.findElement(By.name("address")).getAttribute("value");
    String email = wd.findElement(By.name("email")).getAttribute("value");
    String email2 = wd.findElement(By.name("email2")).getAttribute("value");
    String email3 = wd.findElement(By.name("email3")).getAttribute("value");
    wd.navigate().back();
    return new ContactsData().withId(contact.getId()).withFirstName(firstname).withLname(lastname)
            .withHomePhone(home).withMobilePhone(mobile).withWorkPhone(work)
            .withHomeAddress(address).withEmail(email).withEmail2(email2).withEmail3(email3);
  }
}
