package ru.stqa.pft.mantis.model;

/**
 * Created on 09.07.2017.
 */
public class Project {


  public int getId() {
    return id;
  }

  public Project withId(int id) {
    this.id = id;
    return this;
  }

  private int id;

  public String getName() {
    return name;
  }

  public Project withName(String name) {
    this.name = name;
    return this;
  }

  private String name;
}
