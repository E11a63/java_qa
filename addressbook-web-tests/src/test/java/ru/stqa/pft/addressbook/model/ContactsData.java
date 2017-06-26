package ru.stqa.pft.addressbook.model;

import com.google.gson.annotations.Expose;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.File;

@Entity
@Table(name = "addressbook")
public class ContactsData {

 @Expose
//  @Column(name = "group_name")
  @Transient
  private String group;
  @Expose
  @Column(name = "firstname")
  private String firstName;
  @Transient
  @Column(name = "middlename")
  private String mname;
  @Expose
  @Column(name = "lastname")
  private String lname;
  @Transient
  @Column(name = "nickname")

  private String nickname;
  @Transient
  private String title;
  @Transient
  private String company;
  @Type(type = "text")
  @Transient
  private String address;
  @Column(name = "home")
  @Transient
  @Type(type = "text")
  private String hometel;
  @Transient
  @Column(name = "mobile")
  @Type(type = "text")

  private String mobiltel;
  @Transient
  @Column(name = "work")

  @Type(type = "text")
  private String worktel;
  @Transient
  @Type(type = "text")
  private String fax;
  @Transient
  @Column(name = "email")
  @Type(type = "text")
  private String email;
  @Transient
  @Column(name = "email3")
  @Type(type = "text")
  private String email3;
  @Transient
  @Column(name = "email2")
  @Type(type = "text")
  private String email2;
  @Transient
  @Type(type = "text")
  private String homepage;
  @Id
  @Column(name = "id")
  private int id = Integer.MAX_VALUE;
  @Transient
  private String allPhones;
  @Transient
  private String allEmails;
  @Transient
  @Column(name = "photo")
  @Type(type = "text")

  private String photo;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    ContactsData that = (ContactsData) o;

