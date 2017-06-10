package ru.stqa.pft.addressbook.model;

public class ContactsData {
  private static String group;
  private String name;
  private String mname;
  private String lname;
  private String nickname;
  private String title;
  private String company;
  private String adress;
  private String hometel;
  private String mobiltel;
  private String worktel;
  private String fax;
  private String email;
  private String email3;
  private String email2;
  private String homepage;
  private int id = Integer.MAX_VALUE;


  public static String getGroup() {
    return group;
  }

  public int getId() {
    return id;
  }

  public ContactsData withId(int id) {
    this.id = id;
    return this;
  }
  public ContactsData withGroup(String group) {
    ContactsData.group = group;
    return this;
  }

  public ContactsData withName(String name) {
    this.name = name;
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

  public ContactsData withAdress(String adress) {
    this.adress = adress;
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
    return name;
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

  public String getAdress() {
    return adress;
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
            ", name='" + name + '\'' +
            ", lname='" + lname + '\'' +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    ContactsData that = (ContactsData) o;

    if (name != null ? !name.equals(that.name) : that.name != null) return false;
    return lname != null ? lname.equals(that.lname) : that.lname == null;
  }

  @Override
  public int hashCode() {
    int result = name != null ? name.hashCode() : 0;
    result = 31 * result + (lname != null ? lname.hashCode() : 0);
    return result;
  }
}




