package ru.stqa.pft.addressbook.appmanager;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactsData;

import java.util.ArrayList;
import java.util.List;

public class ContactHelper extends HelperBase {

  public ContactHelper(WebDriver wd) {
    super(wd);

  }

  public void creationNewContacts() {
    wd.findElement(By.xpath("//div[@id='content']/form/input[21]")).click();
  }

  public void fillContactsForm(ContactsData contactsData, boolean creation) {
    wd.findElement(By.name("firstname")).click();
    wd.findElement(By.name("firstname")).clear();
    wd.findElement(By.name("firstname")).sendKeys(contactsData.getName());
    wd.findElement(By.name("middlename")).click();
    wd.findElement(By.name("middlename")).clear();
    wd.findElement(By.name("middlename")).sendKeys(contactsData.getMname());
    wd.findElement(By.name("lastname")).click();
    wd.findElement(By.name("lastname")).clear();
    wd.findElement(By.name("lastname")).sendKeys(contactsData.getLname());
    wd.findElement(By.name("nickname")).click();
    wd.findElement(By.name("nickname")).clear();
    wd.findElement(By.name("nickname")).sendKeys(contactsData.getNickname());
    wd.findElement(By.name("title")).click();
    wd.findElement(By.name("title")).clear();
    wd.findElement(By.name("title")).sendKeys(contactsData.getTitle());
    wd.findElement(By.name("company")).click();
    wd.findElement(By.name("company")).clear();
    wd.findElement(By.name("company")).sendKeys(contactsData.getCompany());
    wd.findElement(By.name("address")).click();
    wd.findElement(By.name("address")).clear();
    wd.findElement(By.name("address")).sendKeys(contactsData.getAdress());
    wd.findElement(By.name("home")).click();
    wd.findElement(By.name("home")).clear();
    wd.findElement(By.name("home")).sendKeys(contactsData.getHometel());
    wd.findElement(By.name("mobile")).click();
    wd.findElement(By.name("mobile")).clear();
    wd.findElement(By.name("mobile")).sendKeys(contactsData.getMobiltel());
    wd.findElement(By.name("work")).click();
    wd.findElement(By.name("work")).clear();
    wd.findElement(By.name("work")).sendKeys(contactsData.getWorktel());
    wd.findElement(By.name("fax")).click();
    wd.findElement(By.name("fax")).clear();
    wd.findElement(By.name("fax")).sendKeys(contactsData.getFax());
    wd.findElement(By.name("email")).click();
    wd.findElement(By.name("email")).clear();
    wd.findElement(By.name("email")).sendKeys(contactsData.getEmail());
    wd.findElement(By.name("email3")).click();
    wd.findElement(By.name("email3")).clear();
    wd.findElement(By.name("email3")).sendKeys(contactsData.getEmail3());
    wd.findElement(By.name("email2")).click();
    wd.findElement(By.name("email2")).clear();
    wd.findElement(By.name("email2")).sendKeys(contactsData.getEmail2());
    wd.findElement(By.name("homepage")).click();
    wd.findElement(By.name("homepage")).clear();

    if (!wd.findElement(By.xpath("//div[@id='content']/form/select[1]//option[1]")).isSelected()) {
      wd.findElement(By.xpath("//div[@id='content']/form/select[1]//option[1]")).click();
    }
    wd.findElement(By.name("address2")).click();
    wd.findElement(By.name("address2")).clear();
    wd.findElement(By.name("address2")).sendKeys("7");
    wd.findElement(By.name("phone2")).click();
    wd.findElement(By.name("phone2")).clear();
    wd.findElement(By.name("phone2")).sendKeys("8");
    wd.findElement(By.name("notes")).click();
    wd.findElement(By.name("notes")).clear();
    wd.findElement(By.name("notes")).sendKeys("9");


    if (creation) {
      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(ContactsData.getGroup());
    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }
  }

  public void addNewContacts() {
    click(By.linkText("add new"));
  }

  public void delitionContractElemtnt() {
    wd.findElement(By.xpath("//div[@id='content']/form[2]/div[2]/input")).click();
  }

  public void selectContactElement(int index) {
    wd.findElements(By.name("selected[]")).get(index).click();
  }

  public void initContactModification(int index) {
    wd.findElements(By.xpath(".//td[8]")).get(index).click();
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
  }
  public void modify(int index, ContactsData contact) {
    initContactModification(index);
    fillContactsForm(contact, false);
    submitContactModification();
  }
  public void delete(int index) {
    selectContactElement(index);
    delitionContractElemtnt();
    acceptAlert();
  }

  public boolean isThereAContact() {
    return isElementPresent(By.name("selected[]"));
  }

  public int getContactCount() {
    return wd.findElements(By.name("selected[]")).size();
  }

  public List<ContactsData> list() {
    List<ContactsData> contacts = new ArrayList<ContactsData>();
    List<WebElement> elements = wd.findElements(By.xpath("//tr[contains(@name,\"entry\")]"));
    for (WebElement element : elements) {
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("id"));
      String name = element.findElement(By.xpath("./td[3]")).getText();
      String lname = element.findElement(By.xpath("./td[2]")).getText();
      contacts.add(new ContactsData ().withId(id). withName(name).withLname(lname));
    }
    return contacts;
  }
}