    if (id != that.id) return false;
    if (group != null ? !group.equals(that.group) : that.group != null) return false;
    if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
    if (mname != null ? !mname.equals(that.mname) : that.mname != null) return false;
    if (lname != null ? !lname.equals(that.lname) : that.lname != null) return false;
    if (nickname != null ? !nickname.equals(that.nickname) : that.nickname != null) return false;
    if (title != null ? !title.equals(that.title) : that.title != null) return false;
    if (company != null ? !company.equals(that.company) : that.company != null) return false;
    if (address != null ? !address.equals(that.address) : that.address != null) return false;
    if (hometel != null ? !hometel.equals(that.hometel) : that.hometel != null) return false;
    if (mobiltel != null ? !mobiltel.equals(that.mobiltel) : that.mobiltel != null) return false;
    if (worktel != null ? !worktel.equals(that.worktel) : that.worktel != null) return false;
    if (fax != null ? !fax.equals(that.fax) : that.fax != null) return false;
    if (email != null ? !email.equals(that.email) : that.email != null) return false;
    if (email3 != null ? !email3.equals(that.email3) : that.email3 != null) return false;
    if (email2 != null ? !email2.equals(that.email2) : that.email2 != null) return false;
    if (homepage != null ? !homepage.equals(that.homepage) : that.homepage != null) return false;
    if (allPhones != null ? !allPhones.equals(that.allPhones) : that.allPhones != null) return false;
    if (allEmails != null ? !allEmails.equals(that.allEmails) : that.allEmails != null) return false;
    return photo.equals(that.photo);
  }

  @Override
  public int hashCode() {
    int result = group != null ? group.hashCode() : 0;
    result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
    result = 31 * result + (mname != null ? mname.hashCode() : 0);
    result = 31 * result + (lname != null ? lname.hashCode() : 0);
    result = 31 * result + (nickname != null ? nickname.hashCode() : 0);
    result = 31 * result + (title != null ? title.hashCode() : 0);
    result = 31 * result + (company != null ? company.hashCode() : 0);
    result = 31 * result + (address != null ? address.hashCode() : 0);
    result = 31 * result + (hometel != null ? hometel.hashCode() : 0);
    result = 31 * result + (mobiltel != null ? mobiltel.hashCode() : 0);
    result = 31 * result + (worktel != null ? worktel.hashCode() : 0);
    result = 31 * result + (fax != null ? fax.hashCode() : 0);
    result = 31 * result + (email != null ? email.hashCode() : 0);
    result = 31 * result + (email3 != null ? email3.hashCode() : 0);
    result = 31 * result + (email2 != null ? email2.hashCode() : 0);
    result = 31 * result + (homepage != null ? homepage.hashCode() : 0);
    result = 31 * result + id;
    result = 31 * result + (allPhones != null ? allPhones.hashCode() : 0);
    result = 31 * result + (allEmails != null ? allEmails.hashCode() : 0);
    return result;
  }

  public File getPhoto() {
    return new File(photo);
  }

  public ContactsData withPhoto(File photo) {
    this.photo = photo.getPath();
    return this;
  }

  public int getId() {
    return id;
  }

  public ContactsData withId(int id) {
    this.id = id;
    return this;
  }

  public ContactsData withFirstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  public ContactsData withGroup(String group) {
    this.group = group;
    return this;
  }

  public ContactsData withHomePhone(String hometel) {
    this.hometel = hometel;
    return this;
  }

  public ContactsData withMobilePhone(String mobiltel) {
    this.mobiltel = mobiltel;
    return this;
  }

  public ContactsData withWorkPhone(String worktel) {
    this.worktel = worktel;
    return this;
  }

  public ContactsData withName(String name) {
    this.firstName = name;
    return this;
  }

  public ContactsData withMname(String mname) {
    this.mname = mname;
    return this;
  }

  public ContactsData withLname(String lname) {
    this.lname = lname;
    return this;
  }

  public ContactsData withNickname(String nickname) {
    this.nickname = nickname;
    return this;
  }

  public ContactsData withTitle(String title) {
    this.title = title;
    return this;
  }

  public ContactsData withCompany(String company) {
    this.company = company;
    return this;
  }

  public ContactsData withHomeAddress(String address) {
    this.address = address;
    return this;
  }

  public ContactsData withHometel(String hometel) {
    this.hometel = hometel;
    return this;
  }

  public ContactsData withMobiltel(String mobiltel) {
    this.mobiltel = mobiltel;
    return this;
  }

  public ContactsData withWorktel(String worktel) {
    this.worktel = worktel;
    return this;
  }

  public ContactsData withFax(String fax) {
    this.fax = fax;
    return this;
  }

  public ContactsData withEmail(String email) {
    this.email = email;
    return this;
  }

  public ContactsData withEmail3(String email3) {
    this.email3 = email3;
    return this;
  }

  public ContactsData withEmail2(String email2) {
    this.email2 = email2;
    return this;
  }

  public ContactsData withHomepage(String homepage) {
    this.homepage = homepage;
    return this;
  }

  public String getName() {
    return firstName;
  }


  public String getGroup() {
    return group;
  }

  public String getMname() {
    return mname;
  }

  public String getLname() {
    return lname;
  }

  public String getNickname() {
    return nickname;
  }

  public String getTitle() {
    return title;
  }

  public String getCompany() {
    return company;
  }

  public String getAddress() {
    return address;
  }

  public String getHometel() {
    return hometel;
  }

  public String getMobiltel() {
    return mobiltel;
  }

  public String getWorktel() {
    return worktel;
  }

  public String getFax() {
    return fax;
  }

  public String getEmail() {
    return email;
  }

  public String getEmail3() {
    return email3;
  }

  public String getEmail2() {
    return email2;
  }

  @Override
  public String toString() {
    return "ContactsData{" +
            "id=" + id +
            ", name='" + firstName + '\'' +
            ", lname='" + lname + '\'' +
            '}';
  }

  public String getAllPhones() {
    return allPhones;
  }

  public ContactsData withAllPhones(String allPhones) {
    this.allPhones = allPhones;
    return this;
  }

  public String getAllEmails() {
    return allEmails;
  }

  public ContactsData withAllEmails(String allEmails) {
    this.allEmails = allEmails;
    return this;
  }
}




