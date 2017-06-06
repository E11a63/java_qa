package ru.stqa.pft.addressbook.model;

public class ContactsData {
  private static String group;
  private  int id;
  private final String name;
  private final String mname;
  private final String lname;
  private final String nickname;
  private final String title;
  private final String company;
  private final String adress;
  private final String hometel;
  private final String mobiltel;
  private final String worktel;
  private final String fax;
  private final String email;
  private final String email3;
  private final String email2;
  private final String homepage;

  public ContactsData(int id, String name, String mname, String lname, String nickname, String title, String company, String adress, String hometel, String mobiltel, String worktel, String fax, String email, String email3, String email2, String homepage, String group) {
    this.id = id;
    this.name = name;
    this.mname = mname;
    this.lname = lname;
    this.nickname = nickname;
    this.title = title;
    this.company = company;
    this.adress = adress;
    this.hometel = hometel;
    this.mobiltel = mobiltel;
    this.worktel = worktel;
    this.fax = fax;
    this.email = email;
    this.email3 = email3;
    this.email2 = email2;
    this.homepage = homepage;
    this.group = group;
  }

  public ContactsData(String name, String mname, String lname, String nickname, String title, String company, String adress, String hometel, String mobiltel, String worktel, String fax, String email, String email3, String email2, String homepage, String group) {
    this.id = Integer.MAX_VALUE;
    this.name = name;
    this.mname = mname;
    this.lname = lname;
    this.nickname = nickname;
    this.title = title;
    this.company = company;
    this.adress = adress;
    this.hometel = hometel;
    this.mobiltel = mobiltel;
    this.worktel = worktel;
    this.fax = fax;
    this.email = email;
    this.email3 = email3;
    this.email2 = email2;
    this.homepage = homepage;
    this.group = group;
  }

  public static String getGroup() {
    return group;
  }

  public int getId() {
    return id;
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

  public void setId(int id) {
    this.id = id;
  }
}




